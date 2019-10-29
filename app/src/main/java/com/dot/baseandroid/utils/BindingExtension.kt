package com.dot.baseandroid.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.dot.baseandroid.R

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String) {
    load(imageUrl) {
        crossfade(true)
        placeholder(R.drawable.placeholder_image)
        error(R.drawable.placeholder_image)
    }
}