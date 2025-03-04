package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

object DesignSystemShapes{
    val Button = RoundedCornerShape(DesignSystemSpaces.Space2)
    val Dialog = RoundedCornerShape(DesignSystemSpaces.Space2)
    val BottomSheet = RoundedCornerShape(DesignSystemSpaces.Space4)
    val TextField = RoundedCornerShape(DesignSystemSpaces.Space4)
}

@Stable
class DesignSystemShape(
    val button: Shape,
    val dialog: Shape,
    val bottomSheet: Shape,
    val textField: Shape,
)

val LocalShape = staticCompositionLocalOf {
    DesignSystemShape(
        button = RectangleShape,
        dialog = RectangleShape,
        bottomSheet = RectangleShape,
        textField = RectangleShape
    )
}