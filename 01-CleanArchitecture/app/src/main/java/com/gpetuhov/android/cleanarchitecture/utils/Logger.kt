package com.gpetuhov.android.cleanarchitecture.utils

import android.content.Context
import com.gpetuhov.android.cleanarchitecture.BuildConfig
import timber.log.Timber

// This class isolates logging library from the other project
// and makes it easy to swap the logging library (Timber in this example)
// for something else, if needed.
class Logger {
    companion object {
        fun init(applicationContext: Context) {
            if (BuildConfig.DEBUG) {
                Timber.plant(Timber.DebugTree())
            }
        }

        fun log(tag: String, message: String) = Timber.tag(tag).d(message)

        fun error(tag: String, message: String) = Timber.tag(tag).e(message)
    }
}