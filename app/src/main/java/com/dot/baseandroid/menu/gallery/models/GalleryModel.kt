package com.dot.baseandroid.menu.gallery.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class GalleryModel(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("thumbnailUrl") @Expose val thumbnail: String
): Parcelable