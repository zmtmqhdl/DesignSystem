package com.example.presentation.component

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.Icon.close
import com.example.presentation.Icon.person

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopBar(
    title: @Composable () -> Unit,
    leftIcons: List<ImageVector>,
    rightIcons: List<ImageVector>,
    onLeftIconClick: (String) -> Unit,
    onRightIconClick: (String) -> Unit,
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
        leftIcons = listOf(close),
        rightIcons = listOf(close, person),
        onRightIconClick = { icon -> Log.d("test", icon) },
        onLeftIconClick = { icon -> Log.d("test", icon) }
    )
}