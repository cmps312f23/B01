package com.example.lab2kotlinfundamentals

fun main() {
   /*
    // Declaring of variables
    var firstname = "Abdulahi"
    val age = 100

    // input and output
    println("Please enter your name")
    var lastname = readlnOrNull()

    if(lastname !=null)
        print(lastname.length)

    print(lastname?.length)

//    print("Your name is $firstname $lastname ")

    println("""
        Firstname $firstname
        Lastname $lastname
    """.trimIndent())

//    Null Safety
    var middleName : Int? = null
    middleName = 20

    print(10/ middleName)


    val day = readlnOrNull()?.toInt()

    val dayOfWeek = when(day){
        in 1..3 -> "Sunday"
        2 -> "Monday"
        3 -> "Tueday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"

        else -> "Please enter a day between 1 to 7"
    }

    println("The day of the week is $dayOfWeek")



//    collections

//    array
    val cars = arrayOf("Volvo" , "BMW" , "Marcedez" , "Tata")

//    list , set , map [read only]
//    mutable

    val stars = listOf("Sun" , "Alpha Centura" , "Libra" , "Canopus")
    val editableStars = mutableListOf("Sun" , "Alpha Centura" , "Alpha Centura" , "Libra" , "Canopus")

    editableStars.add(2, "Scorpion")
    editableStars.add("Sirius")
    println(editableStars)

    val setStars = setOf<String>("Sun" , "Alpha Centura" , "Libra" , "Canopus" , "Alpha Centura")
    val editableSetStars = mutableSetOf("Sun" , "Alpha Centura" , "Libra" , "Canopus")

    //
    val mapStars = mapOf<Any, String>(1 to "Sun" , "2" to "Alpha Centura" , "Hello" to "Libra" , 4 to "Canopus" , 5 to "Alpha Centura")
    println(mapStars[1])

    for ((key , value) in mapStars)
        println(value)

    for (star in mapStars)
        println(star.value)
    */

    for( i in 10..50 step 3)
        println(i)


}