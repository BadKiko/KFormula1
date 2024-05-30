package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandingsLists(
    @Json(name = "DriverStandings")
    val driverStandings: List<DriverStanding>,
    val round: String,
    val season: String
)