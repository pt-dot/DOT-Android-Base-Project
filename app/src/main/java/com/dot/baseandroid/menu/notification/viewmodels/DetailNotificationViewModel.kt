package com.dot.baseandroid.menu.notification.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.dot.baseandroid.menu.notification.models.NotificationModel

class DetailNotificationViewModel(application: Application, notificationModel: NotificationModel) : AndroidViewModel(application) {

    var message: ObservableField<String> = ObservableField(notificationModel.message)

}