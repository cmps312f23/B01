package com.cmps312.viewmodeltutorial.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class Person(val name: String, val age: Int)

//ten random people
object PersonRepository {
    val list = listOf(
        Person("John", 30),
        Person("Jane", 25),
        Person("Bob", 40),
        Person("Alice", 20),
        Person("Eve", 35),
        Person("Kate", 27),
        Person("Mike", 32),
        Person("Lisa", 29),
        Person("Sam", 38),
        Person("Mary", 24)
    )
}

class MyViewModel(
    private val saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val _people by lazy { MutableStateFlow(PersonRepository.list) }
    val people = _people.asStateFlow()


    val selectedPerson = saveStateHandle.getStateFlow("selectedPerson", null)

    var example = MutableStateFlow(0)
        private set

    fun selectPerson(person: Person) {
        saveStateHandle["person"] = selectedPerson
    }


}