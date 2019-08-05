package com.dot.baseandroid.menu.notification.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class NotificationModel(
    val message: String
): Parcelable