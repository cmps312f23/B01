package com.example.navbasics.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navbasics.ui.screen.Screen

@Composable
fun MyNavHost(navController: NavHostController , paddingValues: PaddingValues){
    NavHost(
        navController = navController,
        startDestination = Screen.Screen1.route
    ) {
//        do the mapping

    }
}