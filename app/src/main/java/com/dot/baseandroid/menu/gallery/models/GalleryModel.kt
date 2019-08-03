package com.dot.baseandroid.menu.gallery.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class GalleryModel(
    @SerializedName("caption") @Expose val caption: String,
    @SerializedName("thumbnail") @Expose val thumbnail: String,
    @SerializedName("image") @Expose val image: String
)