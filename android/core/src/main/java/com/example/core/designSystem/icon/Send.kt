package com.example.core.designSystem.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.component.DSIcon
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

val Send = ImageVector.Builder(
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
        moveTo(120.0f, 800.0f)
        verticalLineToRelative(-640.0f)
        lineToRelative(760.0f, 320.0f)
        lineToRelative(-760.0f, 320.0f)
        close()
        moveTo(200.0f, 680.0f)
        lineTo(674.0f, 480.0f)
        lineTo(200.0f, 280.0f)
        verticalLineToRelative(140.0f)
        lineToRelative(240.0f, 60.0f)
        lineToRelative(-240.0f, 60.0f)
        verticalLineToRelative(140.0f)
        close()
        moveTo(200.0f, 680.0f)
        verticalLineToRelative(-400.0f)
        verticalLineToRelative(400.0f)
        close()
    }
}
    .build()

@DSPreview
@Composable
private fun SendPreview() {
    DSTheme {
        DSIcon(
            icon = Send,
            ariaLabel = "Send",
        )
    }
}