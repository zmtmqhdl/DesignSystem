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

val Location = ImageVector.Builder(
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
        moveTo(480.0f, 480.0f)
        quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
        reflectiveQuadTo(560.0f, 400.0f)
        quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
        reflectiveQuadTo(480.0f, 320.0f)
        quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
        reflectiveQuadTo(400.0f, 400.0f)
        quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
        reflectiveQuadTo(480.0f, 480.0f)
        close()
        moveTo(480.0f, 774.0f)
        quadToRelative(122.0f, -112.0f, 181.0f, -203.5f)
        reflectiveQuadTo(720.0f, 408.0f)
        quadToRelative(0.0f, -109.0f, -69.5f, -178.5f)
        reflectiveQuadTo(480.0f, 160.0f)
        quadToRelative(-101.0f, 0.0f, -170.5f, 69.5f)
        reflectiveQuadTo(240.0f, 408.0f)
        quadToRelative(0.0f, 71.0f, 59.0f, 162.5f)
        reflectiveQuadTo(480.0f, 774.0f)
        close()
        moveTo(480.0f, 880.0f)
        quadTo(319.0f, 743.0f, 239.5f, 625.5f)
        reflectiveQuadTo(160.0f, 408.0f)
        quadToRelative(0.0f, -150.0f, 96.5f, -239.0f)
        reflectiveQuadTo(480.0f, 80.0f)
        quadToRelative(127.0f, 0.0f, 223.5f, 89.0f)
        reflectiveQuadTo(800.0f, 408.0f)
        quadToRelative(0.0f, 100.0f, -79.5f, 217.5f)
        reflectiveQuadTo(480.0f, 880.0f)
        close()
        moveTo(480.0f, 400.0f)
        close()
    }
}
    .build()

@DesignSystemPreview
@Composable
private fun LocationPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Location,
            contentDescription = null,
        )
    }
}