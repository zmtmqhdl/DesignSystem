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

val Image = ImageVector.Builder(
    defaultWidth = 24.0.dp,
    defaultHeight = 24.0.dp,
    viewportWidth = 960.0f,
    viewportHeight = 960.0f
).apply {
    path(
        fill = SolidColor(Color(0xFFe8eaed)),
        stroke = null,
        strokeLineWidth = 0.0f,
        strokeLineCap = Butt,
        strokeLineJoin = Miter,
        strokeLineMiter = 4.0f,
        pathFillType = NonZero
    ) {
        moveTo(200.0f, 840.0f)
        quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
        reflectiveQuadTo(120.0f, 760.0f)
        verticalLineToRelative(-560.0f)
        quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
        reflectiveQuadTo(200.0f, 120.0f)
        horizontalLineToRelative(560.0f)
        quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
        reflectiveQuadTo(840.0f, 200.0f)
        verticalLineToRelative(560.0f)
        quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
        reflectiveQuadTo(760.0f, 840.0f)
        lineTo(200.0f, 840.0f)
        close()
        moveTo(200.0f, 760.0f)
        horizontalLineToRelative(560.0f)
        verticalLineToRelative(-560.0f)
        lineTo(200.0f, 200.0f)
        verticalLineToRelative(560.0f)
        close()
        moveTo(240.0f, 680.0f)
        horizontalLineToRelative(480.0f)
        lineTo(570.0f, 480.0f)
        lineTo(450.0f, 640.0f)
        lineToRelative(-90.0f, -120.0f)
        lineToRelative(-120.0f, 160.0f)
        close()
        moveTo(200.0f, 760.0f)
        verticalLineToRelative(-560.0f)
        verticalLineToRelative(560.0f)
        close()
        moveTo(340.0f, 400.0f)
        quadToRelative(25.0f, 0.0f, 42.5f, -17.5f)
        reflectiveQuadTo(400.0f, 340.0f)
        quadToRelative(0.0f, -25.0f, -17.5f, -42.5f)
        reflectiveQuadTo(340.0f, 280.0f)
        quadToRelative(-25.0f, 0.0f, -42.5f, 17.5f)
        reflectiveQuadTo(280.0f, 340.0f)
        quadToRelative(0.0f, 25.0f, 17.5f, 42.5f)
        reflectiveQuadTo(340.0f, 400.0f)
        close()
    }
}
    .build()

@DesignSystemPreview
@Composable
private fun ImagePreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Image,
            contentDescription = null,
        )
    }
}