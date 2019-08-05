package com.dot.baseandroid.menu.notification.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.notification.models.NotificationModel

class ItemNotificationViewModel(notificationModel: NotificationModel): ViewModel() {

    var message: ObservableField<String> = ObservableField(notificationModel.message)

}