package com.vdreamers.fire

import android.os.Build
import android.util.Log
import java.util.regex.Pattern

open class DebugFlame : Flame() {
    private val fqcnIgnore = listOf(
        Fire::class.java.name,
        Fire::class.java.name,
        Flame::class.java.name,
        DebugFlame::class.java.name
    )

    override val tag: String?
        get() = super.tag ?: Throwable().stackTrace
            .first { it.className !in fqcnIgnore }
            .let(::createStackElementTag)

    override val throwableName: String
        get() = if (super.throwableName == DEFAULT_THROWABLE_NAME) {
            "debugError"
        } else {
            super.throwableName
        }

    override fun log(
        priority: Int,
        tag: String?,
        t: Throwable?,
        message: String?,
        custom: Map<String, Any>?
    ) {
        val messageStringBuilder = StringBuilder()
        if (!message.isNullOrBlank()) {
            if (!messageStringBuilder.isBlank()) {
                messageStringBuilder.append(" ")
            }
            messageStringBuilder.append(message)
        }
        if (!custom.isNullOrEmpty()) {
            if (!messageStringBuilder.isBlank()) {
                messageStringBuilder.append(" ")
            }
            messageStringBuilder.append(custom)
        }
        logHuge(priority, messageStringBuilder.toString())
    }

    /**
     * Extract the tag which should be used for the message from the `element`. By default
     * this will use the class name without any anonymous class suffixes (e.g., `Foo$1`
     * becomes `Foo`).
     *
     * Note: This will not be called if a [manual tag][.tag] was specified.
     */
    protected open fun createStackElementTag(element: StackTraceElement): String? {
        var tag = element.className.substringAfterLast('.')
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        // Tag length limit was removed in API 24.
        return if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    /**
     * log huge message string
     *
     * [priority] Int
     * [message] String
     */
    private fun logHuge(priority: Int, message: String) {
        if (message.length < MAX_LOG_LENGTH) {
            if (priority == Log.ASSERT) {
                Log.wtf(tag, message)
            } else {
                Log.println(priority, tag, message)
            }
            return
        }

        // Split by line, then ensure each line can fit into Log's maximum length.
        var i = 0
        val length = message.length
        while (i < length) {
            var newline = message.indexOf('\n', i)
            newline = if (newline != -1) newline else length
            do {
                val end = Math.min(newline, i + MAX_LOG_LENGTH)
                val part = message.substring(i, end)
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, part)
                } else {
                    Log.println(priority, tag, part)
                }
                i = end
            } while (i < newline)
            i++
        }
    }

    companion object {
        private const val MAX_LOG_LENGTH = 4000
        private const val MAX_TAG_LENGTH = 23
        private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")
    }
}