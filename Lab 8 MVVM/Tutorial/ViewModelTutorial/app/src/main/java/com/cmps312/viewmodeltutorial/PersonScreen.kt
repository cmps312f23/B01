package com.cmps312.viewmodeltutorial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.viewmodeltutorial.vm.MyViewModel

@Composable
fun PersonScreen() {
    val myViewModel : MyViewModel = viewModel()
    LazyColumn{
        
        items(myViewModel.people.value){
            Text(text = it.name, fontSize = 20.sp, modifier = Modifier.clickable {
                myViewModel.selectPerson(it)
            })
        }
    }

}