package com.example.core.designSystem.component

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

@Composable
fun DSText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DSTheme.color.text.main,
    marquee: Boolean = false,
    marqueeDelayMillis: Int = 0,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = DSTheme.typography.typography6.regular,
    selectable: Boolean = false
) {
    val enableMarquee = marquee && !selectable
    val fadeWidth = 12.dp

    val content: @Composable () -> Unit = {
        if (enableMarquee) {
            Box(
                modifier = modifier
                    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                    .drawWithContent {
                        drawContent()
                        val edgeWidthPx = fadeWidth.toPx()
                        val contentWidth = size.width
                        if (contentWidth > 0f) {
                            val startAlphaStop = (edgeWidthPx / contentWidth).coerceAtMost(0.5f)
                            val endAlphaStop = (1f - (edgeWidthPx / contentWidth)).coerceAtLeast(0.5f)
                            drawRect(
                                brush = Brush.horizontalGradient(
                                    colorStops = arrayOf(
                                        0f to Color.Transparent,
                                        startAlphaStop to Color.Black,
                                        endAlphaStop to Color.Black,
                                        1f to Color.Transparent
                                    )
                                ),
                                blendMode = BlendMode.DstIn
                            )
                        }
                    }
            ) {
                Text(
                    text = text,
                    modifier = Modifier.basicMarquee(
                        iterations = Int.MAX_VALUE,
                        initialDelayMillis = marqueeDelayMillis
                    ),
                    color = color,
                    overflow = TextOverflow.Clip,
                    softWrap = false,
                    maxLines = 1,
                    style = style
                )
            }
        } else {
            Text(
                text = text,
                modifier = modifier,
                color = color,
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                style = style
            )
        }
    }

    if (selectable) {
        SelectionContainer {
            content()
        }
    } else {
        content()
    }
}


@DSPreview
@Composable
fun TextPreview() {
    DSTheme {
        DSText(
            text = "testtestestestest",
            marquee = true
        )
    }
}