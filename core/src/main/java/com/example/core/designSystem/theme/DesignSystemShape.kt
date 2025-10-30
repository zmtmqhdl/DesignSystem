package com.example.core.designSystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Stable
object DesignSystemShapes{
    val BottomSheet = RoundedCornerShape(DesignSystemSpaces.Space7)
    val IconButton = RoundedCornerShape(DesignSystemSpaces.Space2)
    val Button = RoundedCornerShape(DesignSystemSpaces.Space4)
    val Dialog = RoundedCornerShape(DesignSystemSpaces.Space2)
    val SnackBar = RoundedCornerShape(DesignSystemSpaces.Space2)
    val TextField = RoundedCornerShape(DesignSystemSpaces.Space4)
    val Box = RoundedCornerShape(DesignSystemSpaces.Space2)
}

@Stable
class DesignSystemShape(
    val button: Shape,
    val iconButton: Shape,
    val bottomSheet: Shape,
    val dialog: Shape,
    val snackBar: Shape,
    val textField: Shape,
    val box: Shape
)

val LocalShape: ProvidableCompositionLocal<DesignSystemShape> = staticCompositionLocalOf {
    error("LocalShape not provided")
}