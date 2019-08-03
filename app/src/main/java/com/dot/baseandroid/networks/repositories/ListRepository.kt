package com.dot.baseandroid.networks.repositories

import android.content.Context
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.networks.Network
import com.dot.baseandroid.networks.ServiceFactory
import kotlinx.coroutines.CoroutineScope

class ListRepository(coroutineScope: CoroutineScope) {

    private val network = Network(coroutineScope)
    private val restApi = ServiceFactory.create()

    fun getListPlace(context: Context, onSuccess: (MutableList<PlaceModel>?) -> Unit, onFinally:(Boolean) -> Unit) {
        network.request(context, {
            restApi.getListPlace()
        }, {
            onSuccess(it)
        }, {
            onFinally(true)
        })
    }
}