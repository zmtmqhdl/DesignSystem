package com.example.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.designSystem.component.DesignSystemDialog
import com.example.core.designSystem.component.DesignSystemScreen

@Composable
fun MainScreen() {
    DesignSystemScreen.Screen() {
        DesignSystemDialog(
            title = "title",
            confirmText = "confirm",
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    }
}