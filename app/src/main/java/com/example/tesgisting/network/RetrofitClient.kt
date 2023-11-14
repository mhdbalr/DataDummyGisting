package com.example.tesgisting.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL_VPS = "https://vps.isi-net.org:5000/"

    private val retrofitVPS = Retrofit.Builder()
        .baseUrl(BASE_URL_VPS)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiVPSInstance: ApiVPS = retrofitVPS.create(ApiVPS::class.java)
}