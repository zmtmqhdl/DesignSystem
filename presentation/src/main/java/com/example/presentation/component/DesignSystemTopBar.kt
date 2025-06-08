package com.example.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.presentation.component.Icon.Back
import com.example.presentation.component.Icon.Close
import com.example.presentation.component.Icon.Forward
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.core.DesignSystemPreview

@Composable
fun PrimaryTopBar(
    title: (@Composable () -> Unit)? = null,
    leftIcons: List<PrimaryTopBarIcon>? = null,
    rightIcons: List<PrimaryTopBarIcon>? = null,
) {
    Column(
        modifier = Modifier.padding(horizontal = DesignSystemTheme.space.space4)
    ) {
        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space5))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftIcons?.forEachIndexed { index, value ->
                DesignSystemIcon(
                    icon = value.icon,
                    size = value.size,
                    onClick = value.onClick
                )
                if (index != leftIcons.lastIndex) {
                    Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))

                }
            }

            Spacer(modifier = Modifier.weight(1f))

            title?.let {
                Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                    it()
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            rightIcons?.forEachIndexed { index, value ->
                if (index != 0) {
                    Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
                }
                DesignSystemIcon(
                    icon = value.icon,
                    size = value.size,
                    onClick = value.onClick
                )
            }
        }
        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space1))
    }
}

data class PrimaryTopBarIcon(
    val icon: ImageVector,
    val size: Dp,
    val onClick: () -> Unit
)

@DesignSystemPreview
@Composable
private fun PrimaryTopBarPreview() {
    PrimaryTopBar(
        title = { Text("title") },
        leftIcons = listOf(
            PrimaryTopBarIcon(
                icon = Back,
                size = 16.dp,
                onClick = {}
            )
        ),
        rightIcons = listOf(
            PrimaryTopBarIcon(
                icon = Close,
                size = 16.dp,
                onClick = {}
            ),
            PrimaryTopBarIcon(
                icon = Forward,
                size = 16.dp,
                onClick = {}
            )
        ),
    )
}