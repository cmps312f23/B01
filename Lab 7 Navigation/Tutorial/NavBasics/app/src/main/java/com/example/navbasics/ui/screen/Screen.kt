package com.example.navbasics.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Shop
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val title: String) {
    object Screen1 : Screen("screen1" , Icons.Default.Shop , "Screen 1")
    object Screen2 : Screen("screen2" , Icons.Default.BrokenImage , "Screen 2")
}