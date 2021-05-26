/*
 * Copyright 2021 CodePoem
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vdreamers.fire

import android.os.Build
import android.util.Log
import com.vdreamers.fire.core.FireHelper
import java.util.regex.Pattern

/**
 * default Logger impl for Debug
 * <p>
 * date 2021/05/26 16:16:53
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Code Poem</a>
 */
open class DebugFlame : Flame() {
    private val fqcnIgnore = listOf(
        Fire::class.java.name,
        Fire.Blazing::class.java.name,
        Flame::class.java.name,
        DebugFlame::class.java.name,
        FireHelper::class.java.name,
        FireHelper.FireHelperExt::class.java.name,
        "com.vdreamers.fire.core.LoggerExtKt"
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