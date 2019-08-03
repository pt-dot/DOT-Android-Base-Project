package com.dot.baseandroid.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.dot.baseandroid.BuildConfig
import com.dot.baseandroid.data.Constants

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) Log.d(Constants.TAG_DEBUG, message)
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) Log.e(Constants.TAG_ERROR, message)
}

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}