package com.example.lab2_parb

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3, 5, 8, 9, 10)
    val names = listOf("Aly", "Omar", "Ahmed", "Rashid", "Yusuf")


    println(numbers.sum())
    println(numbers.max())
    println(numbers.min())
    numbers.forEach { x -> println("This is $x") }
    val mapped = numbers.map { a -> a * a }
    println(mapped)

    val mappedToLength = names.map {name -> name.length}
    println(mappedToLength)

    println(numbers.size)
    println(numbers.sum())
    println(numbers.average())

    println(names.filter { it.length < 4 })
    println(names.sorted())
    println(names.sortedDescending())

//    println(names.find { it == "RXashid" })

//    val acc = 0
//    for(curr in names)
//        acc += curr.length
//
//    names.fold(0) {acc , curr -> acc + curr.length}
}