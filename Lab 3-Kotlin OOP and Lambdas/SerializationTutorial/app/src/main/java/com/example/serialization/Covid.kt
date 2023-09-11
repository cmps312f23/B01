package com.example.serialization

import kotlinx.serialization.Serializable

@Serializable
data class Covid(
    var id: Int,
    var country: String,
    var continent: String,
    var activeCases: Int?,
    var population: Int?
)
