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

package com.vdreamers.fire.core

/**
 * Log Ability interface exposed Api
 * <p>
 * date 2021/05/26 16:14:11
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Code Poem</a>
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