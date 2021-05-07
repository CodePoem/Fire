package com.vdreamers.fire.sample

import android.app.Application
import com.vdreamers.fire.DebugFlame
import com.vdreamers.fire.Fire
import com.vdreamers.fire.core.FireHelper
import com.vdreamers.fire.core.initLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        this.initLogger {
            FireHelper.setLogger(Fire)
            val isDebug = BuildConfig.DEBUG
            if (isDebug) {
                Fire.burn(DebugFlame())
            } else {
                Fire.burn(DebugFlame())
                // can burn other flame
            }
        }
    }
}