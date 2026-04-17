package com.example.core.designSystem.component

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.core.conditional
import com.example.core.designSystem.theme.DesignSystemTheme

@Composable
fun DesignSystemText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DesignSystemTheme.color.text.main,
    marquee: Boolean = false,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    style: TextStyle = DesignSystemTheme.typography.typography6.regular,
    selectable: Boolean = false
) {
    val enableMarquee = marquee && !selectable

    val content: @Composable () -> Unit = {
        Text(
            text = text,
            modifier = modifier
                .conditional(condition = marquee) {
                    basicMarquee()
                    drawWithContent {
                        drawContent()

                        val edgeWidthPx = 24.dp.toPx()
                        val width = size.width

                        drawRect(
                            brush = Brush.horizontalGradient(
                                colorStops = arrayOf(
                                    0f to Color.Transparent,
                                    (edgeWidthPx / width) to Color.Black,
                                    (1f - edgeWidthPx / width) to Color.Black,
                                    1f to Color.Transparent
                                )
                            ),
                            blendMode = BlendMode.DstIn
                        )
                    }
                },
            color = color,
            overflow = if (enableMarquee) TextOverflow.Clip else overflow,
            softWrap = if (enableMarquee) false else softWrap,
            maxLines = if (enableMarquee) 1 else maxLines,
            minLines = minLines,
            style = style
        )
    }

    if (selectable && !marquee) {
        SelectionContainer {
            content()
        }
    } else {
        content()
    }
}

@DesignSystemPreview
@Composable
fun TextPreview() {
    DesignSystemTheme {
        DesignSystemText(
            text = "sdafdsaasfddfsafdsasdfa",
            marquee = true
        )
    }
}