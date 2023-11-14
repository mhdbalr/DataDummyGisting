package com.example.tesgisting.model

import com.google.gson.annotations.SerializedName

data class GistingRespons(
    @SerializedName("count") val count: Int,
    @SerializedName("result") val result: List<Sensor>
)
