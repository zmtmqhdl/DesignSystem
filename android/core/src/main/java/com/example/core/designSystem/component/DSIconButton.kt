package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.core.conditional
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.scheme.ColorSet
import com.example.core.designSystem.theme.DSTheme

enum class IconButtonVariant {
    CLEAR,
    FILL,
    BORDER
}

@Composable
fun DSIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    boxSize: Dp = DSTheme.space.space12,
    iconWidth: Dp = DSTheme.space.space6,
    iconHeight: Dp = DSTheme.space.space6,
    variant: IconButtonVariant = IconButtonVariant.CLEAR,
    colorSet: ColorSet = DSTheme.color.grey,
    interactionSource: MutableInteractionSource? = null,
    ariaLabel: String
) {
    val shape = DSTheme.shape.iconButton

    Box(
        modifier = Modifier
            .size(size = boxSize)
            .clip(shape = shape)
            .conditional(
                condition = variant == IconButtonVariant.FILL
            ) {
                background(
                    color = colorSet.subBackgroundColor,
                    shape = shape
                )
            }
            .conditional(
                condition = variant == IconButtonVariant.BORDER
            ) {
                border(
                    width = 1.dp,
                    color = colorSet.subBackgroundColor,
                    shape = shape
                )
            }
            .clickable(
                onClick = onClick,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = ripple(),
            )
            .semantics(mergeDescendants = true) { },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = ariaLabel,
            modifier = Modifier
                .width(width = iconWidth)
                .height(height = iconHeight),
            tint = colorSet.subColor
        )
    }
}

@DSPreview
@Composable
private fun IconButtonPreview() {
    DSTheme {
        DSIconButton(
            icon = Close,
            colorSet = DSTheme.color.grey,
            variant = IconButtonVariant.BORDER,
            onClick = { },
            ariaLabel = "test"
        )
    }
}