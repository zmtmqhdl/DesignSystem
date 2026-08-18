package com.example.core.designSystem.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.theme.DSTheme

@Composable
fun Modifier.skeletonAnimation(
    isLoading: Boolean
): Modifier {
    if (!isLoading) {
        return this
    }

    val colorSet = DSTheme.color.skeleton
    val background = colorSet.background
    val highlight = colorSet.highlight

    val transition = rememberInfiniteTransition(label = "skeletonAnimation")
    var size by remember { mutableStateOf(IntSize.Zero) }

    val translateAnim by transition.animateFloat(
        initialValue = -2f * size.width,
        targetValue = 2f * size.width,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "skeletonAnimation"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(background, highlight, background),
        start = Offset(x = translateAnim, y = 0f),
        end = Offset(
            x = translateAnim + size.width,
            y = size.width.toFloat()
        )
    )

    return this
        .onGloballyPositioned { size = it.size }
        .background(brush = shimmerBrush)
}

@Preview
@Composable
private fun SnackBarAnimationPreview() {
    DSTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DSText(
                text = "Preview1",
                style = DSTheme.typography.typography1.bold,
                modifier = Modifier.skeletonAnimation(isLoading = true)
            )
        }
    }
}