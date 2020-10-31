package com.dot.baseandroid.networks.rests

import com.dot.baseandroid.menu.gallery.models.GalleryModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiGallery {

    @GET("Gallery_Malang_Batu.json")
    suspend fun getListGallery(): Response<MutableList<GalleryModel>>

}