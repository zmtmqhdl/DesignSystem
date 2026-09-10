package com.example.core.designSystem.theme.scheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape

@Immutable
object ShapeToken {
    val bottomSheet = RoundedCornerShape(size = DimensionToken.dimension28)
    val box = RoundedCornerShape(size = DimensionToken.dimension8)
    val dialog = RoundedCornerShape(size = DimensionToken.dimension8)
    val snackBar = RoundedCornerShape(size = DimensionToken.dimension8)
    val textField = RoundedCornerShape(size = DimensionToken.dimension16)
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
    bottomSheet = ShapeToken.bottomSheet,
    box = ShapeToken.box,
    dialog = ShapeToken.dialog,
    snackBar = ShapeToken.snackBar,
    textField = ShapeToken.textField,
)