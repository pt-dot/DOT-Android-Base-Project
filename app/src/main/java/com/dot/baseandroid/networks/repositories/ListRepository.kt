package com.dot.baseandroid.networks.repositories

import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.networks.SafeApiRequest
import com.dot.baseandroid.networks.ServiceFactory
import com.dot.baseandroid.networks.rests.RestApiPlace
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListRepository(private val scope: CoroutineScope): SafeApiRequest() {

    private val restApi = ServiceFactory.getApiService(RestApiPlace::class.java)

    fun getListPlace(onSuccess: (MutableList<PlaceModel>?) -> Unit, onError:(Exception) -> Unit) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getListPlace() }
                onSuccess(result)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    onError(e)
                }
            }
        }
    }
}