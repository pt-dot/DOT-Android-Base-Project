package com.dot.baseandroid.menu.list.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class PostModel(
    @SerializedName("userId") @Expose val userId: Int,
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("body") @Expose val body: String,
): Parcelable