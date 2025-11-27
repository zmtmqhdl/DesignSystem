package com.example.core.designSystem.theme.scheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape

@Immutable
object ShapeToken{
    val BottomSheet = RoundedCornerShape(SpacingToken.Space7)
    val IconButton = RoundedCornerShape(SpacingToken.Space2)
    val Button = RoundedCornerShape(SpacingToken.Space4)
    val Dialog = RoundedCornerShape(SpacingToken.Space2)
    val SnackBar = RoundedCornerShape(SpacingToken.Space2)
    val TextField = RoundedCornerShape(SpacingToken.Space4)
    val Box = RoundedCornerShape(SpacingToken.Space2)
}

@Immutable
class ShapeScheme(
    val button: Shape,
    val iconButton: Shape,
    val bottomSheet: Shape,
    val dialog: Shape,
    val snackBar: Shape,
    val textField: Shape,
    val box: Shape,
)

val LocalShape: ProvidableCompositionLocal<ShapeScheme> = staticCompositionLocalOf {
    error("LocalShape not provided")
}