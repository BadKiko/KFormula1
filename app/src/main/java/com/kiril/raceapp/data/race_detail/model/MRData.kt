package com.kiril.raceapp.data.race_detail.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MRData(
    val limit: String,
    val offset: String,
    @Json(name = "RaceTable")
    val raceTable: RaceTable,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)