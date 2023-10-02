package com.example.stadiums.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.stadiums.model.Stadium
import com.example.stadiums.repo.StadiumRepo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(updateStadiumList: (List<Stadium>) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    TextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            updateStadiumList(StadiumRepo.filterStadiums(searchQuery))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty())
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
        }
    )
}