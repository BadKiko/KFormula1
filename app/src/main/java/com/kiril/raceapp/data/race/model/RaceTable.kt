package com.kiril.raceapp.data.race.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RaceTable(
    @Json(name = "Races")
    val races: List<Race>,
    val season: String
)