package com.dot.baseandroid.networks.repositories

import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.networks.SafeApiRequest
import com.dot.baseandroid.networks.ServiceFactory
import com.dot.baseandroid.networks.rests.RestApiPost
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PostRepository(private val scope: CoroutineScope): SafeApiRequest() {

    private val restApi = ServiceFactory.getApiService(RestApiPost::class.java)

    fun getPosts(onSuccess: (MutableList<PostModel>?) -> Unit, onError:(Exception) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getPosts() }
                onSuccess(result)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}