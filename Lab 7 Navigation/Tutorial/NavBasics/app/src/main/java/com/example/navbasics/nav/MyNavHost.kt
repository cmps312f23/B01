package com.example.navbasics.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navbasics.ui.screen.CartScreen
import com.example.navbasics.ui.screen.FavScreen
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
        composable(route = Screen.FirstScreen.route) {
            Screen1(Modifier.padding(paddingValues))
        }
        composable(route = Screen.SecondScreen.route) {
            Screen2(Modifier.padding(paddingValues))
        }

        composable(
            route = Screen.CartScreen.route,
            arguments = listOf(
                navArgument("count") { type = NavType.IntType },
                navArgument("fruit") { type = NavType.StringType },
            )

        ) {
            CartScreen(
                Modifier.padding(paddingValues),
                it.arguments?.getInt("count"),
                it.arguments?.getString("fruit")
            )
        }
        composable(route = Screen.FavScreen.route) {
            FavScreen(Modifier.padding(paddingValues))
        }
    }
}