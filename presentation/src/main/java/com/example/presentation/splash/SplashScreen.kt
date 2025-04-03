package com.example.presentation.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.presentation.screen.DesignSystemScreen
import com.example.presentation.screen.DesignSystemScreen.PrimaryScreen

@Composable
fun SplashScreen() {
    PrimaryScreen() {
        Text("Splash")
    }
}