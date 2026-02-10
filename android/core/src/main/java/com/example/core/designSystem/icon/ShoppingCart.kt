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

val ShoppingCart = ImageVector.Builder(
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
        moveTo(280.0f, 880.0f)
        quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
        reflectiveQuadTo(200.0f, 800.0f)
        quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
        reflectiveQuadTo(280.0f, 720.0f)
        quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
        reflectiveQuadTo(360.0f, 800.0f)
        quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
        reflectiveQuadTo(280.0f, 880.0f)
        close()
        moveTo(680.0f, 880.0f)
        quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
        reflectiveQuadTo(600.0f, 800.0f)
        quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
        reflectiveQuadTo(680.0f, 720.0f)
        quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
        reflectiveQuadTo(760.0f, 800.0f)
        quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
        reflectiveQuadTo(680.0f, 880.0f)
        close()
        moveTo(246.0f, 240.0f)
        lineToRelative(96.0f, 200.0f)
        horizontalLineToRelative(280.0f)
        lineToRelative(110.0f, -200.0f)
        lineTo(246.0f, 240.0f)
        close()
        moveTo(208.0f, 160.0f)
        horizontalLineToRelative(590.0f)
        quadToRelative(23.0f, 0.0f, 35.0f, 20.5f)
        reflectiveQuadToRelative(1.0f, 41.5f)
        lineTo(692.0f, 478.0f)
        quadToRelative(-11.0f, 20.0f, -29.5f, 31.0f)
        reflectiveQuadTo(622.0f, 520.0f)
        lineTo(324.0f, 520.0f)
        lineToRelative(-44.0f, 80.0f)
        horizontalLineToRelative(480.0f)
        verticalLineToRelative(80.0f)
        lineTo(280.0f, 680.0f)
        quadToRelative(-45.0f, 0.0f, -68.0f, -39.5f)
        reflectiveQuadToRelative(-2.0f, -78.5f)
        lineToRelative(54.0f, -98.0f)
        lineToRelative(-144.0f, -304.0f)
        lineTo(40.0f, 160.0f)
        verticalLineToRelative(-80.0f)
        horizontalLineToRelative(130.0f)
        lineToRelative(38.0f, 80.0f)
        close()
        moveTo(342.0f, 440.0f)
        horizontalLineToRelative(280.0f)
        horizontalLineToRelative(-280.0f)
        close()
    }
}
    .build()

@DesignSystemPreview
@Composable
private fun ShoppingCartPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = ShoppingCart,
            contentDescription = null,
        )
    }
}