package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.presentation.viewModel.HomeViewModel


@Composable
fun MainScreen(
    navController: NavController
) {
    DesignSystemScreen.PrimaryScreen() {
        Text("Main")
    }
}