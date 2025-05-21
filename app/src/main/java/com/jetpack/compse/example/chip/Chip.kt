package com.jetpack.compse.example.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.compse.example.R

val chipExampleList = listOf(
    "Brands Filter Chip",
)

/*
Following composable is to create a list of buttons mentioned
in 'dialogExampleList'.
It will iterate and create buttons where each button do call
a specific composable to demonstrate the example
 */
@Composable
fun ChipScreen(
    navController: NavController
) {
    /*
    Create a column which can hold children for multiple button components
     */
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        chipExampleList.forEachIndexed { index, title ->
            /*
            Create a row composable to hold a text
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate("chip${index + 1}")
                    }
                    .background(color = colorResource(R.color.purple_500))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun BrandsFilterChip() {
    val brandList = listOf(
        "Alpine Style", "Bumblebee Threads", "Chic Clique",
        "Dapper Decade", "Elegant Edge", "Fashion Frontier",
        "Glow Couture", "Vogue"
    )

    // Maintain selection state for each brand in a map
    val chipStates = remember {
        mutableStateMapOf<String, Boolean>().apply {
            brandList.forEach { this[it] = false }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Filter Options: Select Brand")

        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            brandList.forEach { brand ->
                FilterChip(
                    selected = chipStates[brand] == true,
                    onClick = { chipStates[brand] = !(chipStates[brand] ?: false) },
                    label = { Text(brand) }
                )
            }
        }
    }
}