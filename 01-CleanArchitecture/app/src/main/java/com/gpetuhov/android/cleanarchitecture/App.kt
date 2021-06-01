package com.gpetuhov.android.cleanarchitecture

import android.app.Application
import com.gpetuhov.android.cleanarchitecture.di.components.AppComponent
import com.gpetuhov.android.cleanarchitecture.di.components.DaggerAppComponent
import com.gpetuhov.android.cleanarchitecture.utils.Logger

// Don't forget to register application in the manifest
class App: Application() {

    companion object {
        lateinit var application: App
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Logger.init(applicationContext)

        application = this
        appComponent = DaggerAppComponent.builder().build()
    }
}