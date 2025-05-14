package com.jetpack.compse.example.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jetpack.compse.example.R

val dialogExampleList = listOf(
    "Basic Alert Dialog",
    "Alert Dialog with Icon",
)

@Composable
fun DialogScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        dialogExampleList.forEachIndexed { index, title ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate("dialog${index + 1}")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicAlertDialogSample(
    navController: NavController
) {
    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value) {
        BasicAlertDialog(
            onDismissRequest = {
                // Close dialog when user taps outside or presses back
                showDialog.value = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Are you sure you want to proceed?",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextButton(
                        onClick = {
                            showDialog.value = false
                            navController.popBackStack()
                                  },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Got it")
                    }
                }
            }
        }
    }
}

@Composable
fun AlertDialogWithIconSample(
    navController: NavController
) {
    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Favorite Icon"
                )
            },
            title = { Text(text = "Action Required") },
            text = {
                Text("Do you want to save your changes before exiting?")
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    navController.popBackStack()
                }) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    navController.popBackStack()
                }) {
                    Text("Discard")
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewAlertDialogSample() {
    val navController = rememberNavController()

    BasicAlertDialogSample(navController)

//    AlertDialogWithIconSample(navController)
}