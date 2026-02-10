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

val Menu = ImageVector.Builder(
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
        moveTo(120.0f, 720.0f)
        verticalLineToRelative(-80.0f)
        horizontalLineToRelative(720.0f)
        verticalLineToRelative(80.0f)
        lineTo(120.0f, 720.0f)
        close()
        moveTo(120.0f, 520.0f)
        verticalLineToRelative(-80.0f)
        horizontalLineToRelative(720.0f)
        verticalLineToRelative(80.0f)
        lineTo(120.0f, 520.0f)
        close()
        moveTo(120.0f, 320.0f)
        verticalLineToRelative(-80.0f)
        horizontalLineToRelative(720.0f)
        verticalLineToRelative(80.0f)
        lineTo(120.0f, 320.0f)
        close()
    }
}
    .build()


@DesignSystemPreview
@Composable
private fun MenuPreview() {
    DesignSystemTheme {
        Icon(
            imageVector = Menu,
            contentDescription = null,
        )
    }
}