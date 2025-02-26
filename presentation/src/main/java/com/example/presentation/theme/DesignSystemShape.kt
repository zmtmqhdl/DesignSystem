package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

object DesignSystemShapes{
    val ButtonShape = RoundedCornerShape(DesignSystemSpaces.Space2)
    val DialogShape = RoundedCornerShape(DesignSystemSpaces.Space2)
    val BottomSheetShape = RoundedCornerShape(DesignSystemSpaces.Space4)
}

@Stable
class DesignSystemShape(
    val buttonShape: Shape,
    val dialogShape: Shape,
    val bottomSheet: Shape
)

val LocalShape = staticCompositionLocalOf {
    DesignSystemShape(
        buttonShape = RectangleShape,
        dialogShape = RectangleShape,
        bottomSheet = RectangleShape
    )
}