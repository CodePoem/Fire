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

import java.util.*

/**
 * Logging for lazy people.
 * refactor from https://github.com/JakeWharton/timber
 * <p>
 * date 2021/05/26 16:17:27
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Code Poem</a>
 */
@Suppress("unused")
class Fire private constructor() {
    init {
        throw AssertionError()
    }

    companion object Blazing : Flame() {

        /**
         * A view into Fire's burned flames as a flame itself. This can be used for injecting a logger
         * instance rather than using static methods or to facilitate testing.
         */
        @Suppress(
            "NOTHING_TO_INLINE", // Kotlin users should reference `Flame.Blazing` directly.
            "NON_FINAL_MEMBER_IN_OBJECT" // For japicmp check.
        )
        @JvmStatic
        open inline fun asFlame(): Flame = this

        /** Set a one-time tag for use on the next logging call. */
        @JvmStatic
        fun tag(tag: String): Flame {
            for (flame in flamArray) {
                flame.explicitTag.set(tag)
            }
            return this
        }

        /** Set a one-time throwableName for use on the next logging call. */
        @JvmStatic
        fun throwableName(throwableName: String): Flame {
            for (flame in flamArray) {
                flame.explicitThrowableName.set(throwableName)
            }
            return this
        }

        /** Add a new logging flame. */
        @JvmStatic
        fun burn(flames: Flame) {
            require(flames !== this) { "Cannot burn Fire into itself." }
            synchronized(Blazing.flames) {
                Blazing.flames.add(flames)
                flamArray = Blazing.flames.toTypedArray()
            }
        }

        /** Adds new logging flames. */
        @JvmStatic
        fun burn(vararg flames: Flame) {
            for (flame in flames) {
                requireNotNull(flame) { "flames contained null" }
                require(flame !== this) { "Cannot burn Fire into itself." }
            }
            synchronized(Blazing.flames) {
                Collections.addAll(Blazing.flames, *flames)
                flamArray = Blazing.flames.toTypedArray()
            }
        }

        /** Remove a burned flame. */
        @JvmStatic
        fun extinguish(flames: Flame) {
            synchronized(Blazing.flames) {
                require(Blazing.flames.remove(flames)) { "Cannot extinguish flame which is not burned: $flames" }
                flamArray = Blazing.flames.toTypedArray()
            }
        }

        /** Remove all burned flames. */
        @JvmStatic
        fun extinguishAll() {
            synchronized(flames) {
                flames.clear()
                flamArray = emptyArray()
            }
        }

        /** Return a copy of all burned [flames][Flame]. */
        @JvmStatic
        fun blazing(): List<Flame> {
            synchronized(flames) {
                return Collections.unmodifiableList(flames.toList())
            }
        }

        @get:[JvmStatic JvmName("flameCount")]
        val flameCount
            get() = flamArray.size

        // Both fields guarded by 'flames'.
        private val flames = ArrayList<Flame>()

        @Volatile
        private var flamArray = emptyArray<Flame>()

        @JvmStatic
        override fun v(message: String?) {
            flamArray.forEach { it.v(message) }
        }

        @JvmStatic
        override fun v(custom: Map<String, Any>?) {
            flamArray.forEach { it.v(custom) }
        }

        @JvmStatic
        override fun v(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.v(message, custom) }
        }

        @JvmStatic
        override fun v(t: Throwable?, message: String?) {
            flamArray.forEach { it.v(t, message) }
        }

        @JvmStatic
        override fun v(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.v(t, custom) }
        }

        @JvmStatic
        override fun v(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.v(t, message, custom) }
        }

        @JvmStatic
        override fun d(message: String?) {
            flamArray.forEach { it.d(message) }
        }

        @JvmStatic
        override fun d(custom: Map<String, Any>?) {
            flamArray.forEach { it.d(custom) }
        }

        @JvmStatic
        override fun d(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.d(message, custom) }
        }

        @JvmStatic
        override fun d(t: Throwable?, message: String?) {
            flamArray.forEach { it.d(t, message) }
        }

        @JvmStatic
        override fun d(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.d(t, custom) }
        }

        @JvmStatic
        override fun d(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.d(t, message, custom) }
        }

        @JvmStatic
        override fun i(message: String?) {
            flamArray.forEach { it.i(message) }
        }

        @JvmStatic
        override fun i(custom: Map<String, Any>?) {
            flamArray.forEach { it.i(custom) }
        }

        @JvmStatic
        override fun i(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.i(message, custom) }
        }

        @JvmStatic
        override fun i(t: Throwable?, message: String?) {
            flamArray.forEach { it.i(t, message) }
        }

        @JvmStatic
        override fun i(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.i(t, custom) }
        }

        @JvmStatic
        override fun i(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.i(t, message, custom) }
        }

        @JvmStatic
        override fun w(message: String?) {
            flamArray.forEach { it.w(message) }
        }

        @JvmStatic
        override fun w(custom: Map<String, Any>?) {
            flamArray.forEach { it.w(custom) }
        }

        @JvmStatic
        override fun w(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.w(message, custom) }
        }

        @JvmStatic
        override fun w(t: Throwable?, message: String?) {
            flamArray.forEach { it.w(t, message) }
        }

        @JvmStatic
        override fun w(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.w(t, custom) }
        }

        @JvmStatic
        override fun w(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.w(t, message, custom) }
        }

        @JvmStatic
        override fun e(message: String?) {
            flamArray.forEach { it.e(message) }
        }

        @JvmStatic
        override fun e(custom: Map<String, Any>?) {
            flamArray.forEach { it.e(custom) }
        }

        @JvmStatic
        override fun e(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.e(message, custom) }
        }

        @JvmStatic
        override fun e(t: Throwable?, message: String?) {
            flamArray.forEach { it.e(t, message) }
        }

        @JvmStatic
        override fun e(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.e(t, custom) }
        }

        @JvmStatic
        override fun e(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.e(t, message, custom) }
        }

        @JvmStatic
        override fun wtf(message: String?) {
            flamArray.forEach { it.wtf(message) }
        }

        @JvmStatic
        override fun wtf(custom: Map<String, Any>?) {
            flamArray.forEach { it.wtf(custom) }
        }

        @JvmStatic
        override fun wtf(message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.wtf(message, custom) }
        }

        @JvmStatic
        override fun wtf(t: Throwable?, message: String?) {
            flamArray.forEach { it.wtf(t, message) }
        }

        @JvmStatic
        override fun wtf(t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.wtf(t, custom) }
        }

        @JvmStatic
        override fun wtf(t: Throwable?, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.wtf(t, message, custom) }
        }

        @JvmStatic
        override fun log(priority: Int, message: String?, custom: Map<String, Any>?) {
            flamArray.forEach { it.log(priority, message, custom) }
        }

        @JvmStatic
        override fun log(priority: Int, custom: Map<String, Any>?) {
            flamArray.forEach { it.log(priority, custom) }
        }

        @JvmStatic
        override fun log(
            priority: Int,
            t: Throwable?,
            message: String?,
            custom: Map<String, Any>?
        ) {
            flamArray.forEach { it.log(priority, t, message, custom) }
        }

        @JvmStatic
        override fun log(priority: Int, t: Throwable?, custom: Map<String, Any>?) {
            flamArray.forEach { it.log(priority, t, custom) }
        }

        override fun log(
            priority: Int,
            tag: String?,
            t: Throwable?,
            message: String?,
            custom: Map<String, Any>?
        ) {
            throw AssertionError() // Missing override for log method.
        }
    }
}