package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.designSystem.component.DesignSystemScreen

@Composable
fun MainScreen(navController: NavHostController) {
    DesignSystemScreen.Screen() {
        Text("Main")
    }
}