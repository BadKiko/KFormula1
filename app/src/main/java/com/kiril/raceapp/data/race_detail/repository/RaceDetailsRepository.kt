package com.kiril.raceapp.data.race_detail.repository

import com.kiril.raceapp.data.network.ErgastApi
import com.kiril.raceapp.data.race_detail.model.RaceDetail
import com.skydoves.sandwich.ApiResponse

class RaceDetailsRepository(private val ergastApi: ErgastApi) {
    suspend fun getDriverStandings(year: String, round: String): ApiResponse<RaceDetail> {
        return ergastApi.getRaceDetails(year, round)
    }
}