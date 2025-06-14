package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.presentation.component.DesignSystemScreen

@Composable
fun MainScreen(navController: NavHostController) {
    DesignSystemScreen.PrimaryScreen() {
        Text("Main")
    }
}