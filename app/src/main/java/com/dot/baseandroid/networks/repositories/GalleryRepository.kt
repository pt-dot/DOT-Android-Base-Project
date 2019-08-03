package com.dot.baseandroid.networks.repositories

import android.content.Context
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.networks.Network
import com.dot.baseandroid.networks.ServiceFactory
import kotlinx.coroutines.CoroutineScope

class GalleryRepository(coroutineScope: CoroutineScope) {

    private val network = Network(coroutineScope)
    private val restApi = ServiceFactory.create()

    fun getListGallery(context: Context, onSuccess: (MutableList<GalleryModel>?) -> Unit, onFinally:(Boolean) -> Unit) {
        network.request(context, {
            restApi.getListGallery()
        }, {
            onSuccess(it)
        }, {
            onFinally(true)
        })
    }
}