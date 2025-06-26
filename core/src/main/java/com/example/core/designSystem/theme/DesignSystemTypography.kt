package com.example.core.designSystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.R

@Immutable
data class DesignSystemTypographySet(
    val bold: TextStyle,
    val medium: TextStyle,
    val regular: TextStyle,
) {
    companion object {
        val Default = DesignSystemTypographySet(
            bold = TextStyle.Default,
            medium = TextStyle.Default,
            regular = TextStyle.Default,
        )
    }
}

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

object DesignSystemTextStyles {
    val XXXL = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Bold,
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize8,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val XXL = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize7,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val XL = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize6,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val L = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize5,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val M = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize4,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val S = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize3,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val XS = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize2,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )

    val XXS = DesignSystemTypographySet(
        bold = TextStyle(
            fontFamily = FontFamily(Font(R.font.bold)),
            fontSize = DesignSystemFontSize.FontSize1,
            fontWeight = DesignSystemFontWeight.Bold
        ),
        medium = TextStyle(
            fontFamily = FontFamily(Font(R.font.medium)),
            fontSize = DesignSystemFontSize.FontSize1,
            fontWeight = DesignSystemFontWeight.Medium
        ),
        regular = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular)),
            fontSize = DesignSystemFontSize.FontSize1,
            fontWeight = DesignSystemFontWeight.Regular
        )
    )
}

@Stable
class DesignSystemTypography(
    val xxxl: DesignSystemTypographySet,
    val xxl: DesignSystemTypographySet,
    val xl: DesignSystemTypographySet,
    val l: DesignSystemTypographySet,
    val m: DesignSystemTypographySet,
    val s: DesignSystemTypographySet,
    val xs: DesignSystemTypographySet,
    val xxs: DesignSystemTypographySet,
)

val LocalTypography = staticCompositionLocalOf {
    DesignSystemTypography(
        xxxl = DesignSystemTypographySet.Default,
        xxl = DesignSystemTypographySet.Default,
        xl = DesignSystemTypographySet.Default,
        l = DesignSystemTypographySet.Default,
        m = DesignSystemTypographySet.Default,
        s = DesignSystemTypographySet.Default,
        xs = DesignSystemTypographySet.Default,
        xxs = DesignSystemTypographySet.Default,
    )
}