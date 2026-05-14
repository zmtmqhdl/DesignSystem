package com.example.core.designSystem.icon

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.DS
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

val Forward = ImageVector.Builder(
    defaultWidth = 16.dp,
    defaultHeight = 16.dp,
    viewportWidth = 960f,
    viewportHeight = 960f
).apply {
    path(
        fill = SolidColor(Color.Black),
        fillAlpha = 1.0f,
        stroke = null,
        strokeAlpha = 1.0f,
        strokeLineWidth = 1.0f,
        strokeLineCap = StrokeCap.Butt,
        strokeLineJoin = StrokeJoin.Miter,
        strokeLineMiter = 1.0f,
    ) {
        moveTo(630f, 516f)
        lineTo(192f, 516f)
        lineTo(192f, 444f)
        lineTo(630f, 444f)
        lineTo(429f, 243f)
        lineTo(480f, 192f)
        lineTo(768f, 480f)
        lineTo(480f, 768f)
        lineTo(429f, 717f)
        lineTo(630f, 516f)
        close()
    }
}.build()


@DSPreview
@Composable
private fun ForwardPreview() {
    DS.Theme {
        DS.Icon(
            icon = Forward,
            ariaLabel = "Forward"
        )
    }
}