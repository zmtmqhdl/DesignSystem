package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.core.designSystem.component.DesignSystemScreen

@Composable
fun FirstScreen() {
    DesignSystemScreen.Screen() {
        Text("First")
    }
}