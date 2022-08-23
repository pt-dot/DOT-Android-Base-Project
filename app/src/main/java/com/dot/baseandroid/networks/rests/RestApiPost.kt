package com.dot.baseandroid.networks.rests

import com.dot.baseandroid.menu.list.models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiPost {

    @GET("posts")
    suspend fun getPosts(): Response<MutableList<PostModel>>

    @GET("posts")
    suspend fun getPagingPosts(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int = 20,
    ): Response<MutableList<PostModel>>

}