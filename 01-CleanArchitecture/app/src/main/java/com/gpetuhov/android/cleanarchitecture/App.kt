package com.gpetuhov.android.cleanarchitecture

import android.app.Application
import com.gpetuhov.android.cleanarchitecture.utils.Logger

// Don't forget to register application in the manifest
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init(applicationContext)
    }
}