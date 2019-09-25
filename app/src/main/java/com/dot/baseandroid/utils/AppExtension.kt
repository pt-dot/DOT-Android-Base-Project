package com.dot.baseandroid.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.dot.baseandroid.BuildConfig
import com.dot.baseandroid.R
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

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String) {
    load(imageUrl) {
        crossfade(true)
        placeholder(R.drawable.placeholder_image)
        error(R.drawable.placeholder_image)
    }
}