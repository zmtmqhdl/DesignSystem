package com.example.core.designSystem.component

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemTheme

@Composable
fun DesignSystemText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DesignSystemTheme.colorSet.textColor.mainColor,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    style: TextStyle = DesignSystemTheme.typography.typography6.regular,
    selectable: Boolean = false
) {
    val content: @Composable () -> Unit = {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            minLines = minLines,
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

@DesignSystemPreview
@Composable
fun TextPreview() {
    DesignSystemTheme {
        DesignSystemText(
            text = "Preview",
        )
    }
}