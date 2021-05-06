package com.vdreamers.fire.core

/**
 * 日志能力接口 暴露给业务调用方 Api
 * <p>
 * date 2021/05/07 00:02:13
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr D</a>
 */
interface IFireAbility {

    fun v(message: String?)

    fun v(custom: Map<String, Any>?)

    fun v(message: String?, custom: Map<String, Any>?)

    fun v(t: Throwable?, message: String?)

    fun v(t: Throwable?, custom: Map<String, Any>?)

    fun v(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun d(message: String?)

    fun d(custom: Map<String, Any>?)

    fun d(message: String?, custom: Map<String, Any>?)

    fun d(t: Throwable?, message: String?)

    fun d(t: Throwable?, custom: Map<String, Any>?)

    fun d(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun i(message: String?)

    fun i(custom: Map<String, Any>?)

    fun i(message: String?, custom: Map<String, Any>?)

    fun i(t: Throwable?, message: String?)

    fun i(t: Throwable?, custom: Map<String, Any>?)

    fun i(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun w(message: String?)

    fun w(custom: Map<String, Any>?)

    fun w(message: String?, custom: Map<String, Any>?)

    fun w(t: Throwable?, message: String?)

    fun w(t: Throwable?, custom: Map<String, Any>?)

    fun w(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun e(message: String?)

    fun e(custom: Map<String, Any>?)

    fun e(message: String?, custom: Map<String, Any>?)

    fun e(t: Throwable?, message: String?)

    fun e(t: Throwable?, custom: Map<String, Any>?)

    fun e(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun wtf(message: String?)

    fun wtf(custom: Map<String, Any>?)

    fun wtf(message: String?, custom: Map<String, Any>?)

    fun wtf(t: Throwable?, message: String?)

    fun wtf(t: Throwable?, custom: Map<String, Any>?)

    fun wtf(t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun log(priority: Int, message: String?, custom: Map<String, Any>?)

    fun log(priority: Int, custom: Map<String, Any>?)

    fun log(priority: Int, t: Throwable?, message: String?, custom: Map<String, Any>?)

    fun log(priority: Int, t: Throwable?, custom: Map<String, Any>?)
}