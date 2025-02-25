package com.example.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable

@Immutable
data class DesignSystemShapeSet(
    val
)

object DesignSystemShape {
    val PrimaryButtonShape = RoundedCornerShape(DesignSystemSpace.Space2)
    val PrimaryDialogShape = RoundedCornerShape(DesignSystemSpace.Space2)
    val PrimaryBottomSheepShape = RoundedCornerShape(DesignSystemSpace.Space4)
    val PrimaryIconBottomSheepShape = RoundedCornerShape(DesignSystemSpace.Space4)
}