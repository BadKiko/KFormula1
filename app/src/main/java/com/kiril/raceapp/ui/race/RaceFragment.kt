package com.kiril.raceapp.ui.race

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButtonToggleGroup
import com.kiril.raceapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RaceFragment : Fragment() {
    private val raceViewModel: RaceViewModel by viewModels()
    private lateinit var raceRecyclerView: RecyclerView
    private lateinit var raceAdapter: RaceAdapter
    private lateinit var toggleButtonGroup: MaterialButtonToggleGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_race, container, false)

        // Initialize the RecyclerView
        raceRecyclerView = view.findViewById(R.id.race_recycler_view)
        raceRecyclerView.layoutManager = LinearLayoutManager(context)
        raceAdapter = RaceAdapter()
        raceRecyclerView.adapter = raceAdapter

        // Initialize the MaterialButtonToggleGroup
        toggleButtonGroup = view.findViewById(R.id.toggleButton)

        // Set initial selection
        toggleButtonGroup.check(R.id.upcoming_races)
        raceViewModel.fetchNextRace()

        // Set listener for button selection
        toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.upcoming_races -> raceViewModel.fetchNextRace()
                    R.id.past_races -> raceViewModel.fetchPastRaces()
                }
            }
        }

        // Observe race data
        raceViewModel.raceInfo.observe(viewLifecycleOwner) { races ->
            // Update your adapter with the new data
            raceAdapter.submitList(races)
        }

        return view
    }
}
