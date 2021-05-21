package com.dot.baseandroid.menu.notification.paging

import android.os.SystemClock
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dot.baseandroid.data.Constants
import com.dot.baseandroid.menu.notification.models.NotificationModel

class NewNotificationDataSource: PagingSource<Int, NotificationModel>() {

    private var listNotification: MutableList<NotificationModel> = mutableListOf()

    override fun getRefreshKey(state: PagingState<Int, NotificationModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NotificationModel> {
        try {
            listNotification.clear()
            val nextPageNumber = params.key ?: 1
            for (i:Int in 1..20) {
                listNotification.add(NotificationModel(i, "Notification # $i"))
            }
            return LoadResult.Page(
                data = listNotification,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}