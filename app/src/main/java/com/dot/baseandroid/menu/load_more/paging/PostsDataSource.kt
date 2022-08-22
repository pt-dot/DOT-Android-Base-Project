package com.dot.baseandroid.menu.load_more.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.networks.ServiceFactory
import com.dot.baseandroid.networks.rests.RestApiPost

/**
 * https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data#pagingsource
 */
class PostsDataSource: PagingSource<Int, PostModel>() {

    private val restApi = ServiceFactory.getApiService(RestApiPost::class.java)

    override fun getRefreshKey(state: PagingState<Int, PostModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostModel> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = restApi.getPagingPosts(nextPageNumber)
            val theData = response.body()
            return LoadResult.Page(
                data = theData?.toList() ?: mutableListOf(),
                prevKey = null,
                nextKey = if (theData.isNullOrEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}