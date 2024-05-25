package com.kiril.raceapp.data.race.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Race(
    @Json(name = "Circuit")
    val circuit: Circuit,
    val date: String,
    @Json(name = "FirstPractice")
    val firstPractice: FirstPractice,
    @Json(name = "Qualifying")
    val qualifying: Qualifying,
    val raceName: String,
    val round: String,
    val season: String,
    @Json(name = "SecondPractice")
    val secondPractice: SecondPractice,
    @Json(name = "Sprint")
    val sprint: Sprint?,
    @Json(name = "ThirdPractice")
    val thirdPractice: ThirdPractice?,
    val time: String,
    val url: String
)