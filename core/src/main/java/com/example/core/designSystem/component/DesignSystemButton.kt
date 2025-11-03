package com.example.core.designSystem.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.core.conditional
import com.example.core.designSystem.theme.ColorSet
import com.example.core.designSystem.theme.DesignSystemTheme

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE,
    XLARGE
}

enum class ButtonVariant {
    FILL,
    WEAK
}

@Composable
fun DesignSystemButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.MEDIUM,
    variant: ButtonVariant = ButtonVariant.FILL,
    colorSet: ColorSet,
    enabled: Boolean = true,
    full: Boolean = false,
    fraction: Float = 1f,
    loading: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
    )

    // 추가: 글씨 크기 변화용
    val baseFontSize = when (size) {
        ButtonSize.SMALL -> 14.sp
        ButtonSize.MEDIUM -> 16.sp
        ButtonSize.LARGE -> 18.sp
        ButtonSize.XLARGE -> 20.sp
    }

    val animatedFontSize by animateFloatAsState(
        targetValue = if (isPressed) baseFontSize.value * 0.95f else baseFontSize.value,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .conditional(condition = full) { fillMaxWidth(fraction) }
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
                    ButtonVariant.FILL -> colorSet.mainBackgroundColor
                    ButtonVariant.WEAK -> colorSet.subBackgroundColor
                },
                shape = when (size) {
                    ButtonSize.SMALL -> RoundedCornerShape(8.dp)
                    ButtonSize.MEDIUM -> RoundedCornerShape(10.dp)
                    ButtonSize.LARGE -> RoundedCornerShape(14.dp)
                    ButtonSize.XLARGE -> RoundedCornerShape(16.dp)
                }
            )
            .clip(
                shape = when (size) {
                    ButtonSize.SMALL -> RoundedCornerShape(8.dp)
                    ButtonSize.MEDIUM -> RoundedCornerShape(10.dp)
                    ButtonSize.LARGE -> RoundedCornerShape(14.dp)
                    ButtonSize.XLARGE -> RoundedCornerShape(16.dp)
                }
            )
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .semantics { role = Role.Button },
        contentAlignment = Alignment.Center
    ) {
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
            color =
                when (variant) {
                    ButtonVariant.FILL ->
                        if (loading) colorSet.mainBackgroundColor else colorSet.mainFontColor

                    ButtonVariant.WEAK ->
                        if (loading) colorSet.subBackgroundColor else colorSet.subFontColor
                },
            style = when (size) {
                ButtonSize.SMALL -> DesignSystemTheme.typography.typography7.medium.copy(
                    fontSize = animatedFontSize.sp,
                    textMotion = TextMotion.Animated
                )

                ButtonSize.MEDIUM -> DesignSystemTheme.typography.typography6.medium.copy(
                    fontSize = animatedFontSize.sp,
                    textMotion = TextMotion.Animated
                )

                ButtonSize.LARGE -> DesignSystemTheme.typography.typography5.medium.copy(
                    fontSize = animatedFontSize.sp,
                    textMotion = TextMotion.Animated
                )

                ButtonSize.XLARGE -> DesignSystemTheme.typography.typography5.medium.copy(
                    fontSize = animatedFontSize.sp,
                    textMotion = TextMotion.Animated
                )
            }
        )

        if (loading) {
            ButtonLoader(size = size)
        }

    }
}


@Composable
fun ButtonLoader(
    size: ButtonSize = ButtonSize.MEDIUM,
) {
    val color = DesignSystemTheme.colorSet.buttonLoader
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
        DesignSystemButton(
            text = "Preview",
            variant = ButtonVariant.WEAK,
            colorSet = DesignSystemTheme.colorSet.blue,
            loading = true,
            onClick = {},
        )
    }
}

