package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemDp

@Composable
fun PrimaryScreen(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = DesignSystemDp.Space4,
                top = DesignSystemDp.Space4,
                end = DesignSystemDp.Space4
            ),
    ) {
        content()
    }
}