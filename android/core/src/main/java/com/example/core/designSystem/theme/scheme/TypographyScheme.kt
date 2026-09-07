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
 * Light랑 SemiBold 추가 필요 (글씨체 자체)
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
    val typography1 = 30.sp
    val subTypography1 = 29.sp
    val subTypography2 = 28.sp
    val subTypography3 = 27.sp
    val typography2 = 26.sp
    val subTypography4 = 25.sp
    val subTypography5 = 24.sp
    val subTypography6 = 23.sp
    val typography3 = 22.sp
    val subTypography7 = 21.sp
    val typography4 = 20.sp
    val subTypography8 = 19.sp
    val subTypography9 = 18.sp
    val typography5 = 17.sp
    val subTypography10 = 16.sp
    val typography6 = 15.sp
    val subTypography11 = 14.sp
    val typography7 = 13.sp
    val subTypography12 = 12.sp
    val subTypography13 = 11.sp
}

@Immutable
object DSLineHeight {
    val typography1 = 40.sp
    val subTypography1 = 38.sp
    val subTypography2 = 37.sp
    val subTypography3 = 36.sp
    val typography2 = 35.sp
    val subTypography4 = 34.sp
    val subTypography5 = 33.sp
    val subTypography6 = 32.sp
    val typography3 = 31.sp
    val subTypography7 = 30.sp
    val typography4 = 29.sp
    val subTypography8 = 28.sp
    val subTypography9 = 27.sp
    val typography5 = 25.5.sp
    val subTypography10 = 24.sp
    val typography6 = 22.5.sp
    val subTypography11 = 21.sp
    val typography7 = 19.5.sp
    val subTypography12 = 18.sp
    val subTypography13 = 16.5.sp
}

@Immutable
object DSMaxFontSize {
    val typography1 = 42.sp
    val subTypography1 = 42.sp
    val subTypography2 = 41.sp
    val subTypography3 = 41.sp
    val typography2 = 41.sp
    val subTypography4 = 41.sp
    val subTypography5 = 40.sp
    val subTypography6 = 40.sp
    val typography3 = 40.sp
    val subTypography7 = 40.sp
    val typography4 = 40.sp
    val subTypography8 = 40.sp
    val subTypography9 = 39.sp
    val typography5 = 39.sp
    val subTypography10 = 39.sp
    val typography6 = 37.sp
    val subTypography11 = 36.sp
    val typography7 = 34.sp
    val subTypography12 = 32.sp
    val subTypography13 = 31.sp
}

@Immutable
object DSFontWeight {
    val light = FontWeight(weight = 100)
    val regular = FontWeight(weight = 400)
    val medium = FontWeight(weight = 500)
    val semiBold = FontWeight(weight = 600)
    val bold = FontWeight(weight = 700)
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
                    fontSize = DSFontSize.typography1,
                    maxFontSize = DSMaxFontSize.typography1,
                    lineHeight = DSLineHeight.typography1,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography1,
                    maxFontSize = DSMaxFontSize.typography1,
                    lineHeight = DSLineHeight.typography1,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography1,
                    maxFontSize = DSMaxFontSize.typography1,
                    lineHeight = DSLineHeight.typography1,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography1,
                    maxFontSize = DSMaxFontSize.typography1,
                    lineHeight = DSLineHeight.typography1,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography1,
                    maxFontSize = DSMaxFontSize.typography1,
                    lineHeight = DSLineHeight.typography1,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography1 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography1,
                    maxFontSize = DSMaxFontSize.subTypography1,
                    lineHeight = DSLineHeight.subTypography1,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography1,
                    maxFontSize = DSMaxFontSize.subTypography1,
                    lineHeight = DSLineHeight.subTypography1,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography1,
                    maxFontSize = DSMaxFontSize.subTypography1,
                    lineHeight = DSLineHeight.subTypography1,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography1,
                    maxFontSize = DSMaxFontSize.subTypography1,
                    lineHeight = DSLineHeight.subTypography1,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography1,
                    maxFontSize = DSMaxFontSize.subTypography1,
                    lineHeight = DSLineHeight.subTypography1,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography2,
                    maxFontSize = DSMaxFontSize.subTypography2,
                    lineHeight = DSLineHeight.subTypography2,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography2,
                    maxFontSize = DSMaxFontSize.subTypography2,
                    lineHeight = DSLineHeight.subTypography2,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography2,
                    maxFontSize = DSMaxFontSize.subTypography2,
                    lineHeight = DSLineHeight.subTypography2,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography2,
                    maxFontSize = DSMaxFontSize.subTypography2,
                    lineHeight = DSLineHeight.subTypography2,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography2,
                    maxFontSize = DSMaxFontSize.subTypography2,
                    lineHeight = DSLineHeight.subTypography2,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography3,
                    maxFontSize = DSMaxFontSize.subTypography3,
                    lineHeight = DSLineHeight.subTypography3,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography3,
                    maxFontSize = DSMaxFontSize.subTypography3,
                    lineHeight = DSLineHeight.subTypography3,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography3,
                    maxFontSize = DSMaxFontSize.subTypography3,
                    lineHeight = DSLineHeight.subTypography3,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography3,
                    maxFontSize = DSMaxFontSize.subTypography3,
                    lineHeight = DSLineHeight.subTypography3,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography3,
                    maxFontSize = DSMaxFontSize.subTypography3,
                    lineHeight = DSLineHeight.subTypography3,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography2 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography2,
                    maxFontSize = DSMaxFontSize.typography2,
                    lineHeight = DSLineHeight.typography2,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography2,
                    maxFontSize = DSMaxFontSize.typography2,
                    lineHeight = DSLineHeight.typography2,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography2,
                    maxFontSize = DSMaxFontSize.typography2,
                    lineHeight = DSLineHeight.typography2,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography2,
                    maxFontSize = DSMaxFontSize.typography2,
                    lineHeight = DSLineHeight.typography2,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography2,
                    maxFontSize = DSMaxFontSize.typography2,
                    lineHeight = DSLineHeight.typography2,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography4,
                    maxFontSize = DSMaxFontSize.subTypography4,
                    lineHeight = DSLineHeight.subTypography4,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography4,
                    maxFontSize = DSMaxFontSize.subTypography4,
                    lineHeight = DSLineHeight.subTypography4,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography4,
                    maxFontSize = DSMaxFontSize.subTypography4,
                    lineHeight = DSLineHeight.subTypography4,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography4,
                    maxFontSize = DSMaxFontSize.subTypography4,
                    lineHeight = DSLineHeight.subTypography4,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography4,
                    maxFontSize = DSMaxFontSize.subTypography4,
                    lineHeight = DSLineHeight.subTypography4,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography5,
                    maxFontSize = DSMaxFontSize.subTypography5,
                    lineHeight = DSLineHeight.subTypography5,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography5,
                    maxFontSize = DSMaxFontSize.subTypography5,
                    lineHeight = DSLineHeight.subTypography5,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography5,
                    maxFontSize = DSMaxFontSize.subTypography5,
                    lineHeight = DSLineHeight.subTypography5,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography5,
                    maxFontSize = DSMaxFontSize.subTypography5,
                    lineHeight = DSLineHeight.subTypography5,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography5,
                    maxFontSize = DSMaxFontSize.subTypography5,
                    lineHeight = DSLineHeight.subTypography5,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography6,
                    maxFontSize = DSMaxFontSize.subTypography6,
                    lineHeight = DSLineHeight.subTypography6,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography6,
                    maxFontSize = DSMaxFontSize.subTypography6,
                    lineHeight = DSLineHeight.subTypography6,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography6,
                    maxFontSize = DSMaxFontSize.subTypography6,
                    lineHeight = DSLineHeight.subTypography6,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography6,
                    maxFontSize = DSMaxFontSize.subTypography6,
                    lineHeight = DSLineHeight.subTypography6,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography6,
                    maxFontSize = DSMaxFontSize.subTypography6,
                    lineHeight = DSLineHeight.subTypography6,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography3 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography3,
                    maxFontSize = DSMaxFontSize.typography3,
                    lineHeight = DSLineHeight.typography3,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography3,
                    maxFontSize = DSMaxFontSize.typography3,
                    lineHeight = DSLineHeight.typography3,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography3,
                    maxFontSize = DSMaxFontSize.typography3,
                    lineHeight = DSLineHeight.typography3,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography3,
                    maxFontSize = DSMaxFontSize.typography3,
                    lineHeight = DSLineHeight.typography3,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography3,
                    maxFontSize = DSMaxFontSize.typography3,
                    lineHeight = DSLineHeight.typography3,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography7,
                    maxFontSize = DSMaxFontSize.subTypography7,
                    lineHeight = DSLineHeight.subTypography7,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography7,
                    maxFontSize = DSMaxFontSize.subTypography7,
                    lineHeight = DSLineHeight.subTypography7,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography7,
                    maxFontSize = DSMaxFontSize.subTypography7,
                    lineHeight = DSLineHeight.subTypography7,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography7,
                    maxFontSize = DSMaxFontSize.subTypography7,
                    lineHeight = DSLineHeight.subTypography7,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography7,
                    maxFontSize = DSMaxFontSize.subTypography7,
                    lineHeight = DSLineHeight.subTypography7,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography4 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography4,
                    maxFontSize = DSMaxFontSize.typography4,
                    lineHeight = DSLineHeight.typography4,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography4,
                    maxFontSize = DSMaxFontSize.typography4,
                    lineHeight = DSLineHeight.typography4,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography4,
                    maxFontSize = DSMaxFontSize.typography4,
                    lineHeight = DSLineHeight.typography4,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography4,
                    maxFontSize = DSMaxFontSize.typography4,
                    lineHeight = DSLineHeight.typography4,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography4,
                    maxFontSize = DSMaxFontSize.typography4,
                    lineHeight = DSLineHeight.typography4,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography8 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography8,
                    maxFontSize = DSMaxFontSize.subTypography8,
                    lineHeight = DSLineHeight.subTypography8,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography8,
                    maxFontSize = DSMaxFontSize.subTypography8,
                    lineHeight = DSLineHeight.subTypography8,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography8,
                    maxFontSize = DSMaxFontSize.subTypography8,
                    lineHeight = DSLineHeight.subTypography8,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography8,
                    maxFontSize = DSMaxFontSize.subTypography8,
                    lineHeight = DSLineHeight.subTypography8,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography8,
                    maxFontSize = DSMaxFontSize.subTypography8,
                    lineHeight = DSLineHeight.subTypography8,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography9 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography9,
                    maxFontSize = DSMaxFontSize.subTypography9,
                    lineHeight = DSLineHeight.subTypography9,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography9,
                    maxFontSize = DSMaxFontSize.subTypography9,
                    lineHeight = DSLineHeight.subTypography9,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography9,
                    maxFontSize = DSMaxFontSize.subTypography9,
                    lineHeight = DSLineHeight.subTypography9,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography9,
                    maxFontSize = DSMaxFontSize.subTypography9,
                    lineHeight = DSLineHeight.subTypography9,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography9,
                    maxFontSize = DSMaxFontSize.subTypography9,
                    lineHeight = DSLineHeight.subTypography9,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),
            typography5 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography5,
                    maxFontSize = DSMaxFontSize.typography5,
                    lineHeight = DSLineHeight.typography5,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography5,
                    maxFontSize = DSMaxFontSize.typography5,
                    lineHeight = DSLineHeight.typography5,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography5,
                    maxFontSize = DSMaxFontSize.typography5,
                    lineHeight = DSLineHeight.typography5,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography5,
                    maxFontSize = DSMaxFontSize.typography5,
                    lineHeight = DSLineHeight.typography5,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography5,
                    maxFontSize = DSMaxFontSize.typography5,
                    lineHeight = DSLineHeight.typography5,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography10 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography10,
                    maxFontSize = DSMaxFontSize.subTypography10,
                    lineHeight = DSLineHeight.subTypography10,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography10,
                    maxFontSize = DSMaxFontSize.subTypography10,
                    lineHeight = DSLineHeight.subTypography10,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography10,
                    maxFontSize = DSMaxFontSize.subTypography10,
                    lineHeight = DSLineHeight.subTypography10,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography10,
                    maxFontSize = DSMaxFontSize.subTypography10,
                    lineHeight = DSLineHeight.subTypography10,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography10,
                    maxFontSize = DSMaxFontSize.subTypography10,
                    lineHeight = DSLineHeight.subTypography10,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography6 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography6,
                    maxFontSize = DSMaxFontSize.typography6,
                    lineHeight = DSLineHeight.typography6,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography6,
                    maxFontSize = DSMaxFontSize.typography6,
                    lineHeight = DSLineHeight.typography6,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography6,
                    maxFontSize = DSMaxFontSize.typography6,
                    lineHeight = DSLineHeight.typography6,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography6,
                    maxFontSize = DSMaxFontSize.typography6,
                    lineHeight = DSLineHeight.typography6,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography6,
                    maxFontSize = DSMaxFontSize.typography6,
                    lineHeight = DSLineHeight.typography6,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography11 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography11,
                    maxFontSize = DSMaxFontSize.subTypography11,
                    lineHeight = DSLineHeight.subTypography11,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography11,
                    maxFontSize = DSMaxFontSize.subTypography11,
                    lineHeight = DSLineHeight.subTypography11,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography11,
                    maxFontSize = DSMaxFontSize.subTypography11,
                    lineHeight = DSLineHeight.subTypography11,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography11,
                    maxFontSize = DSMaxFontSize.subTypography11,
                    lineHeight = DSLineHeight.subTypography11,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography11,
                    maxFontSize = DSMaxFontSize.subTypography11,
                    lineHeight = DSLineHeight.subTypography11,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            typography7 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.typography7,
                    maxFontSize = DSMaxFontSize.typography7,
                    lineHeight = DSLineHeight.typography7,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.typography7,
                    maxFontSize = DSMaxFontSize.typography7,
                    lineHeight = DSLineHeight.typography7,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.typography7,
                    maxFontSize = DSMaxFontSize.typography7,
                    lineHeight = DSLineHeight.typography7,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.typography7,
                    maxFontSize = DSMaxFontSize.typography7,
                    lineHeight = DSLineHeight.typography7,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.typography7,
                    maxFontSize = DSMaxFontSize.typography7,
                    lineHeight = DSLineHeight.typography7,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography12 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography12,
                    maxFontSize = DSMaxFontSize.subTypography12,
                    lineHeight = DSLineHeight.subTypography12,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography12,
                    maxFontSize = DSMaxFontSize.subTypography12,
                    lineHeight = DSLineHeight.subTypography12,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography12,
                    maxFontSize = DSMaxFontSize.subTypography12,
                    lineHeight = DSLineHeight.subTypography12,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography12,
                    maxFontSize = DSMaxFontSize.subTypography12,
                    lineHeight = DSLineHeight.subTypography12,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography12,
                    maxFontSize = DSMaxFontSize.subTypography12,
                    lineHeight = DSLineHeight.subTypography12,
                    weight = DSFontWeight.bold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
            ),

            subTypography13 = FontStyleSet(
                light = textStyle(
                    fontSize = DSFontSize.subTypography13,
                    maxFontSize = DSMaxFontSize.subTypography13,
                    lineHeight = DSLineHeight.subTypography13,
                    weight = DSFontWeight.light,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                regular = textStyle(
                    fontSize = DSFontSize.subTypography13,
                    maxFontSize = DSMaxFontSize.subTypography13,
                    lineHeight = DSLineHeight.subTypography13,
                    weight = DSFontWeight.regular,
                    fontRes = R.font.regular,
                    fontScale = fontScale
                ),
                medium = textStyle(
                    fontSize = DSFontSize.subTypography13,
                    maxFontSize = DSMaxFontSize.subTypography13,
                    lineHeight = DSLineHeight.subTypography13,
                    weight = DSFontWeight.medium,
                    fontRes = R.font.medium,
                    fontScale = fontScale
                ),
                semiBold = textStyle(
                    fontSize = DSFontSize.subTypography13,
                    maxFontSize = DSMaxFontSize.subTypography13,
                    lineHeight = DSLineHeight.subTypography13,
                    weight = DSFontWeight.semiBold,
                    fontRes = R.font.bold,
                    fontScale = fontScale
                ),
                bold = textStyle(
                    fontSize = DSFontSize.subTypography13,
                    maxFontSize = DSMaxFontSize.subTypography13,
                    lineHeight = DSLineHeight.subTypography13,
                    weight = DSFontWeight.bold,
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