package com.example.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.core.designSystem.component.BottomSheetVariant
import com.example.core.designSystem.component.DesignSystemBottomSheet
import com.example.core.designSystem.component.DesignSystemScreen
import kotlinx.coroutines.delay

@Composable
fun MainScreen() {
    DesignSystemScreen.Screen() {
        var isOpen by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(2000)
            isOpen = true
        }

        DesignSystemBottomSheet(
            title = "테스트",
            isOpen = isOpen,
            onDismissRequest = { isOpen = false },
            confirmText = "닫기",
            onConfirmClick = {  },
            variant = BottomSheetVariant.DOUBLE_CTA
        )
    }
}