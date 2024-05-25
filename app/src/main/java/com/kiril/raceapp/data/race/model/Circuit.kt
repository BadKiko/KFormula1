package com.kiril.raceapp.data.race.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Circuit(
    val circuitId: String,
    val circuitName: String,
    @Json(name = "Location")
    val location: Location,
    val url: String
)