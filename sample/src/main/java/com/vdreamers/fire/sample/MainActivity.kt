package com.vdreamers.fire.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vdreamers.fire.core.d
import com.vdreamers.fire.core.w

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "MainActivity onCreate".d()
    }

    override fun onStart() {
        super.onStart()
        "MainActivity onStart".d()
    }

    override fun onResume() {
        super.onResume()
        "MainActivity onResume".d()
    }

    override fun onPause() {
        super.onPause()
        "MainActivity onPause".w()
    }

    override fun onStop() {
        super.onStop()
        "MainActivity onStop".w()
    }

    override fun onDestroy() {
        super.onDestroy()
        "MainActivity onDestroy".w()
    }
}