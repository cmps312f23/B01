package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json

object StadiumRepo {
    var stadiums = mutableListOf<Stadium>()

    fun getStadiums(context: Context): List<Stadium> {
        if (stadiums.isEmpty()) {
            val fileJsonTextContent =
                context
                    .assets
                    .open("stadiums.json")
                    .bufferedReader().use { it.readText() }

//            convert to objects
            stadiums = Json { ignoreUnknownKeys = true }.decodeFromString(fileJsonTextContent)
        }
        return stadiums
    }
}
