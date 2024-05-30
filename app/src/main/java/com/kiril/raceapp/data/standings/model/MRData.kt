package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MRData(
    val limit: String,
    val offset: String,
    val series: String,
    @Json(name = "StandingsTable")
    val standingsTable: StandingsTable,
    val total: String,
    val url: String,
    val xmlns: String
)