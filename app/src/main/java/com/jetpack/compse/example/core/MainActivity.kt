package com.jetpack.compse.example.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpack.compse.example.text.SimpleTextGreetings
import com.jetpack.compse.example.ui.theme.JetpackComposeBitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()

            JetpackComposeBitsTheme {

                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") {
                        MainScreen(navController = navController)
                    }

                    composable("example1") {
                        SimpleTextGreetings()
                    }
                }
            }
        }
    }
}