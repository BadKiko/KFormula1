package com.kiril.raceapp.data.network

import com.kiril.raceapp.data.race.model.RaceResponse
import com.kiril.raceapp.data.race_detail.model.RaceDetail
import com.kiril.raceapp.data.standings.model.StandingsResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ErgastApi {
    @GET("f1/current.json")
    suspend fun getAllRaces(): ApiResponse<RaceResponse>

    @GET("f1/current/driverStandings.json")
    suspend fun getDriverStandings(): ApiResponse<StandingsResponse>

    @GET("f1/{season}/{round}/results.json")
    suspend fun getRaceDetails(
        @Path("season") year: String,
        @Path("round") round: String
    ): ApiResponse<RaceDetail>
}