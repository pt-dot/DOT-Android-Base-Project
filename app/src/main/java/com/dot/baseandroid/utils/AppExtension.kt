package com.dot.baseandroid.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.dot.baseandroid.BuildConfig
import com.dot.baseandroid.data.*

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) Log.d(TAG_DEBUG, message)
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) Log.e(TAG_ERROR, message)
}

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}