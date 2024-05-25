package com.kiril.raceapp.data.race.network

import com.kiril.raceapp.data.race.model.RaceResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ErgastApi {
    @GET("f1/current.json")
    suspend fun getAllRaces(): ApiResponse<RaceResponse>
}