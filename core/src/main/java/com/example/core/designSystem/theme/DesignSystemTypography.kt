package com.example.core.designSystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.core.R

/**
 * Light랑 SemiBold 추가 필요
 *
 * 기본 : Typography6Regular
 *
 */
@Immutable
data class FontStyleSet(
    val light: TextStyle,
    val regular: TextStyle,
    val medium: TextStyle,
    val semiBold: TextStyle,
    val bold: TextStyle
)

object DesignSystemFontSize {
    val Typography1 = 30.sp
    val SubTypography1 = 29.sp
    val SubTypography2 = 28.sp
    val SubTypography3 = 27.sp
    val Typography2 = 26.sp
    val SubTypography4 = 25.sp
    val SubTypography5 = 24.sp
    val SubTypography6 = 23.sp
    val Typography3 = 22.sp
    val SubTypography7 = 21.sp
    val Typography4 = 20.sp
    val SubTypography8 = 19.sp
    val SubTypography9 = 18.sp
    val Typography5 = 17.sp
    val SubTypography10 = 16.sp
    val Typography6 = 15.sp
    val SubTypography11 = 14.sp
    val Typography7 = 13.sp
    val SubTypography12 = 12.sp
    val SubTypography13 = 11.sp
}

object DesignSystemLineHeight {
    val Typography1 = 40.sp
    val SubTypography1 = 38.sp
    val SubTypography2 = 37.sp
    val SubTypography3 = 36.sp
    val Typography2 = 35.sp
    val SubTypography4 = 34.sp
    val SubTypography5 = 33.sp
    val SubTypography6 = 32.sp
    val Typography3 = 31.sp
    val SubTypography7 = 30.sp
    val Typography4 = 29.sp
    val SubTypography8 = 28.sp
    val SubTypography9 = 27.sp
    val Typography5 = 25.5.sp
    val SubTypography10 = 24.sp
    val Typography6 = 22.5.sp
    val SubTypography11 = 21.sp
    val Typography7 = 19.5.sp
    val SubTypography12 = 18.sp
    val SubTypography13 = 16.5.sp
}

object DesignSystemMaxFontSize {
    val Typography1 = 42.sp
    val SubTypography1 = 42.sp
    val SubTypography2 = 41.sp
    val SubTypography3 = 41.sp
    val Typography2 = 41.sp
    val SubTypography4 = 41.sp
    val SubTypography5 = 40.sp
    val SubTypography6 = 40.sp
    val Typography3 = 40.sp
    val SubTypography7 = 40.sp
    val Typography4 = 40.sp
    val SubTypography8 = 40.sp
    val SubTypography9 = 39.sp
    val Typography5 = 39.sp
    val SubTypography10 = 39.sp
    val Typography6 = 37.sp
    val SubTypography11 = 36.sp
    val Typography7 = 34.sp
    val SubTypography12 = 32.sp
    val SubTypography13 = 31.sp
}

object DesignSystemFontWeight {
    val Light = FontWeight(weight = 1)
    val Regular = FontWeight(weight = 400)
    val Medium = FontWeight(weight = 500)
    val SemiBold = FontWeight(weight = 600)
    val Bold = FontWeight(weight = 700)
}

private fun textStyle(
    fontSize: TextUnit,
    maxFontSize: TextUnit,
    lineHeight: TextUnit,
    weight: FontWeight,
    fontRes: Int,
    fontScale: Float
): TextStyle {
    val scaledSize = (fontSize * fontScale).value

    return TextStyle(
        fontFamily = FontFamily(Font(resId = fontRes)),
        fontSize = scaledSize.coerceAtMost(
            maximumValue = maxFontSize.value
        ).sp,
        fontWeight = weight,
        lineHeight = lineHeight
    )
}

@Immutable
data class DesignSystemTypography(
    val typography1: FontStyleSet,
    val subTypography1: FontStyleSet,
    val subTypography2: FontStyleSet,
    val subTypography3: FontStyleSet,
    val typography2: FontStyleSet,
    val subTypography4: FontStyleSet,
    val subTypography5: FontStyleSet,
    val subTypography6: FontStyleSet,
    val typography3: FontStyleSet,
    val subTypography7: FontStyleSet,
    val typography4: FontStyleSet,
    val subTypography8: FontStyleSet,
    val subTypography9: FontStyleSet,
    val typography5: FontStyleSet,
    val subTypography10: FontStyleSet,
    val typography6: FontStyleSet,
    val subTypography11: FontStyleSet,
    val typography7: FontStyleSet,
    val subTypography12: FontStyleSet,
    val subTypography13: FontStyleSet
)

@Composable
fun typography(): DesignSystemTypography {
    val fontScale = LocalDensity.current.fontScale

    return remember(key1 = fontScale) {
        DesignSystemTypography(
            typography1 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography1,
                    maxFontSize = DesignSystemMaxFontSize.Typography1,
                    lineHeight = DesignSystemLineHeight.Typography1,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography1,
                    maxFontSize = DesignSystemMaxFontSize.Typography1,
                    lineHeight = DesignSystemLineHeight.Typography1,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography1,
                    maxFontSize = DesignSystemMaxFontSize.Typography1,
                    lineHeight = DesignSystemLineHeight.Typography1,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography1,
                    maxFontSize = DesignSystemMaxFontSize.Typography1,
                    lineHeight = DesignSystemLineHeight.Typography1,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography1,
                    maxFontSize = DesignSystemMaxFontSize.Typography1,
                    lineHeight = DesignSystemLineHeight.Typography1,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography1 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography1,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                    lineHeight = DesignSystemLineHeight.SubTypography1,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography1,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                    lineHeight = DesignSystemLineHeight.SubTypography1,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography1,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                    lineHeight = DesignSystemLineHeight.SubTypography1,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography1,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                    lineHeight = DesignSystemLineHeight.SubTypography1,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography1,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                    lineHeight = DesignSystemLineHeight.SubTypography1,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography2,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                    lineHeight = DesignSystemLineHeight.SubTypography2,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography2,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                    lineHeight = DesignSystemLineHeight.SubTypography2,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography2,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                    lineHeight = DesignSystemLineHeight.SubTypography2,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography2,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                    lineHeight = DesignSystemLineHeight.SubTypography2,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography2,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                    lineHeight = DesignSystemLineHeight.SubTypography2,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography3,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                    lineHeight = DesignSystemLineHeight.SubTypography3,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography3,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                    lineHeight = DesignSystemLineHeight.SubTypography3,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography3,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                    lineHeight = DesignSystemLineHeight.SubTypography3,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography3,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                    lineHeight = DesignSystemLineHeight.SubTypography3,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography3,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                    lineHeight = DesignSystemLineHeight.SubTypography3,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography2,
                    maxFontSize = DesignSystemMaxFontSize.Typography2,
                    lineHeight = DesignSystemLineHeight.Typography2,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography2,
                    maxFontSize = DesignSystemMaxFontSize.Typography2,
                    lineHeight = DesignSystemLineHeight.Typography2,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography2,
                    maxFontSize = DesignSystemMaxFontSize.Typography2,
                    lineHeight = DesignSystemLineHeight.Typography2,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography2,
                    maxFontSize = DesignSystemMaxFontSize.Typography2,
                    lineHeight = DesignSystemLineHeight.Typography2,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography2,
                    maxFontSize = DesignSystemMaxFontSize.Typography2,
                    lineHeight = DesignSystemLineHeight.Typography2,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography4,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                    lineHeight = DesignSystemLineHeight.SubTypography4,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography4,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                    lineHeight = DesignSystemLineHeight.SubTypography4,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography4,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                    lineHeight = DesignSystemLineHeight.SubTypography4,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography4,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                    lineHeight = DesignSystemLineHeight.SubTypography4,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography4,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                    lineHeight = DesignSystemLineHeight.SubTypography4,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography5,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                    lineHeight = DesignSystemLineHeight.SubTypography5,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography5,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                    lineHeight = DesignSystemLineHeight.SubTypography5,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography5,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                    lineHeight = DesignSystemLineHeight.SubTypography5,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography5,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                    lineHeight = DesignSystemLineHeight.SubTypography5,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography5,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                    lineHeight = DesignSystemLineHeight.SubTypography5,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography6,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                    lineHeight = DesignSystemLineHeight.SubTypography6,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography6,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                    lineHeight = DesignSystemLineHeight.SubTypography6,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography6,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                    lineHeight = DesignSystemLineHeight.SubTypography6,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography6,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                    lineHeight = DesignSystemLineHeight.SubTypography6,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography6,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                    lineHeight = DesignSystemLineHeight.SubTypography6,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography3,
                    maxFontSize = DesignSystemMaxFontSize.Typography3,
                    lineHeight = DesignSystemLineHeight.Typography3,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography3,
                    maxFontSize = DesignSystemMaxFontSize.Typography3,
                    lineHeight = DesignSystemLineHeight.Typography3,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography3,
                    maxFontSize = DesignSystemMaxFontSize.Typography3,
                    lineHeight = DesignSystemLineHeight.Typography3,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography3,
                    maxFontSize = DesignSystemMaxFontSize.Typography3,
                    lineHeight = DesignSystemLineHeight.Typography3,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography3,
                    maxFontSize = DesignSystemMaxFontSize.Typography3,
                    lineHeight = DesignSystemLineHeight.Typography3,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography7,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                    lineHeight = DesignSystemLineHeight.SubTypography7,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography7,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                    lineHeight = DesignSystemLineHeight.SubTypography7,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography7,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                    lineHeight = DesignSystemLineHeight.SubTypography7,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography7,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                    lineHeight = DesignSystemLineHeight.SubTypography7,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography7,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                    lineHeight = DesignSystemLineHeight.SubTypography7,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography4,
                    maxFontSize = DesignSystemMaxFontSize.Typography4,
                    lineHeight = DesignSystemLineHeight.Typography4,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography4,
                    maxFontSize = DesignSystemMaxFontSize.Typography4,
                    lineHeight = DesignSystemLineHeight.Typography4,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography4,
                    maxFontSize = DesignSystemMaxFontSize.Typography4,
                    lineHeight = DesignSystemLineHeight.Typography4,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography4,
                    maxFontSize = DesignSystemMaxFontSize.Typography4,
                    lineHeight = DesignSystemLineHeight.Typography4,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography4,
                    maxFontSize = DesignSystemMaxFontSize.Typography4,
                    lineHeight = DesignSystemLineHeight.Typography4,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography8 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography8,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                    lineHeight = DesignSystemLineHeight.SubTypography8,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography8,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                    lineHeight = DesignSystemLineHeight.SubTypography8,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography8,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                    lineHeight = DesignSystemLineHeight.SubTypography8,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography8,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                    lineHeight = DesignSystemLineHeight.SubTypography8,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography8,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                    lineHeight = DesignSystemLineHeight.SubTypography8,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography9 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography9,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                    lineHeight = DesignSystemLineHeight.SubTypography9,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography9,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                    lineHeight = DesignSystemLineHeight.SubTypography9,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography9,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                    lineHeight = DesignSystemLineHeight.SubTypography9,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography9,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                    lineHeight = DesignSystemLineHeight.SubTypography9,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography9,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                    lineHeight = DesignSystemLineHeight.SubTypography9,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography5,
                    maxFontSize = DesignSystemMaxFontSize.Typography5,
                    lineHeight = DesignSystemLineHeight.Typography5,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography5,
                    maxFontSize = DesignSystemMaxFontSize.Typography5,
                    lineHeight = DesignSystemLineHeight.Typography5,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography5,
                    maxFontSize = DesignSystemMaxFontSize.Typography5,
                    lineHeight = DesignSystemLineHeight.Typography5,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography5,
                    maxFontSize = DesignSystemMaxFontSize.Typography5,
                    lineHeight = DesignSystemLineHeight.Typography5,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography5,
                    maxFontSize = DesignSystemMaxFontSize.Typography5,
                    lineHeight = DesignSystemLineHeight.Typography5,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography10 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography10,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                    lineHeight = DesignSystemLineHeight.SubTypography10,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography10,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                    lineHeight = DesignSystemLineHeight.SubTypography10,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography10,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                    lineHeight = DesignSystemLineHeight.SubTypography10,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography10,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                    lineHeight = DesignSystemLineHeight.SubTypography10,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography10,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                    lineHeight = DesignSystemLineHeight.SubTypography10,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography6,
                    maxFontSize = DesignSystemMaxFontSize.Typography6,
                    lineHeight = DesignSystemLineHeight.Typography6,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography6,
                    maxFontSize = DesignSystemMaxFontSize.Typography6,
                    lineHeight = DesignSystemLineHeight.Typography6,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography6,
                    maxFontSize = DesignSystemMaxFontSize.Typography6,
                    lineHeight = DesignSystemLineHeight.Typography6,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography6,
                    maxFontSize = DesignSystemMaxFontSize.Typography6,
                    lineHeight = DesignSystemLineHeight.Typography6,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography6,
                    maxFontSize = DesignSystemMaxFontSize.Typography6,
                    lineHeight = DesignSystemLineHeight.Typography6,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography11 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography11,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                    lineHeight = DesignSystemLineHeight.SubTypography11,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography11,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                    lineHeight = DesignSystemLineHeight.SubTypography11,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography11,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                    lineHeight = DesignSystemLineHeight.SubTypography11,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography11,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                    lineHeight = DesignSystemLineHeight.SubTypography11,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography11,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                    lineHeight = DesignSystemLineHeight.SubTypography11,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.Typography7,
                    maxFontSize = DesignSystemMaxFontSize.Typography7,
                    lineHeight = DesignSystemLineHeight.Typography7,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.Typography7,
                    maxFontSize = DesignSystemMaxFontSize.Typography7,
                    lineHeight = DesignSystemLineHeight.Typography7,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.Typography7,
                    maxFontSize = DesignSystemMaxFontSize.Typography7,
                    lineHeight = DesignSystemLineHeight.Typography7,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.Typography7,
                    maxFontSize = DesignSystemMaxFontSize.Typography7,
                    lineHeight = DesignSystemLineHeight.Typography7,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.Typography7,
                    maxFontSize = DesignSystemMaxFontSize.Typography7,
                    lineHeight = DesignSystemLineHeight.Typography7,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography12 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography12,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                    lineHeight = DesignSystemLineHeight.SubTypography12,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography12,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                    lineHeight = DesignSystemLineHeight.SubTypography12,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography12,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                    lineHeight = DesignSystemLineHeight.SubTypography12,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography12,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                    lineHeight = DesignSystemLineHeight.SubTypography12,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography12,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                    lineHeight = DesignSystemLineHeight.SubTypography12,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography13 = FontStyleSet(
                light = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography13,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                    lineHeight = DesignSystemLineHeight.SubTypography13,
                    weight = DesignSystemFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography13,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                    lineHeight = DesignSystemLineHeight.SubTypography13,
                    weight = DesignSystemFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography13,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                    lineHeight = DesignSystemLineHeight.SubTypography13,
                    weight = DesignSystemFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography13,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                    lineHeight = DesignSystemLineHeight.SubTypography13,
                    weight = DesignSystemFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DesignSystemFontSize.SubTypography13,
                    maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                    lineHeight = DesignSystemLineHeight.SubTypography13,
                    weight = DesignSystemFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            )
        )
    }
}

val LocalTypography: ProvidableCompositionLocal<DesignSystemTypography> = staticCompositionLocalOf {
    error("LocalTypography not provided")
}