package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
//    create a list of five names with different name sizes
    val names = listOf(
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. Redwan",
        "Mr. Redwan",
        "Mr. Mohamed",
        "Mr. Hassen",
        "Mr. Omar",
        "Mr. Marwan",
        "Mr. JUJU"
    )
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
//        Column(modifier = modifier.padding(vertical = 4.dp)) {
//            for (name in names) {
//
//            }
//        }

        LazyColumn {
            items(names){
                Greeting(it)
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.padding(bottom = extraPadding),
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(start = 8.dp)

            ) {
                Text(
                    text = "Hello",
                    modifier = modifier
                )

                Text(
                    text = "$name!",
                    modifier = modifier
                )
            }


            ElevatedButton(onClick = {
                expanded = !expanded

                Log.d("EXPANDED", " ---> " + expanded)

            }) {
                Text(text = if (expanded) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Light Mode",

    )
@Composable
fun MyAppPreview() {
    MyApplicationTheme {
        MyApp()
    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    name = "Light Mode",
//
//    )
//@Composable
//fun GreetingPreview2() {
//    MyApplicationTheme {
//        Greeting("Android Development")
//    }
//}