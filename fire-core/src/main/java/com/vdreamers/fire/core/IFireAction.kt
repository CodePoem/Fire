package com.vdreamers.fire.core

/**
 * 日志行为接口 暴露给日志具体实现类 Api
 * <p>
 * date 2021/05/07 00:02:53
 *
 * @author <a href="mailto:codepoetdream@gmail.com">Mr D</a>
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