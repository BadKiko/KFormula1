package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandingsResponse(
    @Json(name = "MRData")
    val mRData: MRData
)