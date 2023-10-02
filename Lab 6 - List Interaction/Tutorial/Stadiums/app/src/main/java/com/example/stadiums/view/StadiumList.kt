package com.example.stadiums.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.stadiums.model.Stadium
import com.example.stadiums.ui.theme.StadiumsTheme

@Composable
fun StadiumCard(stadium: Stadium) {

}

@Preview
@Composable
fun StadiumCardPreview() {
    val stadium = Stadium(
        name = "Stadium Name",
        city = "City",
        imageName = "al_gharafa",
        seatingCapacity = 10000,
        status = "Built"
    )

    StadiumsTheme {
        StadiumCard(stadium)
    }
}
