package com.example.core.designSystem.theme.scheme

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

@Immutable
object DSFontSize {
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

@Immutable
object DSLineHeight {
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

@Immutable
object DSMaxFontSize {
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

@Immutable
object DSFontWeight {
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
data class TypographyScheme(
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
fun typography(): TypographyScheme {
    val fontScale = LocalDensity.current.fontScale

    return remember(key1 = fontScale) {
        TypographyScheme(
            typography1 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography1,
                    maxFontSize = DSMaxFontSize.Typography1,
                    lineHeight = DSLineHeight.Typography1,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography1,
                    maxFontSize = DSMaxFontSize.Typography1,
                    lineHeight = DSLineHeight.Typography1,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography1,
                    maxFontSize = DSMaxFontSize.Typography1,
                    lineHeight = DSLineHeight.Typography1,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography1,
                    maxFontSize = DSMaxFontSize.Typography1,
                    lineHeight = DSLineHeight.Typography1,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography1,
                    maxFontSize = DSMaxFontSize.Typography1,
                    lineHeight = DSLineHeight.Typography1,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography1 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography1,
                    maxFontSize = DSMaxFontSize.SubTypography1,
                    lineHeight = DSLineHeight.SubTypography1,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography1,
                    maxFontSize = DSMaxFontSize.SubTypography1,
                    lineHeight = DSLineHeight.SubTypography1,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography1,
                    maxFontSize = DSMaxFontSize.SubTypography1,
                    lineHeight = DSLineHeight.SubTypography1,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography1,
                    maxFontSize = DSMaxFontSize.SubTypography1,
                    lineHeight = DSLineHeight.SubTypography1,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography1,
                    maxFontSize = DSMaxFontSize.SubTypography1,
                    lineHeight = DSLineHeight.SubTypography1,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography2,
                    maxFontSize = DSMaxFontSize.SubTypography2,
                    lineHeight = DSLineHeight.SubTypography2,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography2,
                    maxFontSize = DSMaxFontSize.SubTypography2,
                    lineHeight = DSLineHeight.SubTypography2,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography2,
                    maxFontSize = DSMaxFontSize.SubTypography2,
                    lineHeight = DSLineHeight.SubTypography2,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography2,
                    maxFontSize = DSMaxFontSize.SubTypography2,
                    lineHeight = DSLineHeight.SubTypography2,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography2,
                    maxFontSize = DSMaxFontSize.SubTypography2,
                    lineHeight = DSLineHeight.SubTypography2,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography3,
                    maxFontSize = DSMaxFontSize.SubTypography3,
                    lineHeight = DSLineHeight.SubTypography3,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography3,
                    maxFontSize = DSMaxFontSize.SubTypography3,
                    lineHeight = DSLineHeight.SubTypography3,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography3,
                    maxFontSize = DSMaxFontSize.SubTypography3,
                    lineHeight = DSLineHeight.SubTypography3,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography3,
                    maxFontSize = DSMaxFontSize.SubTypography3,
                    lineHeight = DSLineHeight.SubTypography3,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography3,
                    maxFontSize = DSMaxFontSize.SubTypography3,
                    lineHeight = DSLineHeight.SubTypography3,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography2,
                    maxFontSize = DSMaxFontSize.Typography2,
                    lineHeight = DSLineHeight.Typography2,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography2,
                    maxFontSize = DSMaxFontSize.Typography2,
                    lineHeight = DSLineHeight.Typography2,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography2,
                    maxFontSize = DSMaxFontSize.Typography2,
                    lineHeight = DSLineHeight.Typography2,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography2,
                    maxFontSize = DSMaxFontSize.Typography2,
                    lineHeight = DSLineHeight.Typography2,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography2,
                    maxFontSize = DSMaxFontSize.Typography2,
                    lineHeight = DSLineHeight.Typography2,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography4,
                    maxFontSize = DSMaxFontSize.SubTypography4,
                    lineHeight = DSLineHeight.SubTypography4,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography4,
                    maxFontSize = DSMaxFontSize.SubTypography4,
                    lineHeight = DSLineHeight.SubTypography4,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography4,
                    maxFontSize = DSMaxFontSize.SubTypography4,
                    lineHeight = DSLineHeight.SubTypography4,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography4,
                    maxFontSize = DSMaxFontSize.SubTypography4,
                    lineHeight = DSLineHeight.SubTypography4,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography4,
                    maxFontSize = DSMaxFontSize.SubTypography4,
                    lineHeight = DSLineHeight.SubTypography4,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography5,
                    maxFontSize = DSMaxFontSize.SubTypography5,
                    lineHeight = DSLineHeight.SubTypography5,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography5,
                    maxFontSize = DSMaxFontSize.SubTypography5,
                    lineHeight = DSLineHeight.SubTypography5,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography5,
                    maxFontSize = DSMaxFontSize.SubTypography5,
                    lineHeight = DSLineHeight.SubTypography5,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography5,
                    maxFontSize = DSMaxFontSize.SubTypography5,
                    lineHeight = DSLineHeight.SubTypography5,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography5,
                    maxFontSize = DSMaxFontSize.SubTypography5,
                    lineHeight = DSLineHeight.SubTypography5,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography6,
                    maxFontSize = DSMaxFontSize.SubTypography6,
                    lineHeight = DSLineHeight.SubTypography6,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography6,
                    maxFontSize = DSMaxFontSize.SubTypography6,
                    lineHeight = DSLineHeight.SubTypography6,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography6,
                    maxFontSize = DSMaxFontSize.SubTypography6,
                    lineHeight = DSLineHeight.SubTypography6,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography6,
                    maxFontSize = DSMaxFontSize.SubTypography6,
                    lineHeight = DSLineHeight.SubTypography6,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography6,
                    maxFontSize = DSMaxFontSize.SubTypography6,
                    lineHeight = DSLineHeight.SubTypography6,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography3,
                    maxFontSize = DSMaxFontSize.Typography3,
                    lineHeight = DSLineHeight.Typography3,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography3,
                    maxFontSize = DSMaxFontSize.Typography3,
                    lineHeight = DSLineHeight.Typography3,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography3,
                    maxFontSize = DSMaxFontSize.Typography3,
                    lineHeight = DSLineHeight.Typography3,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography3,
                    maxFontSize = DSMaxFontSize.Typography3,
                    lineHeight = DSLineHeight.Typography3,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography3,
                    maxFontSize = DSMaxFontSize.Typography3,
                    lineHeight = DSLineHeight.Typography3,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography7,
                    maxFontSize = DSMaxFontSize.SubTypography7,
                    lineHeight = DSLineHeight.SubTypography7,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography7,
                    maxFontSize = DSMaxFontSize.SubTypography7,
                    lineHeight = DSLineHeight.SubTypography7,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography7,
                    maxFontSize = DSMaxFontSize.SubTypography7,
                    lineHeight = DSLineHeight.SubTypography7,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography7,
                    maxFontSize = DSMaxFontSize.SubTypography7,
                    lineHeight = DSLineHeight.SubTypography7,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography7,
                    maxFontSize = DSMaxFontSize.SubTypography7,
                    lineHeight = DSLineHeight.SubTypography7,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography4,
                    maxFontSize = DSMaxFontSize.Typography4,
                    lineHeight = DSLineHeight.Typography4,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography4,
                    maxFontSize = DSMaxFontSize.Typography4,
                    lineHeight = DSLineHeight.Typography4,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography4,
                    maxFontSize = DSMaxFontSize.Typography4,
                    lineHeight = DSLineHeight.Typography4,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography4,
                    maxFontSize = DSMaxFontSize.Typography4,
                    lineHeight = DSLineHeight.Typography4,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography4,
                    maxFontSize = DSMaxFontSize.Typography4,
                    lineHeight = DSLineHeight.Typography4,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography8 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography8,
                    maxFontSize = DSMaxFontSize.SubTypography8,
                    lineHeight = DSLineHeight.SubTypography8,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography8,
                    maxFontSize = DSMaxFontSize.SubTypography8,
                    lineHeight = DSLineHeight.SubTypography8,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography8,
                    maxFontSize = DSMaxFontSize.SubTypography8,
                    lineHeight = DSLineHeight.SubTypography8,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography8,
                    maxFontSize = DSMaxFontSize.SubTypography8,
                    lineHeight = DSLineHeight.SubTypography8,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography8,
                    maxFontSize = DSMaxFontSize.SubTypography8,
                    lineHeight = DSLineHeight.SubTypography8,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography9 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography9,
                    maxFontSize = DSMaxFontSize.SubTypography9,
                    lineHeight = DSLineHeight.SubTypography9,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography9,
                    maxFontSize = DSMaxFontSize.SubTypography9,
                    lineHeight = DSLineHeight.SubTypography9,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography9,
                    maxFontSize = DSMaxFontSize.SubTypography9,
                    lineHeight = DSLineHeight.SubTypography9,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography9,
                    maxFontSize = DSMaxFontSize.SubTypography9,
                    lineHeight = DSLineHeight.SubTypography9,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography9,
                    maxFontSize = DSMaxFontSize.SubTypography9,
                    lineHeight = DSLineHeight.SubTypography9,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography5,
                    maxFontSize = DSMaxFontSize.Typography5,
                    lineHeight = DSLineHeight.Typography5,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography5,
                    maxFontSize = DSMaxFontSize.Typography5,
                    lineHeight = DSLineHeight.Typography5,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography5,
                    maxFontSize = DSMaxFontSize.Typography5,
                    lineHeight = DSLineHeight.Typography5,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography5,
                    maxFontSize = DSMaxFontSize.Typography5,
                    lineHeight = DSLineHeight.Typography5,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography5,
                    maxFontSize = DSMaxFontSize.Typography5,
                    lineHeight = DSLineHeight.Typography5,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography10 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography10,
                    maxFontSize = DSMaxFontSize.SubTypography10,
                    lineHeight = DSLineHeight.SubTypography10,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography10,
                    maxFontSize = DSMaxFontSize.SubTypography10,
                    lineHeight = DSLineHeight.SubTypography10,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography10,
                    maxFontSize = DSMaxFontSize.SubTypography10,
                    lineHeight = DSLineHeight.SubTypography10,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography10,
                    maxFontSize = DSMaxFontSize.SubTypography10,
                    lineHeight = DSLineHeight.SubTypography10,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography10,
                    maxFontSize = DSMaxFontSize.SubTypography10,
                    lineHeight = DSLineHeight.SubTypography10,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography6,
                    maxFontSize = DSMaxFontSize.Typography6,
                    lineHeight = DSLineHeight.Typography6,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography6,
                    maxFontSize = DSMaxFontSize.Typography6,
                    lineHeight = DSLineHeight.Typography6,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography6,
                    maxFontSize = DSMaxFontSize.Typography6,
                    lineHeight = DSLineHeight.Typography6,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography6,
                    maxFontSize = DSMaxFontSize.Typography6,
                    lineHeight = DSLineHeight.Typography6,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography6,
                    maxFontSize = DSMaxFontSize.Typography6,
                    lineHeight = DSLineHeight.Typography6,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography11 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography11,
                    maxFontSize = DSMaxFontSize.SubTypography11,
                    lineHeight = DSLineHeight.SubTypography11,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography11,
                    maxFontSize = DSMaxFontSize.SubTypography11,
                    lineHeight = DSLineHeight.SubTypography11,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography11,
                    maxFontSize = DSMaxFontSize.SubTypography11,
                    lineHeight = DSLineHeight.SubTypography11,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography11,
                    maxFontSize = DSMaxFontSize.SubTypography11,
                    lineHeight = DSLineHeight.SubTypography11,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography11,
                    maxFontSize = DSMaxFontSize.SubTypography11,
                    lineHeight = DSLineHeight.SubTypography11,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.Typography7,
                    maxFontSize = DSMaxFontSize.Typography7,
                    lineHeight = DSLineHeight.Typography7,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.Typography7,
                    maxFontSize = DSMaxFontSize.Typography7,
                    lineHeight = DSLineHeight.Typography7,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.Typography7,
                    maxFontSize = DSMaxFontSize.Typography7,
                    lineHeight = DSLineHeight.Typography7,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.Typography7,
                    maxFontSize = DSMaxFontSize.Typography7,
                    lineHeight = DSLineHeight.Typography7,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.Typography7,
                    maxFontSize = DSMaxFontSize.Typography7,
                    lineHeight = DSLineHeight.Typography7,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography12 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography12,
                    maxFontSize = DSMaxFontSize.SubTypography12,
                    lineHeight = DSLineHeight.SubTypography12,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography12,
                    maxFontSize = DSMaxFontSize.SubTypography12,
                    lineHeight = DSLineHeight.SubTypography12,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography12,
                    maxFontSize = DSMaxFontSize.SubTypography12,
                    lineHeight = DSLineHeight.SubTypography12,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography12,
                    maxFontSize = DSMaxFontSize.SubTypography12,
                    lineHeight = DSLineHeight.SubTypography12,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography12,
                    maxFontSize = DSMaxFontSize.SubTypography12,
                    lineHeight = DSLineHeight.SubTypography12,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography13 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.SubTypography13,
                    maxFontSize = DSMaxFontSize.SubTypography13,
                    lineHeight = DSLineHeight.SubTypography13,
                    weight = DSFontWeight.Light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.SubTypography13,
                    maxFontSize = DSMaxFontSize.SubTypography13,
                    lineHeight = DSLineHeight.SubTypography13,
                    weight = DSFontWeight.Regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.SubTypography13,
                    maxFontSize = DSMaxFontSize.SubTypography13,
                    lineHeight = DSLineHeight.SubTypography13,
                    weight = DSFontWeight.Medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.SubTypography13,
                    maxFontSize = DSMaxFontSize.SubTypography13,
                    lineHeight = DSLineHeight.SubTypography13,
                    weight = DSFontWeight.SemiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.SubTypography13,
                    maxFontSize = DSMaxFontSize.SubTypography13,
                    lineHeight = DSLineHeight.SubTypography13,
                    weight = DSFontWeight.Bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            )
        )
    }
}

val LocalTypography: ProvidableCompositionLocal<TypographyScheme> = staticCompositionLocalOf {
    error("LocalTypography not provided")
}