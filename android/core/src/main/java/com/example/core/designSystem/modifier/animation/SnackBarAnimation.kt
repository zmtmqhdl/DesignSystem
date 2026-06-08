package com.example.core.designSystem.modifier.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.theme.DSTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun Modifier.snackBarAnimation(
    visible: Boolean,
    onFinished: () -> Unit
): Modifier {
    val alpha = remember { Animatable(initialValue = 0f) }
    val offsetY = remember { Animatable(initialValue = 40f) }
    val density = LocalDensity.current

    LaunchedEffect(visible) {
        if (visible) {
            coroutineScope {
                launch {
                    alpha.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 250)
                    )
                }

                launch {
                    offsetY.animateTo(
                        targetValue = 0f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }
            }
        } else {
            coroutineScope {
                launch {
                    alpha.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(durationMillis = 250)
                    )
                }

                launch {
                    offsetY.animateTo(
                        targetValue = 32f,
                        animationSpec = tween(durationMillis = 250)
                    )
                }
            }

            onFinished()
        }
    }

    return graphicsLayer {
        this.alpha = alpha.value

        translationY = with(density) {
            offsetY.value.dp.toPx()
        }
    }
}

@Preview
@Composable
private fun SnackBarAnimationPreview() {
    DSTheme {
        var visible by remember { mutableStateOf(false) }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DSText(
                text = "Preview1",
                style = DSTheme.typography.typography1.bold,
                modifier = Modifier.entranceAnimation(
                    visible = visible
                )
            )

            DSText(
                text = "Preview2",
                style = DSTheme.typography.typography4.regular,
                modifier = Modifier.entranceAnimation(
                    visible = visible,
                    delayMillis = 80
                )
            )

            DSText(
                text = "Preview3",
                style = DSTheme.typography.typography5.regular,
                modifier = Modifier.entranceAnimation(
                    visible = visible,
                    delayMillis = 160
                )
            )
        }
    }
}