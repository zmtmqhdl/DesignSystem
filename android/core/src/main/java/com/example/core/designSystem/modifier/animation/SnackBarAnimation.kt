package com.example.core.designSystem.modifier.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.snackBarAnimation(
    visible: Boolean,
    onFinished: () -> Unit
): Modifier {
    val alpha = remember { Animatable(0f) }
    val density = LocalDensity.current

    LaunchedEffect(visible) {
        alpha.animateTo(
            targetValue = if (visible) 1f else 0f,
            animationSpec = tween(delayMillis = 250)
        )

        if (!visible) {
            onFinished.invoke()
        }
    }

    return graphicsLayer {
        this.alpha = alpha.value
        translationY =
            with(density) {
                (1f - alpha.value) * 32.dp.toPx()
            }
    }
}