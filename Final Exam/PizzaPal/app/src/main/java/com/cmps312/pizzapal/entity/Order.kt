package com.cmps312.pizzapal.entity

class Order(
    val customerName: String,
    val address: String,
    val phone: String,
    val email: String,
    val id: Int=0
)