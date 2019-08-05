package com.dot.baseandroid.menu.notification.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.paging.NotificationDataSource
import com.dot.baseandroid.menu.notification.paging.NotificationDataSourceFactory
import com.dot.baseandroid.utils.LoadingState

class FragmentNotificationViewModel(application: Application) : AndroidViewModel(application) {

    private var notificationDataSourceFactory: NotificationDataSourceFactory = NotificationDataSourceFactory()
    var notificationList: LiveData<PagedList<NotificationModel>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(false)
            .build()
        notificationList = LivePagedListBuilder(notificationDataSourceFactory, config).build()
    }

    fun getLoadingState(): LiveData<LoadingState> {
        return Transformations.switchMap<NotificationDataSource, LoadingState>(notificationDataSourceFactory.notificationDataSourceLiveData, NotificationDataSource::state)
    }

    fun refreshListNotification() {
        notificationDataSourceFactory.notificationDataSourceLiveData.value?.invalidate()
    }

}