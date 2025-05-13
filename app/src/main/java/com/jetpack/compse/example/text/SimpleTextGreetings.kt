package com.jetpack.compse.example.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compse.example.ui.theme.JetpackComposeBitsTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SimpleTextGreetings() {
    // Format today's date
    val currentDate = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(Date())

    // A vertically arranged layout with spacing
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Greeting text
        Text(
            text = "Hello, Jetpack Compose!",
            style = MaterialTheme.typography.bodyLarge
        )
        // Add space between elements
        Spacer(modifier = Modifier.height(12.dp))

        // Date text
        Text(
            text = "Today is $currentDate",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBitsTheme {
        SimpleTextGreetings()
    }
}