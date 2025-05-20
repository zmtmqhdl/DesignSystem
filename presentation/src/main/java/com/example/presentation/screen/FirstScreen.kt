package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.presentation.component.DesignSystemScreen

@Composable
fun FirstScreen() {
    DesignSystemScreen.PrimaryScreen() {
        Text("First")
    }
}