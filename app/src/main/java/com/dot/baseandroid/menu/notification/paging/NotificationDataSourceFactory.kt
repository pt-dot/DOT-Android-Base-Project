package com.dot.baseandroid.menu.notification.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dot.baseandroid.menu.notification.models.NotificationModel

class NotificationDataSourceFactory: DataSource.Factory<Int, NotificationModel> () {

    val notificationDataSourceLiveData: MutableLiveData<NotificationDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, NotificationModel> {
        val notificationDataSource = NotificationDataSource()
        notificationDataSourceLiveData.postValue(notificationDataSource)
        return notificationDataSource
    }
}