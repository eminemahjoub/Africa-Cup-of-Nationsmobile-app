package com.example.appscorecoupedafrique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchAdapter(private val matchList: List<Match>) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val team1TextView: TextView = itemView.findViewById(R.id.team1TextView)
        val team2TextView: TextView = itemView.findViewById(R.id.team2TextView)
        val scoreTextView: TextView = itemView.findViewById(R.id.scoreTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMatch = matchList[position]

        holder.team1TextView.text = currentMatch.team1
        holder.team2TextView.text = currentMatch.team2
        holder.scoreTextView.text = "${currentMatch.score1} - ${currentMatch.score2}"
        holder.dateTextView.text = currentMatch.date
    }

    override fun getItemCount(): Int {
        return matchList.size
    }
}
