package com.example.presentation.component

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.presentation.Icon.close
import com.example.presentation.Icon.person
import com.example.presentation.theme.DesignSystemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTopBar(
    title: @Composable () -> Unit,
    size: Dp = DesignSystemTheme.space.space4,
    leftIcons: List<ImageVector>,
    rightIcons: List<ImageVector>,
    onLeftIconClick: () -> Unit,
    onRightIconClick: List<() -> Unit>
) {
    TopAppBar(
        title = { title() },
        navigationIcon = @Composable {
            leftIcons.forEach { DesignSystemIcon(name = it, onClick = onLeftIconClick, size = size) }
        },
        actions = @Composable {
            rightIcons.forEachIndexed { index, value ->
                DesignSystemIcon(
                    name = value,
                    onClick = onRightIconClick[index]
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryTopBar() {
    PrimaryTopBar(
        title = { Text("title") },
        leftIcons = listOf(close),
        rightIcons = listOf(close, person),
        onLeftIconClick = { },
        onRightIconClick = listOf(
            {  },
            {  }
        ),
    )
}