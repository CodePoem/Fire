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
                Fire.burn(TestFlame())
            } else {
                Fire.burn(TestFlame())
                // can burn other flame
            }
        }
    }
}