package com.kiril.raceapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiril.raceapp.data.race.repository.RaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(
    private val raceRepository: RaceRepository
) : ViewModel() {

    private val _raceInfo = MutableLiveData<String>()
    val raceInfo: LiveData<String> get() = _raceInfo

    fun fetchNextRace() {
//        viewModelScope.launch {
//            try {
//                val response = raceRepository.getNextRace().execute()
//                if (response.isSuccessful) {
//                    val race = response.body()?.MRData?.RaceTable?.Races?.firstOrNull()
//                    race?.let {
//                        _raceInfo.value =
//                            "Next Race: ${it.raceName} at ${it.Circuit.circuitName}, ${it.Circuit.Location.locality}, ${it.Circuit.Location.country} on ${it.date} at ${it.time}"
//                    }
//                }
//            } catch (e: Exception) {
//                _raceInfo.value = "Failed to fetch race information"
//            }
//        }
    }
}