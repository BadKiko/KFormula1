package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Driver(
    val code: String,
    val dateOfBirth: String,
    val driverId: String,
    val familyName: String,
    val givenName: String,
    val nationality: String,
    val permanentNumber: String,
    val url: String
)