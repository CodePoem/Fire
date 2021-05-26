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
 * Log Action interface exposed Log final impl Api
 * <p>
 * date 2021/05/26 16:15:03
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Code Poem</a>
 */
interface IFireAction {

    /**
     * 日志行为（message 为字符串）
     *  [priority] Int 优先级
     *  [tag] String? 标记
     *  [custom] Map<String, Any> 自定义信息
     *  [message] String 消息内容
     *  [t] Throwable? 异常信息
     */
    fun log(
        priority: Int,
        tag: String?,
        t: Throwable?,
        message: String?,
        custom: Map<String, Any>?
    )
}