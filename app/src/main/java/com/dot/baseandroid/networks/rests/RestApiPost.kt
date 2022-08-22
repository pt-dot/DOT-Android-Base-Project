package com.dot.baseandroid.networks.rests

import com.dot.baseandroid.menu.list.models.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiPost {

    @GET("posts")
    suspend fun getPosts(): Response<MutableList<PostModel>>

}