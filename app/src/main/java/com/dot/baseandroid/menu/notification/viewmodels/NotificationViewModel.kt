package com.dot.baseandroid.menu.notification.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.paging.NotificationDataSource
import kotlinx.coroutines.flow.Flow

class NotificationViewModel: ViewModel() {

    private var currentNotificationResult: Flow<PagingData<NotificationModel>>? = null

    private val pageConfig = PagingConfig(
        pageSize = 20,
        enablePlaceholders = false
    )

    fun loadPaginationData(): Flow<PagingData<NotificationModel>> {
        val lastResult = currentNotificationResult
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<NotificationModel>> = Pager(
            config = pageConfig,
            pagingSourceFactory = { NotificationDataSource() }
        ).flow.cachedIn(viewModelScope)
        currentNotificationResult = newResult
        return newResult
    }

}