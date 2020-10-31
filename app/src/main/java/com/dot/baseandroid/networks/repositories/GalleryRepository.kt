package com.dot.baseandroid.networks.repositories

import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.networks.SafeApiRequest
import com.dot.baseandroid.networks.ServiceFactory
import com.dot.baseandroid.networks.rests.RestApiGallery
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GalleryRepository(private val scope: CoroutineScope): SafeApiRequest() {

    private val restApi = ServiceFactory.getApiService(RestApiGallery::class.java)

    fun getListGallery(onSuccess: (MutableList<GalleryModel>?) -> Unit, onError:(Exception) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getListGallery() }
                onSuccess(result)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}