package com.example.tesgisting.network

import com.example.tesgisting.model.GistingRespons
import retrofit2.Call
import retrofit2.http.GET

interface ApiVPS {@GET("GetDataGisting")
fun getGisting(
): Call<GistingRespons>
}