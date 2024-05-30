package com.kiril.raceapp.data.race_detail.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RaceDetail(
    @Json(name = "MRData")
    val mRData: MRData
)