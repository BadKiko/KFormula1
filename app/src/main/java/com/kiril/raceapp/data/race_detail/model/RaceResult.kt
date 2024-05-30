package com.kiril.raceapp.data.race_detail.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RaceResult(
    @Json(name = "Constructor")
    val `constructor`: Constructor,
    @Json(name = "Driver")
    val driver: Driver,
    @Json(name = "FastestLap")
    val fastestLap: FastestLap?,
    val grid: String,
    val laps: String,
    val number: String,
    val points: String,
    val position: String,
    val positionText: String,
    val status: String,
    @Json(name = "Time")
    val time: TimeX?
)