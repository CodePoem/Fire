package com.vdreamers.fire

import android.util.Log
import com.vdreamers.fire.core.IFireAbility
import com.vdreamers.fire.core.IFireAction
import java.io.PrintWriter
import java.io.StringWriter

 abstract class Flame : IFireAbility, IFireAction {
    @get:JvmSynthetic // Hide from public API.
    internal val explicitTag = ThreadLocal<String>()

    @get:JvmSynthetic // Hide from public API.
    internal open val tag: String?
        get() {
            val tag = explicitTag.get()
            if (tag != null) {
                explicitTag.remove()
            }
            return tag
        }

    @get:JvmSynthetic // Hide from public API.
    internal val explicitThrowableName = ThreadLocal<String>()

    @get:JvmSynthetic // Hide from public API.
    internal open val throwableName: String
        get() {
            val throwableName = explicitThrowableName.get()
            if (throwableName != null) {
                explicitThrowableName.remove()
            }
            return throwableName ?: DEFAULT_THROWABLE_NAME
        }

    /** Return whether a message at `priority` or `tag` or `customInfo` should be logged. */
    protected open fun isLoggable(
        priority: Int,
        tag: String?,
        message: String?,
        custom: Map<String, Any>?
    ) = true

    private fun prepareLog(
        priority: Int,
        t: Throwable?,
        message: String?,
        custom: Map<String, Any>?
    ) {
        // Consume tag even when message is not loggable so that next message is correctly tagged.
        val tag = tag
        val throwableName = throwableName
        if (!isLoggable(priority, tag, message, custom)) {
            return
        }

        var messageFinal = message
        val customFinal: MutableMap<String, Any> = custom?.toMutableMap() ?: mutableMapOf()
        if (messageFinal.isNullOrEmpty()) {
            if (t != null) {
                messageFinal = getStackTraceString(t)
                customFinal[throwableName] = getStackTraceString(t)
            }
        } else {
            if (t != null) {
                messageFinal += "\n" + getStackTraceString(t)
            }
        }

        log(priority, tag, t, messageFinal, customFinal)
    }

    private fun getStackTraceString(t: Throwable): String {
        // Don't replace this with Log.getStackTraceString() - it hides
        // UnknownHostException, which is not what we want.
        val sw = StringWriter(256)
        val pw = PrintWriter(sw, false)
        t.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }

    /**
     * Write a log message to its destination. Called for all level-specific methods by default.
     *
     * @param priority Log level. See [Log] for constants.
     * @param tag Explicit or inferred tag. May be `null`.
     * @param message Formatted log message.
     * @param t Accompanying exceptions. May be `null`.
     */
    abstract override fun log(
        priority: Int,
        tag: String?,
        t: Throwable?,
        message: String?,
        custom: Map<String, Any>?
    )

    companion object {
        /** default throwable name */
        const val DEFAULT_THROWABLE_NAME = "error"
    }

    override fun v(message: String?) {
        prepareLog(Log.VERBOSE, null, message, null)
    }

    override fun v(custom: Map<String, Any>?) {
        prepareLog(Log.VERBOSE, null, null, custom)
    }

    override fun v(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.VERBOSE, null, message, custom)
    }

    override fun v(t: Throwable?, message: String?) {
        prepareLog(Log.VERBOSE, t, message, null)
    }

    override fun v(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.VERBOSE, t, null, custom)
    }

    override fun v(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.VERBOSE, t, message, custom)
    }

    override fun d(message: String?) {
        prepareLog(Log.DEBUG, null, message, null)
    }

    override fun d(custom: Map<String, Any>?) {
        prepareLog(Log.DEBUG, null, null, custom)
    }

    override fun d(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.DEBUG, null, message, custom)
    }

    override fun d(t: Throwable?, message: String?) {
        prepareLog(Log.DEBUG, t, message, null)
    }

    override fun d(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.DEBUG, t, null, custom)
    }

    override fun d(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.DEBUG, t, message, custom)
    }

    override fun i(message: String?) {
        prepareLog(Log.INFO, null, message, null)
    }

    override fun i(custom: Map<String, Any>?) {
        prepareLog(Log.INFO, null, null, custom)
    }

    override fun i(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.INFO, null, message, custom)
    }

    override fun i(t: Throwable?, message: String?) {
        prepareLog(Log.INFO, t, message, null)
    }

    override fun i(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.INFO, t, null, custom)
    }

    override fun i(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.INFO, t, message, custom)
    }

    override fun w(message: String?) {
        prepareLog(Log.WARN, null, message, null)
    }

    override fun w(custom: Map<String, Any>?) {
        prepareLog(Log.WARN, null, null, custom)
    }

    override fun w(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.WARN, null, message, custom)
    }

    override fun w(t: Throwable?, message: String?) {
        prepareLog(Log.WARN, t, message, null)
    }

    override fun w(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.WARN, t, null, custom)
    }

    override fun w(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.WARN, t, message, custom)
    }

    override fun e(message: String?) {
        prepareLog(Log.ERROR, null, message, null)
    }

    override fun e(custom: Map<String, Any>?) {
        prepareLog(Log.ERROR, null, null, custom)
    }

    override fun e(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.ERROR, null, message, custom)
    }

    override fun e(t: Throwable?, message: String?) {
        prepareLog(Log.ERROR, t, message, null)
    }

    override fun e(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.ERROR, t, null, custom)
    }

    override fun e(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.ERROR, t, message, custom)
    }

    override fun wtf(message: String?) {
        prepareLog(Log.ASSERT, null, message, null)
    }

    override fun wtf(custom: Map<String, Any>?) {
        prepareLog(Log.ASSERT, null, null, custom)
    }

    override fun wtf(message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.ASSERT, null, message, custom)
    }

    override fun wtf(t: Throwable?, message: String?) {
        prepareLog(Log.ASSERT, t, message, null)
    }

    override fun wtf(t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(Log.ASSERT, t, null, custom)
    }

    override fun wtf(t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(Log.ASSERT, t, message, custom)
    }

    override fun log(priority: Int, message: String?, custom: Map<String, Any>?) {
        prepareLog(priority, null, message, custom)
    }

    override fun log(priority: Int, custom: Map<String, Any>?) {
        prepareLog(priority, null, null, custom)
    }

    override fun log(priority: Int, t: Throwable?, message: String?, custom: Map<String, Any>?) {
        prepareLog(priority, t, message, custom)
    }

    override fun log(priority: Int, t: Throwable?, custom: Map<String, Any>?) {
        prepareLog(priority, t, null, custom)
    }
}