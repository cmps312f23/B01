package com.example.navbasics.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            Screen1(Modifier.padding(paddingValues))
        }
        composable(route = Screen.SecondScreen.route){
            Screen2(Modifier.padding(paddingValues))
        }
    }
}