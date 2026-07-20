package com.example.core.designSystem.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.util.extension.conditional
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.ColorSet

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
    ariaLabel: String,
    isLoading: Boolean = false
) {
    val shape = DSTheme.shape.iconButton
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressedAlpha = 0.3f
    val pushedSize = 0.9f

    val scale by animateFloatAsState(
        targetValue = if (isPressed && !isLoading) pushedSize else 1f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
    )


    Box(
        modifier = Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .defaultMinSize(
                minWidth = boxSize,
                minHeight = boxSize
            )
            .clip(shape = shape)
            .skeletonAnimation(isLoading = isLoading)
            .conditional(
                condition = variant == IconButtonVariant.FILL && !isLoading
            ) {
                background(
                    color = colorSet.subBackgroundColor,
                    shape = shape
                )
            }
            .conditional(
                condition = variant == IconButtonVariant.BORDER && !isLoading
            ) {
                border(
                    width = 1.dp,
                    color = colorSet.subBackgroundColor,
                    shape = shape
                )
            }
            .clickable(
                enabled = !isLoading,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            .semantics(mergeDescendants = true) { role = Role.Button},
        contentAlignment = Alignment.Center
    ) {
        if (!isLoading) {
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