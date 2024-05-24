package com.kiril.raceapp.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kiril.raceapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RaceFragment : Fragment() {
    private lateinit var raceInfoTextView: TextView/*
    private val raceViewModel: RaceViewModel by viewModels()*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_race, container, false)
        raceInfoTextView = view.findViewById(R.id.race_info_text_view)
        observeViewModel()
        return view
    }

    private fun observeViewModel() {
      /*  raceViewModel.raceInfo.observe(viewLifecycleOwner) { raceInfo ->
            raceInfoTextView.text = raceInfo
        }
        raceViewModel.fetchNextRace()*/
    }
}