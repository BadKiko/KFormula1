package com.kiril.raceapp.data.race_detail.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Race(
    @Json(name = "Circuit")
    val circuit: Circuit,
    val date: String,
    val raceName: String,
    @Json(name = "Results")
    val raceResults: List<RaceResult>,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)