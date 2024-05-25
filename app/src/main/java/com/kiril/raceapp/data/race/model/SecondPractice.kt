package com.kiril.raceapp.data.race.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SecondPractice(
    val date: String,
    val time: String
)