package com.kiril.raceapp.ui.main

import RaceAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiril.raceapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastRacesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val raceViewModel: RaceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_past_races, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        observeViewModel()
        return view
    }

    private fun observeViewModel() {
        raceViewModel.raceInfo.observe(viewLifecycleOwner) { races ->
            recyclerView.adapter = RaceAdapter()
        }
        raceViewModel.fetchPastRaces()
    }
}