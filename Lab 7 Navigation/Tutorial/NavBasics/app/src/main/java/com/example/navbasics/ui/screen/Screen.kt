package com.example.navbasics.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val title: String) {
    object FirstScreen : Screen("screen1" , Icons.Default.Shop , "Screen 1")
    object SecondScreen : Screen("screen2" , Icons.Default.BrokenImage , "Screen 2")
    object CartScreen : Screen("cart" , Icons.Default.ShoppingCart , "Shopping Cart")
}