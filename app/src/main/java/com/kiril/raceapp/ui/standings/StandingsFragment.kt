package com.kiril.raceapp.ui.standings

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
class StandingsFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StandingsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_standings, container, false)

        recyclerView = view.findViewById(R.id.standings_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = StandingsAdapter(emptyList())
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchDriverStandings()

        viewModel.standings.observe(viewLifecycleOwner) { standings ->
            adapter.updateData(standings)
        }
    }
}
