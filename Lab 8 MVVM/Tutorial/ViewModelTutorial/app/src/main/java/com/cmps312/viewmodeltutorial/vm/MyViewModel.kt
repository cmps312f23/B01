package com.cmps312.viewmodeltutorial.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var _counter = mutableStateOf(0)
        private set

    //    expose the none state version
    var counter: State<Int> = _counter

    fun increment() {
        _counter.value++
    }
}