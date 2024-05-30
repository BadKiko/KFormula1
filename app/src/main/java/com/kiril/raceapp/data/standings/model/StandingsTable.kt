package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandingsTable(
    val season: String,
    @Json(name = "StandingsLists")
    val standingsLists: List<StandingsLists>
)