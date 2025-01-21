package com.example.presentation.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object DesignSystemShape {
    val Rectangle = RoundedCornerShape(0.dp)
    val PrimaryButtonShape = RoundedCornerShape(DesignSystemSpace.Space2)
    val ActionButtonShape = RoundedCornerShape(DesignSystemSpace.Space4)
    val Circle = CircleShape
}