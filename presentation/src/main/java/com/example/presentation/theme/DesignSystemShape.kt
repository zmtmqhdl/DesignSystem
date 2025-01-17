package com.example.presentation.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

object DesignSystemShape {
    val Rectangle = RoundedCornerShape(0.dp)
    val RoundedRectangle = RoundedCornerShape(DesignSystemSpace.M)
    val Circle = CircleShape
}