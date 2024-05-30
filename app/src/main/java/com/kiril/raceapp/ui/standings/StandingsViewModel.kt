package com.kiril.raceapp.ui.standings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiril.raceapp.data.race.repository.RaceRepository
import com.kiril.raceapp.data.standings.model.DriverStanding
import com.kiril.raceapp.data.standings.model.StandingsResponse
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val raceRepository: RaceRepository
) : ViewModel() {

    private val _standings = MutableLiveData<List<DriverStanding>>()
    val standings: LiveData<List<DriverStanding>> get() = _standings

    fun fetchDriverStandings() {
        viewModelScope.launch {
            val response = raceRepository.getDriverStandings()
            handleStandingsResponse(response)
        }
    }

    private fun handleStandingsResponse(response: ApiResponse<StandingsResponse>) {
        response.onSuccess {
            _standings.value =
                data.mRData.standingsTable.standingsLists.firstOrNull()?.driverStandings
        }/*.onError {
            // Handle error here, e.g., show a message
        }*/
    }
}
