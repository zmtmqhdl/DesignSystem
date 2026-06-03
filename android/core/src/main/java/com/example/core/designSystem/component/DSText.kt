package com.example.core.designSystem.component

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.modifier.conditional
import com.example.core.designSystem.theme.DSTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

// todo - marque랑 복붙 되는지 확인하고, ㅣ애니메이션이랑도 중첩 되는지도 확인해보시다잉
@Composable
fun DSText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DSTheme.color.text.main,
    marquee: Boolean = false,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    style: TextStyle = DSTheme.typography.typography6.regular,
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


@DSPreview
@Composable
fun TextPreview() {
    DSTheme {
        var visible by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(duration = 1.seconds)
            visible = true
        }

        DSText(
            text = "test",
            marquee = true
        )
    }
}