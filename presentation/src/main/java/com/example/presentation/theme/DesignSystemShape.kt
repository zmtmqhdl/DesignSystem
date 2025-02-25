package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Immutable
data class DesignSystemShapeSet(
    val buttonShape: Shape,
    val dialogShape: Shape,
    val bottomSheet: Shape,
) {
    companion object {
        val Default = DesignSystemShapeSet(
            buttonShape = RectangleShape,
            dialogShape = RectangleShape,
            bottomSheet = RectangleShape
        )
    }
}

object DesignSystemShapes{
    val ButtonShape = RoundedCornerShape(DesignSystemDps.Dp2)
    val DialogShape = RoundedCornerShape(DesignSystemDps.Dp2)
    val BottomSheetShape = RoundedCornerShape(DesignSystemDps.Dp4)
//    val PrimaryIconBottomSheetShape = RoundedCornerShape(DesignSystemSpace.Space4)
}

@Stable
class DesignSystemShape(
    val buttonShape: DesignSystemShapeSet,
    val dialogShape: DesignSystemShapeSet,
    val bottomSheet: DesignSystemShapeSet
)

val LocalDesignSystem = staticCompositionLocalOf {
    DesignSystemShape(
        buttonShape = DesignSystemShapeSet.Default,
        dialogShape = DesignSystemShapeSet.Default,
        bottomSheet = DesignSystemShapeSet.Default
    )
}