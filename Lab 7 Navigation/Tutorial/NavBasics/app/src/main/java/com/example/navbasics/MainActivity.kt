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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var showScreen1 by remember {
        mutableStateOf(true)
    }
    Scaffold(
        bottomBar = {
            Row(
                Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .heightIn(80.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = Icons.Default.BrokenImage,
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                        .clickable {
                            showScreen1 = true
                        })
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                        .clickable {
                            showScreen1 = false
                        })

            }
        }
    ) {
        if (showScreen1) Screen1(Modifier.padding(it))
        else Screen2(Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    NavBasicsTheme {
        MyApp()
    }
}