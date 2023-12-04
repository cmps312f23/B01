package com.cmps312.pizzapal.ui.view.orderitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.cmps312.pizzapal.entity.Pizza

val pizzaTypes = listOf(
    Pizza(
        name = "Margherita",
        price = 10.99,
        description = "Classic tomato sauce, mozzarella cheese, and fresh basil",
        imageName = "margherita",
        orderId = 1,
        quantity = 5
    ),
    Pizza(
        name = "Marinara",
        price = 12.99,
        description = "Tomato sauce, garlic, oregano, and basil",
        imageName = "mirinara",
        orderId = 1,
        quantity = 4
    ),
    Pizza(
        name = "Quattro Formaggi",
        price = 14.99,
        description = "Mozzarella, gorgonzola, fontina, and parmigiano reggiano",
        imageName = "formaggi",
        orderId = 1,
        quantity = 5
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderItemEditor(
    pizza: Pizza,
    onSubmitPizza: (Pizza) -> Unit
) {
    var selectedPizzaType by remember { mutableStateOf(pizza.name) }
    var price by remember { mutableStateOf(pizza.price) }
    var description by remember { mutableStateOf(pizza.description) }
    var imageName by remember { mutableStateOf(pizza.imageName) }
    var quantity by remember { mutableStateOf(pizza.quantity) }
    var isExpanded by remember { mutableStateOf(false) }
    var selectedPizza by remember { mutableStateOf(pizza) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Dropdown for selecting pizza type
        Text(
            text = "Order Item Editor",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }) {
            TextField(
                value = selectedPizzaType,
                onValueChange = { selectedPizzaType = it },
                label = { Text("Pizza Type") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { isExpanded = true }) {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                    }
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )

            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                pizzaTypes.forEach { pizzaType ->
                    DropdownMenuItem(text = { Text(pizzaType.name) },
                        onClick = {
                            selectedPizzaType = pizzaType.name
                            isExpanded = !isExpanded
                            selectedPizza = pizzaType
                        })
                }
            }
        }

        TextField(
            value = quantity.toString(),
            onValueChange = { quantity = it.toIntOrNull() ?: 0 },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        val imageId = context.resources.getIdentifier(
            selectedPizza.imageName, "drawable", context.packageName
        )

        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Pizza image",
            modifier = Modifier.size(200.dp)
        )


        // Button to update the pizza
        Button(
            onClick = {
                val updatedPizza = Pizza(
                    name = selectedPizzaType,
                    price = price,
                    description = description,
                    imageName = imageName,
                    orderId = pizza.orderId,
                    quantity = quantity,
                    id = pizza.id
                )
                onSubmitPizza(updatedPizza)
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@Preview

@Composable
fun OrderItemEditorPreview() {
    OrderItemEditor(
        Pizza(
            name = "Margherita",
            price = 10.99,
            description = "Classic tomato sauce, mozzarella cheese, and fresh basil",
            imageName = "margherita",
            orderId = 1,
            quantity = 5
        ),
        onSubmitPizza = {

        }
    )
}