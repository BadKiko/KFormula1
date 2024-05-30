package com.kiril.raceapp.data.standings.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Constructor(
    val constructorId: String,
    val name: String,
    val nationality: String,
    val url: String
)