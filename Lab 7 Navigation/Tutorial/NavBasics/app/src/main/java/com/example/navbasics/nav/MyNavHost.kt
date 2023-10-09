package com.example.navbasics.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navbasics.ui.screen.Screen
import com.example.navbasics.ui.screen.Screen1
import com.example.navbasics.ui.screen.Screen2

@Composable
fun MyNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route
    ) {
//        do the mapping
        composable(route = Screen.FirstScreen.route){
            Screen1()
        }
        composable(route = Screen.SecondScreen.route){
            Screen2()
        }
    }
}