@file:Suppress("unused")

package com.vdreamers.fire.core

import android.app.Application
import android.util.Log

typealias InitAction = () -> Unit

fun Application.initLogger(initAction: InitAction?) {
    try {
        initAction?.invoke()
    } catch (e: Exception) {
        Log.d("LoggerExt", "initLogger error: ${e.message}")
    }
}

fun logV(message: String?) = FireHelper.v(message)

fun logV(custom: Map<String, Any>?) = FireHelper.v(custom)

fun logV(message: String?, custom: Map<String, Any>?) = FireHelper.v(message, custom)

fun logV(t: Throwable?, message: String?) = FireHelper.v(t, message)

fun logV(t: Throwable?, custom: Map<String, Any>?) = FireHelper.v(t, custom)

fun logV(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.v(t, message, custom)

fun logD(message: String?) = FireHelper.d(message)

fun logD(custom: Map<String, Any>?) = FireHelper.d(custom)

fun logD(message: String?, custom: Map<String, Any>?) = FireHelper.d(message, custom)

fun logD(t: Throwable?, message: String?) = FireHelper.d(t, message)

fun logD(t: Throwable?, custom: Map<String, Any>?) = FireHelper.d(t, custom)

fun logD(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.d(t, message, custom)

fun logI(message: String?) = FireHelper.i(message)

fun logI(custom: Map<String, Any>?) = FireHelper.i(custom)

fun logI(message: String?, custom: Map<String, Any>?) = FireHelper.i(message, custom)

fun logI(t: Throwable?, message: String?) = FireHelper.i(t, message)

fun logI(t: Throwable?, custom: Map<String, Any>?) = FireHelper.i(t, custom)

fun logI(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.i(t, message, custom)

fun logW(message: String?) = FireHelper.w(message)

fun logW(custom: Map<String, Any>?) = FireHelper.w(custom)

fun logW(message: String?, custom: Map<String, Any>?) = FireHelper.w(message, custom)

fun logW(t: Throwable?, message: String?) = FireHelper.w(t, message)

fun logW(t: Throwable?, custom: Map<String, Any>?) = FireHelper.w(t, custom)

fun logW(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.w(t, message, custom)

fun logE(message: String?) = FireHelper.e(message)

fun logE(custom: Map<String, Any>?) = FireHelper.e(custom)

fun logE(message: String?, custom: Map<String, Any>?) = FireHelper.e(message, custom)

fun logE(t: Throwable?, message: String?) = FireHelper.e(t, message)

fun logE(t: Throwable?, custom: Map<String, Any>?) = FireHelper.e(t, custom)

fun logE(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.e(t, message, custom)

fun logWtf(message: String?) = FireHelper.wtf(message)

fun logWtf(custom: Map<String, Any>?) = FireHelper.wtf(custom)

fun logWtf(message: String?, custom: Map<String, Any>?) = FireHelper.wtf(message, custom)

fun logWtf(t: Throwable?, message: String?) = FireHelper.wtf(t, message)

fun logWtf(t: Throwable?, custom: Map<String, Any>?) = FireHelper.wtf(t, custom)

fun logWtf(t: Throwable?, message: String?, custom: Map<String, Any>?) =
    FireHelper.wtf(t, message, custom)