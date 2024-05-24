package com.kiril.raceapp.data.race.network

import com.kiril.raceapp.data.race.model.RaceResponse
import retrofit2.Call
import retrofit2.http.GET

interface ErgastApi {
    @GET("f1/current/next.json")
    fun getNextRace(): Call<RaceResponse>
}