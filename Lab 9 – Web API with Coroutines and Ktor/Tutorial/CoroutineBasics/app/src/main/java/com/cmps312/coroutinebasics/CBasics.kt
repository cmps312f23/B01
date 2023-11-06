package com.cmps312.coroutinebasics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
     for (i in 1..50000) {
         launch {
             delay((500..1000L).random())
             print("$i - ")
         }
     }

}

suspend fun doWorld() = coroutineScope {
    var x = 0
    val job = launch {
        delay(1000L)
        x = 10
    }
    job.join()
    println(100 / x)
}