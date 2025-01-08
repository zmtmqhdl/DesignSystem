package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object DesignSystemFontSize {
    val XXXL = 24.sp
    val XXL = 22.sp
    val XL = 20.sp
    val L = 18.sp
    val M = 16.sp
    val S = 14.sp
    val XS = 12.sp
    val XXS = 11.sp
}

object DesignSystemFontWeight {
    val Bold = FontWeight(700)
    val Medium = FontWeight(500)
    val Regular = FontWeight(400)
}

object DesignSystemFontStyle {
    object XXXL {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.XXXL,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.XXXL,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.XXXL,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XXL {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.XXL,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.XXL,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.XXL,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XL {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.XL,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.XL,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.XL,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object L {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.L,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.L,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.L,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object M {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.M,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.M,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.M,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object S {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.S,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.S,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.S,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XS {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.XS,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.XS,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.XS,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XXS {
        val Bold = TextStyle(
            fontSize = DesignSystemFontSize.XXS,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontSize = DesignSystemFontSize.XXS,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontSize = DesignSystemFontSize.XXS,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
}




val Typography = Typography(
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