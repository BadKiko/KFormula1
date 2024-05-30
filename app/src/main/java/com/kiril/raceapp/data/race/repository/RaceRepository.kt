package com.kiril.raceapp.data.race.repository

import com.kiril.raceapp.data.race.model.RaceResponse
import com.kiril.raceapp.data.network.ErgastApi
import com.kiril.raceapp.data.standings.model.StandingsResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call

class RaceRepository(private val ergastApi: ErgastApi) {
    suspend fun getAllRaces(): ApiResponse<RaceResponse> {
        return ergastApi.getAllRaces()
    }
    suspend fun getDriverStandings(): ApiResponse<StandingsResponse> {
        return ergastApi.getDriverStandings()
    }
}