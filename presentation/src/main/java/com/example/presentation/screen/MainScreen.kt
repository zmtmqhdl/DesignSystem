package com.example.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.core.designSystem.component.DesignSystemBottomSheet
import com.example.core.designSystem.component.DesignSystemDialog
import com.example.core.designSystem.component.DesignSystemScreen

@Composable
fun MainScreen() {
    DesignSystemScreen.Screen() {
        var isOpen by remember { mutableStateOf(true) }

        DesignSystemBottomSheet(
            title = "",
            isOpen = isOpen,
            onDismissRequest = {isOpen = false},
            confirmText = ""

        )
    }
}