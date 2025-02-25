package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

object DesignSystemShapes{
    val ButtonShape = RoundedCornerShape(DesignSystemDps.Dp2)
    val DialogShape = RoundedCornerShape(DesignSystemDps.Dp2)
    val BottomSheetShape = RoundedCornerShape(DesignSystemDps.Dp4)
//    val PrimaryIconBottomSheetShape = RoundedCornerShape(DesignSystemSpace.Space4)
}

@Stable
class DesignSystemShape(
    val buttonShape: Shape,
    val dialogShape: Shape,
    val bottomSheet: Shape
)

val LocalDesignSystem = staticCompositionLocalOf {
    DesignSystemShape(
        buttonShape = RectangleShape,
        dialogShape = RectangleShape,
        bottomSheet = RectangleShape
    )
}