package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.core.designSystem.core.DesignSystemPreview

@Composable
fun DesignSystemIcon(
    icon: ImageVector,
    onClick: (() -> Unit) = {},
    enabled: Boolean = true,
    boxSize: Dp = DesignSystemTheme.space.space8,
    iconWidth: Dp = DesignSystemTheme.space.space4,
    iconHeight: Dp = DesignSystemTheme.space.space4,
    backgroundColor: Color = DesignSystemTheme.color.background,
    color: Color = DesignSystemTheme.color.black,
) {
    Box(
        modifier = Modifier
            .size(size = boxSize)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .clip(shape = CircleShape)
            .then(
                if (enabled) {
                    Modifier.clickable(
                        onClick = onClick
                    )
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .width(iconWidth)
                .height(iconHeight),
            tint = if (enabled) color else DesignSystemTheme.color.disable.fontColor
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