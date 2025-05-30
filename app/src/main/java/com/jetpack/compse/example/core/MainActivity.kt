package com.jetpack.compse.example.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpack.compse.example.buttons.ButtonSample
import com.jetpack.compse.example.buttons.ButtonScreen
import com.jetpack.compse.example.buttons.ButtonWithIconSample
import com.jetpack.compse.example.buttons.ElevatedButtonSample
import com.jetpack.compse.example.buttons.OutlinedButtonSample
import com.jetpack.compse.example.chip.BrandsFilterChip
import com.jetpack.compse.example.chip.ChipScreen
import com.jetpack.compse.example.dialog.AlertDialogWithIconSample
import com.jetpack.compse.example.dialog.BasicAlertDialogSample
import com.jetpack.compse.example.dialog.DialogScreen
import com.jetpack.compse.example.text.BasicTextFieldExample
import com.jetpack.compse.example.text.EmailTextFieldWithValidation
import com.jetpack.compse.example.text.PasswordTextFieldExample
import com.jetpack.compse.example.text.SimpleTextGreetings
import com.jetpack.compse.example.text.TextFieldScreen
import com.jetpack.compse.example.ui.theme.JetpackComposeBitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()

            /**
             * Application theme
             */
            JetpackComposeBitsTheme {

                /*
                Navigation host to manage screen navigation
                 */
                NavHost(
                    modifier = Modifier.safeContentPadding(),
                    navController = navController,
                    // Default launch is mainScreen
                    startDestination = "mainScreen"
                ) {
                    composable("mainScreen") {
                        MainScreen(navController = navController)
                    }

                    /*
                    Navigation for Text
                     */
                    composable("example1") {
                        SimpleTextGreetings()
                    }

                    /*
                    Navigation for Text Field Examples
                     */
                    composable("example2") {
                        TextFieldScreen(navController = navController)
                    }
                    composable("textField1") {
                        BasicTextFieldExample()
                    }
                    composable("textField2") {
                        PasswordTextFieldExample()
                    }
                    composable("textField3") {
                        EmailTextFieldWithValidation()
                    }

                    /*
                    Navigation for Dialog Examples
                     */
                    composable("example3") {
                        DialogScreen(navController = navController)
                    }
                    composable("dialog1") {
                        BasicAlertDialogSample(navController)
                    }
                    composable("dialog2") {
                        AlertDialogWithIconSample(navController)
                    }

                    /*
                    Navigation for Button Examples
                     */
                    composable("example4") {
                        ButtonScreen(navController = navController)
                    }
                    composable("button1") {
                        ButtonSample()
                    }
                    composable("button2") {
                        ButtonWithIconSample()
                    }
                    composable("button3") {
                        OutlinedButtonSample()
                    }
                    composable("button4") {
                        ElevatedButtonSample()
                    }

                    /*
                    Navigation for Chip Examples
                     */
                    composable("example5") {
                        ChipScreen(navController = navController)
                    }
                    composable("chip1") {
                        BrandsFilterChip()
                    }
                }
            }
        }
    }
}