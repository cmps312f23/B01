package com.example.stadiums.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stadiums.model.Stadium
import com.example.stadiums.repo.StadiumRepo
import com.example.stadiums.ui.theme.StadiumsTheme

@Composable
fun StadiumCard(stadium: Stadium) {
//    image id from image name
    val imageId = LocalContext.current.resources.getIdentifier(
        stadium.imageName,
        "drawable",
        LocalContext.current.packageName
    )

    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp).fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageId),
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
fun StadiumList(stadiums: List<Stadium>, paddingValues: PaddingValues) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(stadiums) {
            StadiumCard(stadium = it)
        }
    }
}

@Preview
@Composable
fun StadiumListPreview() {
    val stadiums = StadiumRepo.getStadiums(LocalContext.current)
    StadiumsTheme {
        StadiumList(stadiums, PaddingValues(10.dp))
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
