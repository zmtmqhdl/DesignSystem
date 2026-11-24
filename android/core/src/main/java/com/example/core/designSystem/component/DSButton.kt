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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.ColorSet
import com.example.core.util.extension.conditional

enum class ButtonVariant {
    FILL, WEAK
}

enum class ButtonSize {
    SMALL, MEDIUM, LARGE, XLARGE
}

private data class ButtonStyle(
    val height: Dp,
    val cornerRadius: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val textStyle: TextStyle,
)

@Composable
private fun buttonStyle(size: ButtonSize): ButtonStyle = when (size) {
    ButtonSize.SMALL -> ButtonStyle(
        height = DSTheme.dimension.dimension32,
        cornerRadius = DSTheme.dimension.dimension8,
        horizontalPadding = DSTheme.dimension.dimension10,
        verticalPadding = DSTheme.dimension.dimension2,
        textStyle = DSTheme.typography.typography7.medium.copy(
            textMotion = TextMotion.Animated,
        )
    )
    ButtonSize.MEDIUM -> ButtonStyle(
        height = DSTheme.dimension.dimension38,
        cornerRadius = DSTheme.dimension.dimension10,
        horizontalPadding = DSTheme.dimension.dimension16,
        verticalPadding = DSTheme.dimension.dimension2,
        textStyle = DSTheme.typography.typography6.medium.copy(
            textMotion = TextMotion.Animated,
        )
    )
    ButtonSize.LARGE -> ButtonStyle(
        height = DSTheme.dimension.dimension48,
        cornerRadius = DSTheme.dimension.dimension14,
        horizontalPadding = DSTheme.dimension.dimension16,
        verticalPadding = DSTheme.dimension.dimension2,
        textStyle = DSTheme.typography.typography5.medium.copy(
            textMotion = TextMotion.Animated,
        )
    )
    ButtonSize.XLARGE -> ButtonStyle(
        height = DSTheme.dimension.dimension56,
        cornerRadius = DSTheme.dimension.dimension16,
        horizontalPadding = DSTheme.dimension.dimension28,
        verticalPadding = DSTheme.dimension.dimension15,
        textStyle = DSTheme.typography.typography5.medium.copy(
            textMotion = TextMotion.Animated,
        )
    )
}

/**
 *
 * Use [DSButton] to trigger an action.
 *
 * Use [size] to choose the button's dimensions and text style, and [variant] with [colorSet] to choose its colors.
 *
 * Do not set the size through [modifier].
 *
 */
@Composable
fun DSButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    size: ButtonSize = ButtonSize.MEDIUM,
    variant: ButtonVariant = ButtonVariant.FILL,
    colorSet: ColorSet = DSTheme.color.blue,
    enabled: Boolean = true,
    fillWidth: Boolean = false,
    fraction: Float = 1f,
    showLoader: Boolean = false,
    isLoading: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressedAlpha = 0.3f
    val buttonStyle = buttonStyle(size)
    val pushedSize = 0.99f
    val dimColor = DSTheme.color.greyOpacity900

    val scale by animateFloatAsState(
        targetValue = if (isPressed && !isLoading) pushedSize else 1f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing)
    )

    val overlayAlpha by animateFloatAsState(
        targetValue = if (isPressed && enabled && !isLoading && !showLoader) 0.12f else 0f,
        animationSpec = tween(durationMillis = 80, easing = FastOutSlowInEasing),
    )

    val buttonShape = RoundedCornerShape(buttonStyle.cornerRadius)

    Box(
        modifier = modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .height(buttonStyle.height)
            .conditional(fillWidth) { fillMaxWidth(fraction) }
            .conditional(!isLoading) {
                alpha(if (enabled) 1f else pressedAlpha)
                background(
                    color = when (variant) {
                        ButtonVariant.FILL -> colorSet.mainBackgroundColor
                        ButtonVariant.WEAK -> colorSet.subBackgroundColor
                    },
                    shape = buttonShape
                )
            }
            .drawWithContent {
                drawContent()
                if (overlayAlpha > 0f) {
                    drawRoundRect(
                        color = dimColor.copy(alpha = overlayAlpha),
                        cornerRadius = CornerRadius(buttonStyle.cornerRadius.toPx())
                    )
                }
            }
            .clip(shape = buttonShape)
            .skeletonAnimation(isLoading = isLoading)
            .clickable(
                enabled = enabled && !showLoader && !isLoading,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (showLoader) {
            ButtonLoader(size)
        }

        DSText(
            text = text,
            modifier = Modifier
                .conditional(isLoading || showLoader) { alpha(0f) }
                .padding(
                    horizontal = buttonStyle.horizontalPadding,
                    vertical = buttonStyle.verticalPadding,
                ),
            color = when (variant) {
                ButtonVariant.FILL -> colorSet.mainColor
                ButtonVariant.WEAK -> colorSet.subColor
            },
            style = buttonStyle.textStyle
        )
    }
}


@Composable
private fun ButtonLoader(
    size: ButtonSize = ButtonSize.MEDIUM,
) {
    val color = DSTheme.color.buttonLoader
    val infiniteTransition = rememberInfiniteTransition()
    val duration = 600
    val animationDelay = 150

    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = when (size) {
                ButtonSize.SMALL -> DSTheme.dimension.dimension3
                ButtonSize.MEDIUM -> DSTheme.dimension.dimension4
                ButtonSize.LARGE -> DSTheme.dimension.dimension5
                ButtonSize.XLARGE -> DSTheme.dimension.dimension7
            }
        ),
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
            )

            Box(
                modifier = Modifier
                    .size(
                        when (size) {
                            ButtonSize.SMALL,
                            ButtonSize.MEDIUM -> DSTheme.dimension.dimension5

                            ButtonSize.LARGE,
                            ButtonSize.XLARGE -> DSTheme.dimension.dimension8
                        }
                    )
                    .scale(scale)
                    .background(
                        color = color.copy(alpha),
                        shape = CircleShape
                    )
            )
        }
    }
}

@DSPreview
@Composable
fun DSButtonPreview() {
    DSTheme {
        DSButton(
            text = "DSButtonPreview",
            variant = ButtonVariant.WEAK,
            colorSet = DSTheme.color.blue,
            showLoader = true,
            onClick = {},
        )
    }
}