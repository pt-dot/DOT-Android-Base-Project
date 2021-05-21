package com.dot.baseandroid.networks.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.paging.NewNotificationDataSource
import kotlinx.coroutines.flow.Flow

class NotificationRepository {

    fun getNotificationStream(): Flow<PagingData<NotificationModel>> {
        return Pager(
            config = PagingConfig(20, enablePlaceholders = false),
            pagingSourceFactory = { NewNotificationDataSource() }
        ).flow
    }

}