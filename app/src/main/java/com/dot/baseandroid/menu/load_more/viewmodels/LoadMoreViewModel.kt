package com.dot.baseandroid.menu.load_more.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.load_more.paging.PostsDataSource
import kotlinx.coroutines.flow.Flow

class LoadMoreViewModel: ViewModel() {

    private var currentNotificationResult: Flow<PagingData<PostModel>>? = null

    private val pageConfig = PagingConfig(
        pageSize = 20,
        enablePlaceholders = false
    )

    fun loadPaginationData(): Flow<PagingData<PostModel>> {
        val lastResult = currentNotificationResult
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<PostModel>> = Pager(
            config = pageConfig,
            pagingSourceFactory = { PostsDataSource() }
        ).flow.cachedIn(viewModelScope)
        currentNotificationResult = newResult
        return newResult
    }

}