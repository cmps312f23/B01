package com.example.myapplication

import kotlinx.serialization.json.Json
import java.io.File

object CovidRepo {
    var covidData = listOf<CovidStat>()

    init {
        var data = File("data/covid-data.json").readText()
        covidData = Json { ignoreUnknownKeys = true }
            .decodeFromString(data)
    }
}

fun main(args: Array<String>) {
    CovidRepo.covidData.forEach {
        println(it)
    }
}