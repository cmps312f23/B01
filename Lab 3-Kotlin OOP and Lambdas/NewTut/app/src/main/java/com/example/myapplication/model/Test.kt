package com.example.myapplication.model

interface Animal {
    fun speak()
}

open class Dog(val name: String, val age: Int, val breed: String) : Animal {
    override fun speak() {
        println("Woof! I am a $breed")
    }
}

class GoldenRetriever(name: String, age: Int) : Dog(name, age, "Golden Retriever") {
    fun playFetch() {
        println("I love to play fetch!")
    }
}

fun main(args: Array<String>) {
    val dog = Dog("Max", 3, "Golden Retriever")
    val goldenRetriever = GoldenRetriever("Buddy", 2)

    val user = User("John Doe")

    // The following line will cause a compile-time error
    // dog.speak()

    // The following line will work because goldenRetriever is a Dog
    goldenRetriever.speak()

    // The following line will also work because user is a generic type
    user.speak()
}