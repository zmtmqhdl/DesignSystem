package com.example.core.designSystem.theme.scheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape

@Immutable
object ShapeToken {
    val BottomSheet = RoundedCornerShape(size = DimensionToken.Dimension7)
    val Box = RoundedCornerShape(size = DimensionToken.Dimension2)
    val Dialog = RoundedCornerShape(size = DimensionToken.Dimension2)
    val SnackBar = RoundedCornerShape(size = DimensionToken.Dimension2)
    val TextField = RoundedCornerShape(size = DimensionToken.Dimension4)
}

@Immutable
class ShapeScheme(
    val bottomSheet: Shape,
    val box: Shape,
    val dialog: Shape,
    val snackBar: Shape,
    val textField: Shape,
)

val LocalShapes: ProvidableCompositionLocal<ShapeScheme> = staticCompositionLocalOf {
    error("LocalShape not provided")
}

val shapeScheme = ShapeScheme(
    bottomSheet = ShapeToken.BottomSheet,
    box = ShapeToken.Box,
    dialog = ShapeToken.Dialog,
    snackBar = ShapeToken.SnackBar,
    textField = ShapeToken.TextField,
)