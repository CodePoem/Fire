package com.vdreamers.fire

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        this.initLogger(BuildConfig.DEBUG)
    }
}