package com.cmps312.pizzapal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cmps312.pizzapal.ui.theme.PizzaPalTheme
import com.cmps312.pizzapal.ui.view.order.OrderEditor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaPalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    OrderScreen()
//                    OrderItemScreen()
                    OrderEditor(onSubmit = {})
//                    OrderItemEditor(pizza = Pizza(
//                        name = "Margherita",
//                        price = 10.99,
//                        description = "Classic tomato sauce, mozzarella cheese, and fresh basil",
//                        imageName = "margherita",
//                        orderId = 1,
//                        quantity = 8
//                    ), onSubmitPizza = {})
                }
            }
        }
    }
}
