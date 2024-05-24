package com.kiril.raceapp.di

import com.kiril.raceapp.data.race.network.ErgastApi
import com.kiril.raceapp.data.race.repository.RaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ergast.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideErgastApi(retrofit: Retrofit): ErgastApi {
        return retrofit.create(ErgastApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRaceRepository(ergastApi: ErgastApi): RaceRepository {
        return RaceRepository(ergastApi)
    }
}