package com.cmps312.viewmodeltutorial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.viewmodeltutorial.vm.MyViewModel


@Composable
fun DetailsScreen() {

    val myViewModel : MyViewModel = viewModel()
    myViewModel.example.value = 100

    Column {
        Text(
            text = "Name ${myViewModel.example.collectAsState().value}",
            fontSize = 20.sp
        )
        Text(
            text = "Age ",
            fontSize = 20.sp
        )

    }

}