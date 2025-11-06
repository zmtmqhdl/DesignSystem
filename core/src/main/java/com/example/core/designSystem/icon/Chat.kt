package com.example.core.designSystem.icon

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemTheme

val Chat = ImageVector.Builder(
    defaultWidth = 24.0.dp,
    defaultHeight = 24.0.dp,
    viewportWidth = 960.0f,
    viewportHeight = 960.0f
).apply {
    path(
        fill = SolidColor(Color(0xFFe8eaed)),
        stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt,
        strokeLineJoin = Miter,
        strokeLineMiter = 4.0f,
        pathFillType = NonZero
    ) {
        moveTo(240.0f, 560.0f)
        horizontalLineToRelative(320.0f)
        verticalLineToRelative(-80.0f)
        lineTo(240.0f, 480.0f)
        verticalLineToRelative(80.0f)
        close()
        moveTo(240.0f, 440.0f)
        horizontalLineToRelative(480.0f)
        verticalLineToRelative(-80.0f)
        lineTo(240.0f, 360.0f)
        verticalLineToRelative(80.0f)
        close()
        moveTo(240.0f, 320.0f)
        horizontalLineToRelative(480.0f)
        verticalLineToRelative(-80.0f)
        lineTo(240.0f, 240.0f)
        verticalLineToRelative(80.0f)
        close()
        moveTo(80.0f, 880.0f)
        verticalLineToRelative(-720.0f)
        quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
        reflectiveQuadTo(160.0f, 80.0f)
        horizontalLineToRelative(640.0f)
        quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
        reflectiveQuadTo(880.0f, 160.0f)
        verticalLineToRelative(480.0f)
        quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
        reflectiveQuadTo(800.0f, 720.0f)
        lineTo(240.0f, 720.0f)
        lineTo(80.0f, 880.0f)
        close()
        moveTo(206.0f, 640.0f)
        horizontalLineToRelative(594.0f)
        verticalLineToRelative(-480.0f)
        lineTo(160.0f, 160.0f)
        verticalLineToRelative(525.0f)
        lineToRelative(46.0f, -45.0f)
        close()
        moveTo(160.0f, 640.0f)
        verticalLineToRelative(-480.0f)
        verticalLineToRelative(480.0f)
        close()
    }
}
    .build()

@DesignSystemPreview
@Composable
private fun ChatPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Chat,
            contentDescription = null,
        )
    }
}