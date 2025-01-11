package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimaryColumn(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = DesignSystemSpace.M, top = DesignSystemSpace.M, end = DesignSystemSpace.M),
        content = content
    )
}