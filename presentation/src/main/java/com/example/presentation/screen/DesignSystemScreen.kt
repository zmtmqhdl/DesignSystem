package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun PrimaryScreen(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = DesignSystemTheme.space.space4,
                top = DesignSystemTheme.space.space4,
                end = DesignSystemTheme.space.space4
            ),
    ) {
        content()
    }
}