package com.example.core.designSystem.modifier

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

@Composable
fun Modifier.entranceAnimation(
    visible: Boolean,
    delayMillis: Int = 0
): Modifier {
    val entranceOffset = 12.dp
    val density = LocalDensity.current
    val progress by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(
            durationMillis = 700,
            delayMillis = delayMillis,
            easing = CubicBezierEasing(
                a = 0.22f,
                b = 1f,
                c = 0.36f,
                d = 1f
            )
        ),
        label = "entranceAnimation"
    )

    return graphicsLayer {
        translationY = with(receiver = density) {
            ((1f - progress) * entranceOffset.toPx())
        }
        alpha = progress
    }
}

@DSPreview
@Composable
private fun EntranceAnimationPreview() {
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