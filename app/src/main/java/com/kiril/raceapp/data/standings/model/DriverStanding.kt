package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DriverStanding(
    @Json(name = "Constructors")
    val constructors: List<Constructor>,
    @Json(name = "Driver")
    val driver: Driver,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)