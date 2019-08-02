package com.dot.baseandroid

import android.app.Application
import com.dot.baseandroid.utils.logDebug

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        logDebug("App # onCreate")
    }
}