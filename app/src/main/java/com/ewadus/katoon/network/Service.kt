package com.ewadus.katoon.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DevbyteService {
    @GET("devbytes")
    suspend fun getPlaylist(): VideoResponse
}


object DevByteNetwork {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
        .build()

    val videoServices: DevbyteService by lazy {
        retrofit.create(DevbyteService::class.java)
    }


}