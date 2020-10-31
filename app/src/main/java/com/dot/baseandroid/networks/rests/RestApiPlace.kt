package com.dot.baseandroid.networks.rests

import com.dot.baseandroid.menu.list.models.PlaceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiPlace {

    @GET("List_place_malang_batu.json")
    suspend fun getListPlace(): Response<MutableList<PlaceModel>>

}