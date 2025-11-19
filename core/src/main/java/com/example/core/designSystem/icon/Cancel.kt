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
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemTheme

// todo - 아이콘 바꿔야하고 배경이 가득차고, x만 빈 색깔
val Cancel = ImageVector.Builder(
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
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
        strokeLineMiter = 1.0f
    ) {
        moveTo(12f, 2f)
        arcToRelative(10f, 10f, 0f, true, false, 0f, 20f)
        arcToRelative(10f, 10f, 0f, false, false, 0f, -20f)
        close()

        moveToRelative(336f, -280f)
        lineToRelative(144f, -144f)
        lineToRelative(144f, 144f)
        lineToRelative(56f, -56f)
        lineToRelative(-144f, -144f)
        lineToRelative(144f, -144f)
        lineToRelative(-56f, -56f)
        lineToRelative(-144f, 144f)
        lineToRelative(-144f, -144f)
        lineToRelative(-56f, 56f)
        lineToRelative(144f, 144f)
        lineToRelative(-144f, 144f)
        lineToRelative(56f, 56f)
        close()
        moveTo(480f, 880f)
        quadToRelative(-83f, 0f, -156f, -31.5f)
        reflectiveQuadTo(197f, 763f)
        quadToRelative(-54f, -54f, -85.5f, -127f)
        reflectiveQuadTo(80f, 480f)
        quadToRelative(0f, -83f, 31.5f, -156f)
        reflectiveQuadTo(197f, 197f)
        quadToRelative(54f, -54f, 127f, -85.5f)
        reflectiveQuadTo(480f, 80f)
        quadToRelative(83f, 0f, 156f, 31.5f)
        reflectiveQuadTo(763f, 197f)
        quadToRelative(54f, 54f, 85.5f, 127f)
        reflectiveQuadTo(880f, 480f)
        quadToRelative(0f, 83f, -31.5f, 156f)
        reflectiveQuadTo(763f, 763f)
        quadToRelative(-54f, 54f, -127f, 85.5f)
        reflectiveQuadTo(480f, 880f)
        close()
        moveToRelative(0f, -80f)
        quadToRelative(134f, 0f, 227f, -93f)
        reflectiveQuadToRelative(93f, -227f)
        quadToRelative(0f, -134f, -93f, -227f)
        reflectiveQuadToRelative(-227f, -93f)
        quadToRelative(-134f, 0f, -227f, 93f)
        reflectiveQuadToRelative(-93f, 227f)
        quadToRelative(0f, 134f, 93f, 227f)
        reflectiveQuadToRelative(227f, 93f)
        close()
        moveToRelative(0f, -320f)
        close()
    }
}.build()

@DesignSystemPreview
@Composable
private fun CancelPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Cancel,
            contentDescription = null,
        )
    }
}