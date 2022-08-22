package com.dot.baseandroid.networks.rests

import com.dot.baseandroid.menu.gallery.models.GalleryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiGallery {

    @GET("photos")
    suspend fun getListGallery(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 50,
    ): Response<MutableList<GalleryModel>>

}