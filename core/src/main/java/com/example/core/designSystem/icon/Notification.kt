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

val Notification = ImageVector.Builder(
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
        moveTo(160.0f, 760.0f)
        verticalLineToRelative(-80.0f)
        horizontalLineToRelative(80.0f)
        verticalLineToRelative(-280.0f)
        quadToRelative(0.0f, -83.0f, 50.0f, -147.5f)
        reflectiveQuadTo(420.0f, 168.0f)
        verticalLineToRelative(-28.0f)
        quadToRelative(0.0f, -25.0f, 17.5f, -42.5f)
        reflectiveQuadTo(480.0f, 80.0f)
        quadToRelative(25.0f, 0.0f, 42.5f, 17.5f)
        reflectiveQuadTo(540.0f, 140.0f)
        verticalLineToRelative(28.0f)
        quadToRelative(80.0f, 20.0f, 130.0f, 84.5f)
        reflectiveQuadTo(720.0f, 400.0f)
        verticalLineToRelative(280.0f)
        horizontalLineToRelative(80.0f)
        verticalLineToRelative(80.0f)
        lineTo(160.0f, 760.0f)
        close()
        moveTo(480.0f, 460.0f)
        close()
        moveTo(480.0f, 880.0f)
        quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
        reflectiveQuadTo(400.0f, 800.0f)
        horizontalLineToRelative(160.0f)
        quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
        reflectiveQuadTo(480.0f, 880.0f)
        close()
        moveTo(320.0f, 680.0f)
        horizontalLineToRelative(320.0f)
        verticalLineToRelative(-280.0f)
        quadToRelative(0.0f, -66.0f, -47.0f, -113.0f)
        reflectiveQuadToRelative(-113.0f, -47.0f)
        quadToRelative(-66.0f, 0.0f, -113.0f, 47.0f)
        reflectiveQuadToRelative(-47.0f, 113.0f)
        verticalLineToRelative(280.0f)
        close()
    }
}
    .build()

@DesignSystemPreview
@Composable
private fun NotificationPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Notification,
            contentDescription = null,
        )
    }
}