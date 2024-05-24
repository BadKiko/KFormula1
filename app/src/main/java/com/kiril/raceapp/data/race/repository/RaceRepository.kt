package com.kiril.raceapp.data.race.repository

import com.kiril.raceapp.data.race.model.RaceResponse
import com.kiril.raceapp.data.race.network.ErgastApi
import retrofit2.Call

class RaceRepository(private val ergastApi: ErgastApi) {
    fun getNextRace(): Call<RaceResponse> {
        return ergastApi.getNextRace()
    }
}