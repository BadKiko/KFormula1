package com.kiril.raceapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiril.raceapp.data.race.model.Race
import com.kiril.raceapp.data.race.repository.RaceRepository
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(
    private val raceRepository: RaceRepository
) : ViewModel() {

    private val _raceInfo = MutableLiveData<List<Race>>()
    val raceInfo: LiveData<List<Race>> get() = _raceInfo

    private val currentDate: LocalDate = LocalDate.now()

    fun fetchNextRace() {
        viewModelScope.launch {
            val response = raceRepository.getAllRaces()
            response.onSuccess {
                _raceInfo.value = data.mRData.raceTable.races.filter { LocalDate.parse(it.date).isBefore(currentDate) }
            }
        }
    }

    fun fetchPastRaces() {
        viewModelScope.launch {
            val response = raceRepository.getAllRaces()
            response.onSuccess {
                _raceInfo.value = data.mRData.raceTable.races.filter { LocalDate.parse(it.date).isAfter(currentDate) }
            }
        }
    }

}
