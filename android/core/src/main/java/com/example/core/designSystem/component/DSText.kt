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
import com.example.core.util.extension.conditional
import com.example.core.util.extension.onlyLayoutModifier

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
        Text(
            text = text,
            modifier = modifier
                .conditional(enableMarquee) {
                    // 1. Marquee 페이드 효과를 위한 Offscreen 레이어 생성
                    graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                        .drawWithContent {
                            drawContent() // 텍스트를 먼저 그리고
                            val edgeWidthPx = fadeWidth.toPx()
                            val contentWidth = size.width

                            if (contentWidth > 0f) {
                                val startAlphaStop = (edgeWidthPx / contentWidth).coerceAtMost(0.5f)
                                val endAlphaStop = (1f - (edgeWidthPx / contentWidth)).coerceAtLeast(0.5f)

                                // 2. BlendMode.DstIn으로 알파 채널 마스킹 (양 끝 투명화)
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
                        // 3. basicMarquee를 그리기 및 레이어 설정 후에 연결
                        .basicMarquee(
                            iterations = Int.MAX_VALUE,
                            initialDelayMillis = marqueeDelayMillis
                        )
                },
            color = color,
            overflow = if (enableMarquee) TextOverflow.Clip else overflow,
            softWrap = if (enableMarquee) false else softWrap,
            maxLines = if (enableMarquee) 1 else maxLines,
            style = style
        )
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