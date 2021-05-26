package com.vdreamers.fire.sample

import android.util.Log
import com.vdreamers.fire.Flame

class TestFlame : Flame() {
    override fun log(
        priority: Int,
        tag: String?,
        t: Throwable?,
        message: String?,
        custom: Map<String, Any>?
    ) {
        Log.i(tag, "priority = $priority, tag = $tag, t = $t, message = $message, custom = $custom")
    }
}