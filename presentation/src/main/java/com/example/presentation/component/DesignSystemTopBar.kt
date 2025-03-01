package com.example.presentation.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopBar(
    title: @Composable () -> Unit,
    leftIcons: List<String>,
    rightIcons: List<String>
) {
    TopAppBar(
        title = { title() },
        navigationIcon = @Composable {
            leftIcons.forEach { DesignSystemIcon(name = it) }
        },
        actions = @Composable {
            rightIcons.forEach { DesignSystemIcon(name = it) }
        }
    )
}

@Preview
@Composable
fun PreviewPrimaryTopBar() {
    PrimaryTopBar(
        title = { Text("test") },
        leftIcons = listOf("icon_back", "icon_close"),
        rightIcons = listOf("icon_close", "icon_back"),
    )
}