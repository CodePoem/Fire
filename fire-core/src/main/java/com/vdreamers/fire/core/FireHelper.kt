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
 * Log Helper
 * <p>
 * date 2021/05/26 16:09:21
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Code Poem</a>
 */
class FireHelper {

    companion object FireHelperExt : IFireAbility {
        private var fireAbility: IFireAbility? = null

        fun setLogger(fireAbility: IFireAbility) {
            FireHelperExt.fireAbility = fireAbility
        }

        override fun v(message: String?) {
            fireAbility?.v(message)
        }

        override fun v(custom: Map<String, Any>?) {
            fireAbility?.v(custom)
        }

        override fun v(message: String?, custom: Map<String, Any>?) {
            fireAbility?.v(message, custom)
        }

        override fun v(t: Throwable?, message: String?) {
            fireAbility?.v(t, message)
        }

        override fun v(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.v(t, custom)
        }

        override fun v(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.v(t, message, custom)
        }

        override fun d(message: String?) {
            fireAbility?.d(message)
        }

        override fun d(custom: Map<String, Any>?) {
            fireAbility?.d(custom)
        }

        override fun d(message: String?, custom: Map<String, Any>?) {
            fireAbility?.d(message, custom)
        }

        override fun d(t: Throwable?, message: String?) {
            fireAbility?.d(t, message)
        }

        override fun d(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.d(t, custom)
        }

        override fun d(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.d(t, message, custom)
        }

        override fun i(message: String?) {
            fireAbility?.i(message)
        }

        override fun i(custom: Map<String, Any>?) {
            fireAbility?.i(custom)
        }

        override fun i(message: String?, custom: Map<String, Any>?) {
            fireAbility?.i(message, custom)
        }

        override fun i(t: Throwable?, message: String?) {
            fireAbility?.i(t, message)
        }

        override fun i(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.i(t, custom)
        }

        override fun i(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.i(t, message, custom)
        }

        override fun w(message: String?) {
            fireAbility?.w(message)
        }

        override fun w(custom: Map<String, Any>?) {
            fireAbility?.w(custom)
        }

        override fun w(message: String?, custom: Map<String, Any>?) {
            fireAbility?.w(message, custom)
        }

        override fun w(t: Throwable?, message: String?) {
            fireAbility?.w(t, message)
        }

        override fun w(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.w(t, custom)
        }

        override fun w(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.w(t, message, custom)
        }

        override fun e(message: String?) {
            fireAbility?.e(message)
        }

        override fun e(custom: Map<String, Any>?) {
            fireAbility?.e(custom)
        }

        override fun e(message: String?, custom: Map<String, Any>?) {
            fireAbility?.e(message, custom)
        }

        override fun e(t: Throwable?, message: String?) {
            fireAbility?.e(t, message)
        }

        override fun e(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.e(t, custom)
        }

        override fun e(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.e(t, message, custom)
        }

        override fun wtf(message: String?) {
            fireAbility?.wtf(message)
        }

        override fun wtf(custom: Map<String, Any>?) {
            fireAbility?.wtf(custom)
        }

        override fun wtf(message: String?, custom: Map<String, Any>?) {
            fireAbility?.wtf(message, custom)
        }

        override fun wtf(t: Throwable?, message: String?) {
            fireAbility?.wtf(t, message)
        }

        override fun wtf(t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.wtf(t, custom)
        }

        override fun wtf(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            fireAbility?.wtf(t, message, custom)
        }

        override fun log(priority: Int, message: String?, custom: Map<String, Any>?) {
            fireAbility?.log(priority, message, custom)
        }

        override fun log(priority: Int, custom: Map<String, Any>?) {
            fireAbility?.log(priority, custom)
        }

        override fun log(
            priority: Int,
            t: Throwable?,
            message: String?,
            custom: Map<String, Any>?
        ) {
            fireAbility?.log(priority, t, message, custom)
        }

        override fun log(priority: Int, t: Throwable?, custom: Map<String, Any>?) {
            fireAbility?.log(priority, t, custom)
        }
    }
}