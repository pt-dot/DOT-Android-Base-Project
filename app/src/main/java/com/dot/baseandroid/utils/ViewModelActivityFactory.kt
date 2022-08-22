package com.dot.baseandroid.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.viewmodels.DetailNotificationViewModel

class ViewModelActivityFactory(private val application: Application, private val any: Any): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == DetailNotificationViewModel::class.java) {
            return DetailNotificationViewModel(application, any as NotificationModel) as T
        }
        return super.create(modelClass)
    }

}