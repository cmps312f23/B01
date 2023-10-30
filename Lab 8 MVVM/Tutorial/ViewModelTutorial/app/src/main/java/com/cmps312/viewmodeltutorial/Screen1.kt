package com.cmps312.viewmodeltutorial

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.viewmodeltutorial.vm.MyViewModel

@Composable
fun Screen1() {
    val myViewModel : MyViewModel = viewModel()
    Text(
        text = "Screen One Number of times clicked is ${myViewModel.counter.value}",
        modifier = Modifier.clickable {
            myViewModel.increment()
        },
        fontSize = 20.sp
    )

}