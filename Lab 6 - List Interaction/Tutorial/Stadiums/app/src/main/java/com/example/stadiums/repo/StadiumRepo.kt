package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json

object StadiumRepo {
    var stadiums = mutableListOf<Stadium>()

    fun getStadiums(context: Context): List<Stadium> {
        if (stadiums.isEmpty()) {
            val jsonContent =
                context
                    .assets
                    .open("stadiums.json")
                    .bufferedReader().use { it.readText() }

            stadiums = Json { ignoreUnknownKeys = true }.decodeFromString(jsonContent)
        }
        return stadiums
    }
}