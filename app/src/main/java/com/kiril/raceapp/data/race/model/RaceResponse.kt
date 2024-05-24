package com.kiril.raceapp.data.race.model
data class RaceResponse(
    val MRData: MRData
)

data class MRData(
    val RaceTable: RaceTable
)

data class RaceTable(
    val Races: List<Race>
)

data class Race(
    val raceName: String,
    val date: String,
    val time: String,
    val Circuit: Circuit
)

data class Circuit(
    val circuitName: String,
    val Location: Location
)

data class Location(
    val locality: String,
    val country: String
)