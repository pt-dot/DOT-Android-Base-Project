package com.dot.baseandroid.networks

import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.list.models.PlaceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET("List_place_malang_batu.json")
    suspend fun getListPlace():Response<MutableList<PlaceModel>>

    @GET("Gallery_Malang_Batu.json")
    suspend fun getListGallery():Response<MutableList<GalleryModel>>

}