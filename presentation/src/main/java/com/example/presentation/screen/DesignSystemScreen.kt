package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimaryColumn(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = DesignSystemSpace.M, top = DesignSystemSpace.M, end = DesignSystemSpace.M),
    ) {
        content()
    }
}