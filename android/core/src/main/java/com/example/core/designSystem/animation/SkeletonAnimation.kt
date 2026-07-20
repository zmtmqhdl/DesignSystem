package com.example.core.designSystem.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.example.core.designSystem.theme.DSTheme

fun Modifier.skeletonAnimation(
    isLoading: Boolean
): Modifier = composed {
    if (!isLoading) {
        return@composed this
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
            animation = tween(durationMillis = 1200, easing = LinearEasing),
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

    this
        .onGloballyPositioned { size = it.size }
        .background(brush = shimmerBrush)
}