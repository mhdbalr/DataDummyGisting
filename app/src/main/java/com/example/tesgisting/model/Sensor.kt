package com.example.tesgisting.model

import com.google.gson.annotations.SerializedName

data class Sensor( @SerializedName("datetime") val datetime: String,
                   @SerializedName("humidity_280") val humidity280: Double,
                   @SerializedName("pressure_280") val pressure280: Double,
                   @SerializedName("temperature_280") val temperature280: Double,
                   @SerializedName("temperature_388") val temperature388: Double,
                   @SerializedName("pressure_388") val pressure388: Double,
                   @SerializedName("phsensor") val phsensor: Double,
                   @SerializedName("tdssensor") val tdssensor: Double,
                   @SerializedName("moisturesensor") val moisturesensor: Double,
                   @SerializedName("anemometer") val anemometer: Double,
                   @SerializedName("windvane") val windvane: Double,
                   @SerializedName("currentsensor") val currentsensor: Double,
                   @SerializedName("rainintensity") val rainintensity: Double,
                   @SerializedName("rainstatus") val rainstatus: Double
)
