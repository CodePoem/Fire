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

fun Map<String, Any>.d() = FireHelper.d(this)

fun String.d() = FireHelper.d(this)

fun String.d(custom: Map<String, Any>) = FireHelper.d(this, custom)

fun Throwable.d() = FireHelper.d(this, "")

fun Throwable.d(message: String) = FireHelper.d(this, message)

fun Throwable.d(custom: Map<String, Any>) = FireHelper.d(this, custom)

fun Map<String, Any>.i() = FireHelper.i(this)

fun String.i() = FireHelper.i(this)

fun String.i(custom: Map<String, Any>) = FireHelper.i(this, custom)

fun Throwable.i() = FireHelper.i(this, "")

fun Throwable.i(message: String) = FireHelper.i(this, message)

fun Throwable.i(custom: Map<String, Any>) = FireHelper.i(this, custom)

fun Map<String, Any>.w() = FireHelper.w(this)

fun String.w() = FireHelper.w(this)

fun String.w(custom: Map<String, Any>) = FireHelper.w(this, custom)

fun Throwable.w() = FireHelper.w(this, "")

fun Throwable.w(message: String) = FireHelper.w(this, message)

fun Throwable.w(custom: Map<String, Any>) = FireHelper.w(this, custom)

fun Map<String, Any>.e() = FireHelper.e(this)

fun String.e() = FireHelper.e(this)

fun String.e(custom: Map<String, Any>) = FireHelper.e(this, custom)

fun Throwable.e() = FireHelper.e(this, "")

fun Throwable.e(message: String) = FireHelper.e(this, message)

fun Throwable.e(custom: Map<String, Any>) = FireHelper.e(this, custom)

fun Throwable.e(message: String, custom: Map<String, Any>) = FireHelper.e(this, message, custom)