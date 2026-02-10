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

val Wifi = ImageVector.Builder(
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
        moveTo(480.0f, 840.0f)
        quadToRelative(-42.0f, 0.0f, -71.0f, -29.0f)
        reflectiveQuadToRelative(-29.0f, -71.0f)
        quadToRelative(0.0f, -42.0f, 29.0f, -71.0f)
        reflectiveQuadToRelative(71.0f, -29.0f)
        quadToRelative(42.0f, 0.0f, 71.0f, 29.0f)
        reflectiveQuadToRelative(29.0f, 71.0f)
        quadToRelative(0.0f, 42.0f, -29.0f, 71.0f)
        reflectiveQuadToRelative(-71.0f, 29.0f)
        close()
        moveTo(254.0f, 614.0f)
        lineToRelative(-84.0f, -86.0f)
        quadToRelative(59.0f, -59.0f, 138.5f, -93.5f)
        reflectiveQuadTo(480.0f, 400.0f)
        quadToRelative(92.0f, 0.0f, 171.5f, 35.0f)
        reflectiveQuadTo(790.0f, 530.0f)
        lineToRelative(-84.0f, 84.0f)
        quadToRelative(-44.0f, -44.0f, -102.0f, -69.0f)
        reflectiveQuadToRelative(-124.0f, -25.0f)
        quadToRelative(-66.0f, 0.0f, -124.0f, 25.0f)
        reflectiveQuadToRelative(-102.0f, 69.0f)
        close()
        moveTo(84.0f, 444.0f)
        lineTo(0.0f, 360.0f)
        quadToRelative(92.0f, -94.0f, 215.0f, -147.0f)
        reflectiveQuadToRelative(265.0f, -53.0f)
        quadToRelative(142.0f, 0.0f, 265.0f, 53.0f)
        reflectiveQuadToRelative(215.0f, 147.0f)
        lineToRelative(-84.0f, 84.0f)
        quadToRelative(-77.0f, -77.0f, -178.5f, -120.5f)
        reflectiveQuadTo(480.0f, 280.0f)
        quadToRelative(-116.0f, 0.0f, -217.5f, 43.5f)
        reflectiveQuadTo(84.0f, 444.0f)
        close()
    }
}.build()

@DesignSystemPreview
@Composable
private fun WifiPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Wifi,
            contentDescription = null,
        )
    }
}