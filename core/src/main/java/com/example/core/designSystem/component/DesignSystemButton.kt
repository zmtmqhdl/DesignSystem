package com.example.core.designSystem.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemTheme

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE,
    XLARGE
}

enum class ButtonColor {
    PRIMARY,
    DARK,
    DANGER
}

enum class ButtonVariant {
    FILL,
    WEAK
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    size: ButtonSize = ButtonSize.MEDIUM,
    variant: ButtonVariant = ButtonVariant.FILL,
    color: ButtonColor = ButtonColor.PRIMARY,
    enabled: Boolean = true,
    width: Dp? = null,
    fraction: Float = 1f,
    loading: Boolean = false
) {
    val shape = when (size) {
        ButtonSize.SMALL -> RoundedCornerShape(size = 8.dp)
        ButtonSize.MEDIUM -> RoundedCornerShape(size = 10.dp)
        ButtonSize.LARGE -> RoundedCornerShape(size = 14.dp)
        ButtonSize.XLARGE -> RoundedCornerShape(size = 16.dp)
    }

    Box(
        modifier = Modifier
            .then(
                if (width != null) Modifier.width(width) else Modifier.fillMaxWidth(fraction)
            )
            .defaultMinSize(
                minWidth = when (size) {
                    ButtonSize.SMALL -> 52.dp
                    ButtonSize.MEDIUM -> 64.dp
                    ButtonSize.LARGE -> 80.dp
                    ButtonSize.XLARGE -> 96.dp
                },
                minHeight = when (size) {
                    ButtonSize.SMALL -> 32.dp
                    ButtonSize.MEDIUM -> 38.dp
                    ButtonSize.LARGE -> 48.dp
                    ButtonSize.XLARGE -> 56.dp
                }
            )
            .alpha(if (enabled) 1f else 0.3f)
            .background(
                color = when (variant) {
                    ButtonVariant.FILL -> when (color) {
                        ButtonColor.PRIMARY -> DesignSystemTheme.color.blue500
                        ButtonColor.DARK -> DesignSystemTheme.color.grey700
                        ButtonColor.DANGER -> DesignSystemTheme.color.red500
                    }

                    ButtonVariant.WEAK -> when (color) {
                        ButtonColor.PRIMARY -> DesignSystemTheme.color.blue100
                        ButtonColor.DARK -> DesignSystemTheme.color.greyOpacity100
                        ButtonColor.DANGER -> DesignSystemTheme.color.red50
                    }
                },
                shape = shape
            )
            .clip(shape)
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
            .semantics { role = Role.Button },
        contentAlignment = Alignment.Center
    ) {
        if (loading) {
            ButtonLoader(size = size)
        } else {
            DesignSystemText(
                text = text,
                modifier = Modifier.padding(
                    horizontal = when (size) {
                        ButtonSize.SMALL -> 10.dp
                        ButtonSize.MEDIUM -> 16.dp
                        ButtonSize.LARGE -> 16.dp
                        ButtonSize.XLARGE -> 15.dp
                    },
                    vertical = when (size) {
                        ButtonSize.SMALL -> 2.dp
                        ButtonSize.MEDIUM -> 2.dp
                        ButtonSize.LARGE -> 2.dp
                        ButtonSize.XLARGE -> 28.dp
                    }
                ),
                color = when (variant) {
                    ButtonVariant.FILL -> Color.White
                    ButtonVariant.WEAK -> when (color) {
                        ButtonColor.PRIMARY -> DesignSystemTheme.color.blue600
                        ButtonColor.DARK -> DesignSystemTheme.color.greyOpacity700
                        ButtonColor.DANGER -> DesignSystemTheme.color.red600
                    }
                },
                style = when (size) {
                    ButtonSize.SMALL -> DesignSystemTheme.typography.typography7Medium
                    ButtonSize.MEDIUM -> DesignSystemTheme.typography.typography6Medium
                    ButtonSize.LARGE -> DesignSystemTheme.typography.typography5Medium
                    ButtonSize.XLARGE -> DesignSystemTheme.typography.typography5Medium
                }
            )
        }
    }
}

@Composable
fun ButtonLoader(
    size: ButtonSize = ButtonSize.MEDIUM,
) {
    val color = Color.White
    val infiniteTransition = rememberInfiniteTransition(label = "loader")

    val duration = 600
    val animationDelay = 150

    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = when (size) {
                ButtonSize.SMALL -> 2.dp
                ButtonSize.MEDIUM -> 2.dp
                ButtonSize.LARGE -> 2.dp
                ButtonSize.XLARGE -> 28.dp
            }
        ),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(
            height = when (size) {
                ButtonSize.SMALL -> 5.dp
                ButtonSize.MEDIUM -> 5.dp
                ButtonSize.LARGE -> 8.dp
                ButtonSize.XLARGE -> 8.dp
            },
        )
    ) {
        repeat(3) { index ->
            val delay = index * animationDelay

            val scale by infiniteTransition.animateFloat(
                initialValue = 0.7f,
                targetValue = 1.1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = duration
                        0.7f at (0 + delay)
                        1.1f at (200 + delay)
                        0.7f at (400 + delay)
                        0.7f at duration
                    },
                    repeatMode = RepeatMode.Restart
                ),
                label = "scale$index"
            )

            val alpha by infiniteTransition.animateFloat(
                initialValue = 0.2f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = duration
                        0.2f at (0 + delay)
                        1f at (200 + delay)
                        0.2f at (400 + delay)
                        0.2f at duration
                    },
                    repeatMode = RepeatMode.Restart
                ),
                label = "alpha$index"
            )

            Box(
                modifier = Modifier
                    .size(
                        size = when (size) {
                            ButtonSize.SMALL -> 5.dp
                            ButtonSize.MEDIUM -> 5.dp
                            ButtonSize.LARGE -> 8.dp
                            ButtonSize.XLARGE -> 8.dp
                        }
                    )
                    .scale(scale)
                    .background(color.copy(alpha = alpha), CircleShape)
            )
        }
    }
}

@DesignSystemPreview
@Composable
fun DesignSystemButtonPreview() {
    DesignSystemTheme {
        PrimaryButton(
            text = "Preview",
            variant = ButtonVariant.WEAK,
            color = ButtonColor.DARK,
            loading = false,
            onClick = {},
        )
    }
}

