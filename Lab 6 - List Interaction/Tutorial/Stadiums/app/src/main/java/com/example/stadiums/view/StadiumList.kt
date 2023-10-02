package com.example.stadiums.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stadiums.R
import com.example.stadiums.model.Stadium
import com.example.stadiums.ui.theme.StadiumsTheme

@Composable
fun StadiumCard(stadium: Stadium) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.al_gharafa),
                contentDescription = null,
                modifier = Modifier
                    .size(160.dp)
                    .padding(end = 10.dp)
            )
            Column {
                Text(
                    text = "${stadium.name}",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(text = "City = ${stadium.city}")
                Text(text = "Seating Capacity = ${stadium.seatingCapacity}")
                Text(text = "Status = ${stadium.status}")
            }
        }
    }
}

@Composable
fun StadiumList(stadiums: List<Stadium>) {

}

@Preview
@Composable
fun StadiumListPreview() {
    val stadiums = listOf(
        Stadium(
            name = "Al Gharafa",
            city = "Doha",
            imageName = "al_gharafa",
            seatingCapacity = 100000,
            status = "Built"
        ),
        Stadium(
            name = "Al Shamal",
            city = "Doha",
            imageName = "al_shamal",
            seatingCapacity = 100000,
            status = "Built"
        )
    )
    StadiumsTheme {

    }
}

@Preview
@Composable
fun StadiumCardPreview() {
    val stadium = Stadium(
        name = "Al Gharafa",
        city = "Doha",
        imageName = "al_gharafa",
        seatingCapacity = 100000,
        status = "Built"
    )

    StadiumsTheme {
        StadiumCard(stadium)
    }
}
