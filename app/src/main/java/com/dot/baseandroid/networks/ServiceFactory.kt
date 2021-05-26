package com.dot.baseandroid.networks

import com.dot.baseandroid.BuildConfig
import com.dot.baseandroid.data.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {

    private fun retrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)
        clientBuilder.callTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS)

         return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }

    fun <T> getApiService(service: Class<T>): T {
        return retrofitInstance().create(service)
    }

}