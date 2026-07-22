package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.theme.DSTheme

@Composable
fun DSIcon(
    icon: ImageVector,
    boxSize: Dp = DSTheme.space.dimension8,
    iconWidth: Dp = DSTheme.space.dimension6,
    iconHeight: Dp = DSTheme.space.dimension6,
    color: Color = DSTheme.color.grey700,
    ariaLabel: String,
    isLoading: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(size = boxSize)
            .skeletonAnimation(isLoading = isLoading),
        contentAlignment = Alignment.Center
    ) {
        if (!isLoading) {
            Icon(
                imageVector = icon,
                contentDescription = ariaLabel,
                modifier = Modifier
                    .width(width = iconWidth)
                    .height(height = iconHeight),
                tint = color
            )
        }
    }
}

@DSPreview
@Composable
fun DSIconPreview() {
    DSTheme {
        DSIcon(
            icon = Search,
            ariaLabel = "Search"
        )
    }
}