package com.example.presentation.Icon

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val backIcon: ImageVector = ImageVector.Builder(
    name = "back",
    defaultWidth = 16.dp,
    defaultHeight = 16.dp,
    viewportWidth = 960f,
    viewportHeight = 960f
).apply {
    path(
        fill = SolidColor(Color.White),
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


@Preview(showBackground = true)
@Composable
fun BackIconPreview() {
    Icon(
        imageVector = backIcon,
        contentDescription = null,
    )
}