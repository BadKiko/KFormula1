package com.kiril.raceapp.ui.race

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiril.raceapp.R
import com.kiril.raceapp.data.race_detail.model.RaceResult

class RaceDetailAdapter :
    ListAdapter<RaceResult, RaceDetailAdapter.RaceViewHolder>(RaceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_race_details, parent, false)
        return RaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceViewHolder, position: Int) {
        val race = getItem(position)

        holder.bind(race)
    }

    class RaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val driverPositionTextView: TextView = itemView.findViewById(R.id.driver_position)
        private val driverNameTextView: TextView = itemView.findViewById(R.id.driver_name)
        private val driverTimeTextView: TextView = itemView.findViewById(R.id.driver_time)
        private val driverPtsTextView: TextView = itemView.findViewById(R.id.driver_pts)
        fun bind(raceResult: RaceResult) {
            driverPositionTextView.text = raceResult.position
            driverNameTextView.text = raceResult.driver.givenName
            driverTimeTextView.text = raceResult.time?.time
            driverPtsTextView.text = raceResult.points
        }
    }

    class RaceDiffCallback : DiffUtil.ItemCallback<RaceResult>() {
        override fun areItemsTheSame(oldItem: RaceResult, newItem: RaceResult): Boolean {
            return oldItem.driver.driverId == newItem.driver.driverId
        }

        override fun areContentsTheSame(oldItem: RaceResult, newItem: RaceResult): Boolean {
            return oldItem == newItem
        }
    }
}
