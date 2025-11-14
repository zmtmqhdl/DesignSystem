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
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.theme.DesignSystemTheme

@Composable
fun DesignSystemIcon(
    icon: ImageVector,
    boxSize: Dp = DesignSystemTheme.space.space10,
    iconWidth: Dp = DesignSystemTheme.space.space6,
    iconHeight: Dp = DesignSystemTheme.space.space6,
    color: Color = DesignSystemTheme.colorSet.grey.mainBackgroundColor,
    ariaLabel: String
) {
    Box(
        modifier = Modifier
            .size(size = boxSize),
        contentAlignment = Alignment.Center
    ) {
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

@DesignSystemPreview
@Composable
fun DesignSystemIconPreview() {
    DesignSystemTheme {
        DesignSystemIcon(
            icon = Search,
            ariaLabel = "Search"
        )
    }
}