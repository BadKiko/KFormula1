package com.kiril.raceapp.ui.standings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiril.raceapp.R
import com.kiril.raceapp.data.standings.model.DriverStanding

class StandingsAdapter(private var standings: List<DriverStanding>) :
    RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_standing, parent, false)
        return StandingsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        holder.bind(standings[position])
    }

    override fun getItemCount(): Int = standings.size

    fun updateData(newStandings: List<DriverStanding>) {
        standings = newStandings
        notifyDataSetChanged()
    }

    class StandingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val driverNameTextView: TextView = itemView.findViewById(R.id.driver_name)
        private val driverPointsTextView: TextView = itemView.findViewById(R.id.driver_points)

        fun bind(driverStanding: DriverStanding) {
            driverNameTextView.text =
                driverStanding.driver.givenName + " " + driverStanding.driver.familyName
            driverPointsTextView.text = "${driverStanding.points} PTS"
        }
    }
}
