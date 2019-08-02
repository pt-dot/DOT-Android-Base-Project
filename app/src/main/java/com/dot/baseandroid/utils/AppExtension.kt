package com.dot.baseandroid.utils

import android.util.Log
import com.dot.baseandroid.BuildConfig
import com.dot.baseandroid.data.Constants

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) Log.d(Constants.TAG_DEBUG, message)
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) Log.e(Constants.TAG_ERROR, message)
}