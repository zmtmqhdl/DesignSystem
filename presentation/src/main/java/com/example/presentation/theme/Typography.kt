package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object FontSize {
    val XXXL = 24.sp
    val XXL = 22.sp
    val XL = 20.sp
    val L = 18.sp
    val M = 16.sp
    val S = 14.sp
    val XS = 12.sp
    val XXS = 11.sp
}

object FontWeight {
    val Bold = FontWeight(700)
    val Medium = FontWeight(500)
    val Regular = FontWeight(400)
}

object FontStyle {
    object XXXL {
        val Bold = TextStyle(
            fontSize = FontSize.XXXL,
            fontWeight = FontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = FontSize.XXXL,
            fontWeight = FontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = FontSize.XXXL,
            fontWeight = FontWeight.Regular
        )
    }
}

// Set of Material typography styles to start with
val Typographya = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)