package com.card.business.android

import PlatformConfiguration
import android.app.Application
import di.InitSdk

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        InitSdk.init(
            PlatformConfiguration(
                androidContext = this
            )
        )
    }
}