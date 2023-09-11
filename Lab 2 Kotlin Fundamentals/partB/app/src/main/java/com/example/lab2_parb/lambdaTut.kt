package com.example.lab2_parb

fun main(args: Array<String>) {
//    println(add(12, 13))
//
////    calculate(12, 13) { a: Int, b: Int -> a + b }
////    calculate(12, 13 , sub)
////    calculate(12, 13 , mul)
////    calculate(12, 13 , div)
//
////    val numbers = listOf<Int>(1,2,3,4,5,9,11,55,22)
////    numbers.forEach(::println)
////    numbers.forEach { println(it)}
////    numbers.forEach { a -> println(a)}
////    numbers.forEach(::display)
////
////    val names = listOf<String>("aly")
////    names.countVowels()
//
//    val name = "Abdulahi"
//    name.countVowels()

    val numbers = listOf<Int>(2, 3 , 4, 6)

    numbers.map {it * it }
        .filter { it % 2 == 0  }
        .forEach { println (it) }



}
//
//fun List<Int>.oSum() {
//    var sum = 0
//    for (x in this) sum += x
//   println(sum)
//}
//
//fun display(a: Int) {
//    println(a)
//}
//
//val add = { a: Int, b: Int -> a + b }
//val sub = { a: Int, b: Int -> a - b }
//val div = { a: Int, b: Int -> a / b }
//val mul = { a: Int, b: Int -> a * b }
//
//
//fun String.countVowels() {
//    val text = this
//    val vowels = listOf('a', 'e', 'i', 'o', 'u')
//    var counter = 0
//    for (x in text)
//        if (x in vowels)
//            counter++
//
//}
//
//fun calculate(num1: Int, num2: Int, operation: (Int, Int) -> Int) {
//    println(operation(num1, num2))
//}