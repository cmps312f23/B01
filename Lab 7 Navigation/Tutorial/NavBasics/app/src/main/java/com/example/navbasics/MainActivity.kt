package com.example.navbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.navbasics.nav.MyNavHost
import com.example.navbasics.ui.screen.Screen
import com.example.navbasics.ui.screen.Screen1
import com.example.navbasics.ui.screen.Screen2
import com.example.navbasics.ui.theme.NavBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val screens = listOf(
        Screen.FirstScreen,
        Screen.SecondScreen
    )
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {

            NavigationBar {
                screens.forEach {
                    NavigationBarItem(selected = false,
                        onClick = {
                            navController.navigate(it.route)
                        },
                        label = { Text(it.title) },
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = "")
                        })
                }

            }
        }
    ) {
        MyNavHost(navController = navController, paddingValues = it)
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    NavBasicsTheme {
        MyApp()
    }
}