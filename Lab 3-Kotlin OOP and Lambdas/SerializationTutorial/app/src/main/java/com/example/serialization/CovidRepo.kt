package com.example.serialization

import kotlinx.serialization.json.Json
import java.io.File


object CovidRepo {
    var covidData = listOf<Covid>()

    init {
        val data = File("data/covid-data.json").readText()
        covidData = Json { ignoreUnknownKeys = true }.decodeFromString(data)

    }
    @JvmStatic
    fun main(args: Array<String>) {
        CovidRepo.covidData.forEach { println(it.country) }
    }

}