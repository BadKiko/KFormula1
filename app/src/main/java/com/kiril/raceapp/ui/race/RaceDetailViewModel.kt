package com.kiril.raceapp.ui.race

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiril.raceapp.data.race_detail.model.RaceDetail
import com.kiril.raceapp.data.race_detail.repository.RaceDetailsRepository
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RaceDetailViewModel @Inject constructor(
    private val raceRepository: RaceDetailsRepository
) : ViewModel() {

    private val _raceInfo = MutableLiveData<RaceDetail>()
    val raceInfo: LiveData<RaceDetail> get() = _raceInfo

    private val currentDate: LocalDate = LocalDate.now()

    fun fetchRaceDetails(year: String, round: String) {
        viewModelScope.launch {
            val response = raceRepository.getDriverStandings(year, round)
            response.onSuccess {
                _raceInfo.value = data
            }
        }
    }
}
