package com.example.appscorecoupedafrique

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate random match data for the last five years
        val matchList = generateRandomMatchData(5)

        // Initialize RecyclerView and set the adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        matchAdapter = MatchAdapter(matchList)
        recyclerView.adapter = matchAdapter
    }

    private fun generateRandomMatchData(years: Int): List<Match> {
        val matchList = mutableListOf<Match>()
        val currentDate = Calendar.getInstance()

        for (i in 0 until years * 365) {
            val matchDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .format(currentDate.time)

            val match = Match(
                "Team ${Random().nextInt(10) + 1}",
                "Team ${Random().nextInt(10) + 1}",
                Random().nextInt(5),
                Random().nextInt(5),
                matchDate
            )

            matchList.add(match)

            // Decrement date by 1 day for the next iteration
            currentDate.add(Calendar.DAY_OF_YEAR, -1)
        }

        return matchList
    }
}
