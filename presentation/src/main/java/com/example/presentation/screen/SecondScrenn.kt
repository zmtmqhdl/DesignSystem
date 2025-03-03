package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SecondScreen(
    navController: NavController
) {
    DesignSystemScreen.PrimaryScreen() {
        Text("Second")
    }
}