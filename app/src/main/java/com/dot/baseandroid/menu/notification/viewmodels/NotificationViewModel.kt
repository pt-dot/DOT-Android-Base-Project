package com.dot.baseandroid.menu.notification.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.networks.repositories.NotificationRepository
import kotlinx.coroutines.flow.Flow

class NotificationViewModel: ViewModel() {

    private val repoNotification = NotificationRepository()

    private var currentNotificationResult: Flow<PagingData<NotificationModel>>? = null

    fun loadPaginationData(): Flow<PagingData<NotificationModel>> {
        val lastResult = currentNotificationResult
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<NotificationModel>> = repoNotification.getNotificationStream().cachedIn(viewModelScope)
        currentNotificationResult = newResult
        return newResult
    }

}