package com.jetpack.compse.example.buttons

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jetpack.compse.example.R

val buttonsExampleList = listOf(
    "Filled Button",
    "Button with Icon",
    "Outlined Button",
    "Elevated Button",
)

/*
Following composable is to create a list of buttons mentioned
in 'buttonExampleList'.
It will iterate and create buttons where each button do call
a specific composable to demonstrate the example
 */
@Composable
fun ButtonScreen(
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
        buttonsExampleList.forEachIndexed { index, title ->
            /*
            Create a row composable to hold a text
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate("button${index + 1}")
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
fun ButtonSample() {

    // To show Toast, we need context
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        Ideally button needs 2 argument compulsory
        1. onClick: A function which will be called when button is pressed
        2. content: A composable which a button can host. In our case it will be Text
         */
        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Click Me!")
        }
    }
}

@Preview
@Composable
fun ButtonWithIconSample() {

    // To show Toast, we need context
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Like Button Clicked", Toast.LENGTH_SHORT).show()
            },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            /*
            Content inside Button is a Row Scope.
            So children will be organized from start to end
            Here, in this example, we took Icon + Space + Text
             */
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Localized description",
                modifier = Modifier.run { size(ButtonDefaults.IconSize) }
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Like")
        }
    }
}

@Composable
fun OutlinedButtonSample() {

    // To show Toast, we need context
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        To use outlined button, OutlinedButton composable is helpful.
        As like normal button, it also need 2 mandatory argument
        1. onClick
        2. content
         */
        OutlinedButton (
            onClick = {
                Toast.makeText(context, "Outlined Button Clicked", Toast.LENGTH_SHORT).show()
            },
        ) {
            Text("Outlined Button")
        }
    }
}

@Composable
fun ElevatedButtonSample() {

    // To show Toast, we need context
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(
            onClick = {
                Toast.makeText(context, "Elevated Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Elevated Button")
        }
    }
}