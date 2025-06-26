package com.example.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.presentation.component.Icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.presentation.core.DesignSystemPreview

@Composable
fun DesignSystemIcon(
    icon: ImageVector,
    onClick: (() -> Unit) = {},
    boxWidth: Dp = DesignSystemTheme.space.space8,
    boxHeight: Dp = DesignSystemTheme.space.space8,
    iconWidth: Dp = DesignSystemTheme.space.space4,
    iconHeight: Dp = DesignSystemTheme.space.space4,
    color: Color = DesignSystemTheme.color.black,
) {
    Box(
        modifier = Modifier
            .width(boxWidth)
            .height(boxHeight),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .width(iconWidth)
                .height(iconHeight)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
            tint = color
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemIconPreview() {
    DesignSystemIcon(
        icon = Close,
        onClick = { },
    )
}