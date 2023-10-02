package com.example.stadiums.repo

import android.content.Context
import com.example.stadiums.model.Stadium
import kotlinx.serialization.json.Json
import java.util.Locale

object StadiumRepo {
    var stadiums = mutableListOf<Stadium>()

    object SortOption {
        val NAME = "name"
        val CITY = "city"
        val CAPACITY = "capacity"
        val STATUS = "status"
    }
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

    //    fun searcd
    fun filterStadiums(query: String): List<Stadium> = stadiums.filter {
        it.name.lowercase(Locale.getDefault())
            .contains(query) or it.city.lowercase(Locale.getDefault()).contains(query)
    }
    fun sortStadiums(sortOption : String) = when(sortOption) {
        SortOption.CITY -> stadiums.sortBy { it.city }
        SortOption.CAPACITY -> stadiums.sortBy { it.seatingCapacity }
        SortOption.NAME -> stadiums.sortBy { it.name }
        SortOption.STATUS -> stadiums.sortBy { it.status }
        else -> stadiums
    }
}
