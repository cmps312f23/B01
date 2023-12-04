package com.cmps312.pizzapal.ui.view.orderitem

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.pizzapal.entity.Pizza


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OrderItemScreen() {
    val pizzas = listOf(
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
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("PizzaPal", color = MaterialTheme.colorScheme.onTertiary) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.tertiary),
                navigationIcon = {
                    // only show in the other screens not the home screen
//                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                },
                actions = {

                }
            )
        },
        content = {
            PizzaList(pizzas, modifier = Modifier.padding(it))
        },
        floatingActionButton = {
            Icon(
                imageVector = Icons.Outlined.AddCircle,
                contentDescription = "Add Item",
                tint = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Add New Order Item", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
    )
}


@Composable
fun PizzaList(pizzas: List<Pizza>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(pizzas) { pizza ->
            PizzaCard(
                pizza = pizza,
                onDelete = {
                    // Handle selection
                }, onEdit = {
                    // Handle deletion
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCard(
    pizza: Pizza,
    onDelete: (Pizza) -> Unit,
    onEdit: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    ElevatedCard(
        modifier = modifier.padding(16.dp),
        onClick = { onDelete(pizza) },
        colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.tertiary)

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${pizza.name}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onTertiary
                )

                IconButton(
                    onClick = { /* Show/hide delete button */ },
                    modifier = Modifier.width(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Delete pizza",
                        tint = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.clickable {
                            onEdit(pizza.id) // Call the onDelete callback with the pizza ID
                        }
                    )
                }
            }
            Divider()
            Text(
                text = "Price: ${pizza.price} QAR",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onTertiary
            )

            Text(
                text = "Description: ${pizza.description}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )

            val imageId = context.resources.getIdentifier(
                pizza.imageName, "drawable", context.packageName
            )

            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Pizza image",
                modifier = Modifier.size(180.dp)
            )
            Divider()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Quantity: ${pizza.quantity}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onTertiary,
                    textAlign = TextAlign.End
                )
                Text(
                    text = "Total Price: ${pizza.price * pizza.quantity} QAR",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }

        }
    }
}


@Preview
@Composable
fun PizzaCardPreview() {
    PizzaCard(
        Pizza(
            name = "Marinara",
            price = 12.99,
            description = "Tomato sauce, garlic, oregano, and basil",
            imageName = "mirinara",
            orderId = 1,
            quantity = 4
        ),
        onDelete = {

        },
        onEdit = {

        })
}

@Preview
@Composable
fun PizzaListPreview() {

    PizzaList(
        pizzas = listOf(
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
    )
}