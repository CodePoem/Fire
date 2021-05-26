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

package com.vdreamers.fire.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vdreamers.fire.core.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logWtf("MainActivity onCreate")
        logV("MainActivity I am v")
        logD("MainActivity I am d")

        val custom: MutableMap<String, Any> = mutableMapOf()
        custom["custom"] = "custom"
        custom["num"] = 1
        custom["list"] = listOf(1, 2, 3)
        logI(custom)

        logE(IllegalArgumentException("test error"), "illegal argument message")
    }

    override fun onStart() {
        super.onStart()
        logW("MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        logI("MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        logI("MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        logW("MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logWtf("MainActivity onDestroy")
    }
}