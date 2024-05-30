package com.kiril.raceapp.data.race_detail.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RaceTable(
    @Json(name = "Races")
    val races: List<Race>,
    val round: String,
    val season: String
)