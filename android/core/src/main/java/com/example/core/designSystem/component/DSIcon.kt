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

/**
 * The overall layout size is determined by [boxSize].
 *
 * The icon size inside it is determined by [iconWidth] and [iconHeight].
 *
 * [ariaLabel] provides an accessibility description for the icon.
 *
 */
@Composable
fun DSIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    boxSize: Dp = DSTheme.dimension.dimension32,
    iconWidth: Dp = DSTheme.dimension.dimension24,
    iconHeight: Dp = DSTheme.dimension.dimension24,
    color: Color = DSTheme.color.grey700,
    ariaLabel: String,
    isLoading: Boolean = false
) {
    Box(
        modifier = modifier
            .size(boxSize)
            .skeletonAnimation(isLoading),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = ariaLabel,
            modifier = Modifier
                .width(iconWidth)
                .height(iconHeight),
            tint = color
        )
    }
}

@DSPreview
@Composable
fun DSIconPreview() {
    DSTheme {
        DSIcon(
            icon = Search,
            ariaLabel = "DSIconPreview"
        )
    }
}