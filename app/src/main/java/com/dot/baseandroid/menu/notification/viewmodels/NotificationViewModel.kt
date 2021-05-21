package com.dot.baseandroid.menu.notification.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.paging.NotificationDataSource
import com.dot.baseandroid.menu.notification.paging.NotificationDataSourceFactory
import com.dot.baseandroid.networks.repositories.NotificationRepository
import com.dot.baseandroid.utils.LoadingState
import kotlinx.coroutines.flow.Flow

class NotificationViewModel: ViewModel() {

    private val repoNotification = NotificationRepository()
    private var notificationDataSourceFactory: NotificationDataSourceFactory = NotificationDataSourceFactory()
    var notificationList: LiveData<PagedList<NotificationModel>>

    private var newListNotification: Flow<PagingData<NotificationModel>>? = null
    private var currentNotificationResult: Flow<PagingData<NotificationModel>>? = null

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(5)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(false)
            .build()
        notificationList = LivePagedListBuilder(notificationDataSourceFactory, config).build()
    }

    fun loadPaginationData(): Flow<PagingData<NotificationModel>> {
        val lastResult = currentNotificationResult
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<NotificationModel>> = repoNotification.getNotificationStream().cachedIn(viewModelScope)
        currentNotificationResult = newResult
        return newResult
    }

    fun getLoadingState(): LiveData<LoadingState> {
        return Transformations.switchMap(notificationDataSourceFactory.notificationDataSourceLiveData, NotificationDataSource::state)
    }

    fun refreshListNotification() {
        notificationDataSourceFactory.notificationDataSourceLiveData.value?.invalidate()
    }

}