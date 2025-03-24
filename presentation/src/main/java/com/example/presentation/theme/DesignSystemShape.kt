package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

object DesignSystemShapes{
    val BottomSheet = RoundedCornerShape(DesignSystemSpaces.Space4)
    val Button = RoundedCornerShape(DesignSystemSpaces.Space2)
    val Dialog = RoundedCornerShape(DesignSystemSpaces.Space2)
    val SnackBar = RoundedCornerShape(DesignSystemSpaces.Space2)
    val TextField = RoundedCornerShape(DesignSystemSpaces.Space4)
}

@Stable
class DesignSystemShape(
    val button: Shape,
    val bottomSheet: Shape,
    val dialog: Shape,
    val snackBar: Shape,
    val textField: Shape,
)

val LocalShape = staticCompositionLocalOf {
    DesignSystemShape(
        bottomSheet = RectangleShape,
        button = RectangleShape,
        dialog = RectangleShape,
        snackBar = RectangleShape,
        textField = RectangleShape
    )
}