package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.presentation.R

object DesignSystemFontSize {
    val FontSize1 = 11.sp
    val FontSize2 = 12.sp
    val FontSize3 = 14.sp
    val FontSize4 = 16.sp
    val FontSize5 = 18.sp
    val FontSize6 = 20.sp
    val FontSize7 = 22.sp
    val FontSize8 = 24.sp
}

object DesignSystemFontWeight {
    val Bold = FontWeight(700)
    val Medium = FontWeight(500)
    val Regular = FontWeight(400)
}

object DesignSystemFontStyle {
    object XXXL {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Bold,
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XXL {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XL {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object L {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object M {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object S {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XS {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Regular
        )
    }
    object XXS {
        val Bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize1,
            fontWeight = DesignSystemFontWeight.Bold
        )
        val Medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize1,
            fontWeight = DesignSystemFontWeight.Medium
        )
        val Regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize1,
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