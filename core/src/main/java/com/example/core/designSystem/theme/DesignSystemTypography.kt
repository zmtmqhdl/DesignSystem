package com.example.core.designSystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
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
    val Bold = FontWeight(weight = 700)
    val Medium = FontWeight(weight = 500)
    val Regular = FontWeight(weight = 400)
}

object DesignSystemFontScalePercent {
    const val PERCENT = 0.01
}

private fun textStyle(
    fontSize: TextUnit,
    maxFontSize: TextUnit,
    lineHeight: TextUnit,
    weight: FontWeight,
    fontRes: Int,
    fontScale: Float
): TextStyle {
    val percent = DesignSystemFontScalePercent.PERCENT
    val scaledSize = (fontSize * fontScale * percent).value

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
    val typography1Bold: TextStyle,
    val typography1Medium: TextStyle,
    val typography1Regular: TextStyle,
    val subTypography1Bold: TextStyle,
    val subTypography1Medium: TextStyle,
    val subTypography1Regular: TextStyle,
    val subTypography2Bold: TextStyle,
    val subTypography2Medium: TextStyle,
    val subTypography2Regular: TextStyle,
    val subTypography3Bold: TextStyle,
    val subTypography3Medium: TextStyle,
    val subTypography3Regular: TextStyle,
    val typography2Bold: TextStyle,
    val typography2Medium: TextStyle,
    val typography2Regular: TextStyle,
    val subTypography4Bold: TextStyle,
    val subTypography4Medium: TextStyle,
    val subTypography4Regular: TextStyle,
    val subTypography5Bold: TextStyle,
    val subTypography5Medium: TextStyle,
    val subTypography5Regular: TextStyle,
    val subTypography6Bold: TextStyle,
    val subTypography6Medium: TextStyle,
    val subTypography6Regular: TextStyle,
    val typography3Bold: TextStyle,
    val typography3Medium: TextStyle,
    val typography3Regular: TextStyle,
    val subTypography7Bold: TextStyle,
    val subTypography7Medium: TextStyle,
    val subTypography7Regular: TextStyle,
    val typography4Bold: TextStyle,
    val typography4Medium: TextStyle,
    val typography4Regular: TextStyle,
    val subTypography8Bold: TextStyle,
    val subTypography8Medium: TextStyle,
    val subTypography8Regular: TextStyle,
    val subTypography9Bold: TextStyle,
    val subTypography9Medium: TextStyle,
    val subTypography9Regular: TextStyle,
    val typography5Bold: TextStyle,
    val typography5Medium: TextStyle,
    val typography5Regular: TextStyle,
    val subTypography10Bold: TextStyle,
    val subTypography10Medium: TextStyle,
    val subTypography10Regular: TextStyle,
    val typography6Bold: TextStyle,
    val typography6Medium: TextStyle,
    val typography6Regular: TextStyle,
    val subTypography11Bold: TextStyle,
    val subTypography11Medium: TextStyle,
    val subTypography11Regular: TextStyle,
    val typography7Bold: TextStyle,
    val typography7Medium: TextStyle,
    val typography7Regular: TextStyle,
    val subTypography12Bold: TextStyle,
    val subTypography12Medium: TextStyle,
    val subTypography12Regular: TextStyle,
    val subTypography13Bold: TextStyle,
    val subTypography13Medium: TextStyle,
    val subTypography13Regular: TextStyle,
)

@Composable
fun typography(): DesignSystemTypography {
    val fontScale = LocalDensity.current.fontScale

    return remember(key1 = fontScale) {
        DesignSystemTypography(
            typography1Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography1,
                maxFontSize = DesignSystemMaxFontSize.Typography1,
                lineHeight = DesignSystemLineHeight.Typography1,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography1Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography1,
                maxFontSize = DesignSystemMaxFontSize.Typography1,
                lineHeight = DesignSystemLineHeight.Typography1,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography1Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography1,
                maxFontSize = DesignSystemMaxFontSize.Typography1,
                lineHeight = DesignSystemLineHeight.Typography1,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography1Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography1,
                maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                lineHeight = DesignSystemLineHeight.SubTypography1,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography1Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography1,
                maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                lineHeight = DesignSystemLineHeight.SubTypography1,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography1Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography1,
                maxFontSize = DesignSystemMaxFontSize.SubTypography1,
                lineHeight = DesignSystemLineHeight.SubTypography1,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography2Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography2,
                maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                lineHeight = DesignSystemLineHeight.SubTypography2,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography2Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography2,
                maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                lineHeight = DesignSystemLineHeight.SubTypography2,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography2Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography2,
                maxFontSize = DesignSystemMaxFontSize.SubTypography2,
                lineHeight = DesignSystemLineHeight.SubTypography2,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography3Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography3,
                maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                lineHeight = DesignSystemLineHeight.SubTypography3,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography3Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography3,
                maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                lineHeight = DesignSystemLineHeight.SubTypography3,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography3Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography3,
                maxFontSize = DesignSystemMaxFontSize.SubTypography3,
                lineHeight = DesignSystemLineHeight.SubTypography3,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography2Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography2,
                maxFontSize = DesignSystemMaxFontSize.Typography2,
                lineHeight = DesignSystemLineHeight.Typography2,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography2Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography2,
                maxFontSize = DesignSystemMaxFontSize.Typography2,
                lineHeight = DesignSystemLineHeight.Typography2,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography2Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography2,
                maxFontSize = DesignSystemMaxFontSize.Typography2,
                lineHeight = DesignSystemLineHeight.Typography2,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography4Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography4,
                maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                lineHeight = DesignSystemLineHeight.SubTypography4,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography4Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography4,
                maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                lineHeight = DesignSystemLineHeight.SubTypography4,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography4Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography4,
                maxFontSize = DesignSystemMaxFontSize.SubTypography4,
                lineHeight = DesignSystemLineHeight.SubTypography4,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography5Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography5,
                maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                lineHeight = DesignSystemLineHeight.SubTypography5,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography5Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography5,
                maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                lineHeight = DesignSystemLineHeight.SubTypography5,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography5Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography5,
                maxFontSize = DesignSystemMaxFontSize.SubTypography5,
                lineHeight = DesignSystemLineHeight.SubTypography5,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography6Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography6,
                maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                lineHeight = DesignSystemLineHeight.SubTypography6,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography6Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography6,
                maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                lineHeight = DesignSystemLineHeight.SubTypography6,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography6Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography6,
                maxFontSize = DesignSystemMaxFontSize.SubTypography6,
                lineHeight = DesignSystemLineHeight.SubTypography6,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography3Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography3,
                maxFontSize = DesignSystemMaxFontSize.Typography3,
                lineHeight = DesignSystemLineHeight.Typography3,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography3Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography3,
                maxFontSize = DesignSystemMaxFontSize.Typography3,
                lineHeight = DesignSystemLineHeight.Typography3,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography3Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography3,
                maxFontSize = DesignSystemMaxFontSize.Typography3,
                lineHeight = DesignSystemLineHeight.Typography3,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography7Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography7,
                maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                lineHeight = DesignSystemLineHeight.SubTypography7,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography7Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography7,
                maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                lineHeight = DesignSystemLineHeight.SubTypography7,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography7Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography7,
                maxFontSize = DesignSystemMaxFontSize.SubTypography7,
                lineHeight = DesignSystemLineHeight.SubTypography7,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography4Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography4,
                maxFontSize = DesignSystemMaxFontSize.Typography4,
                lineHeight = DesignSystemLineHeight.Typography4,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography4Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography4,
                maxFontSize = DesignSystemMaxFontSize.Typography4,
                lineHeight = DesignSystemLineHeight.Typography4,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography4Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography4,
                maxFontSize = DesignSystemMaxFontSize.Typography4,
                lineHeight = DesignSystemLineHeight.Typography4,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography8Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography8,
                maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                lineHeight = DesignSystemLineHeight.SubTypography8,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography8Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography8,
                maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                lineHeight = DesignSystemLineHeight.SubTypography8,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography8Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography8,
                maxFontSize = DesignSystemMaxFontSize.SubTypography8,
                lineHeight = DesignSystemLineHeight.SubTypography8,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography9Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography9,
                maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                lineHeight = DesignSystemLineHeight.SubTypography9,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography9Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography9,
                maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                lineHeight = DesignSystemLineHeight.SubTypography9,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography9Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography9,
                maxFontSize = DesignSystemMaxFontSize.SubTypography9,
                lineHeight = DesignSystemLineHeight.SubTypography9,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography5Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography5,
                maxFontSize = DesignSystemMaxFontSize.Typography5,
                lineHeight = DesignSystemLineHeight.Typography5,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography5Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography5,
                maxFontSize = DesignSystemMaxFontSize.Typography5,
                lineHeight = DesignSystemLineHeight.Typography5,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography5Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography5,
                maxFontSize = DesignSystemMaxFontSize.Typography5,
                lineHeight = DesignSystemLineHeight.Typography5,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography10Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography10,
                maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                lineHeight = DesignSystemLineHeight.SubTypography10,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography10Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography10,
                maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                lineHeight = DesignSystemLineHeight.SubTypography10,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography10Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography10,
                maxFontSize = DesignSystemMaxFontSize.SubTypography10,
                lineHeight = DesignSystemLineHeight.SubTypography10,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography6Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography6,
                maxFontSize = DesignSystemMaxFontSize.Typography6,
                lineHeight = DesignSystemLineHeight.Typography6,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography6Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography6,
                maxFontSize = DesignSystemMaxFontSize.Typography6,
                lineHeight = DesignSystemLineHeight.Typography6,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography6Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography6,
                maxFontSize = DesignSystemMaxFontSize.Typography6,
                lineHeight = DesignSystemLineHeight.Typography6,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography11Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography11,
                maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                lineHeight = DesignSystemLineHeight.SubTypography11,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography11Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography11,
                maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                lineHeight = DesignSystemLineHeight.SubTypography11,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography11Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography11,
                maxFontSize = DesignSystemMaxFontSize.SubTypography11,
                lineHeight = DesignSystemLineHeight.SubTypography11,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            typography7Bold = textStyle(
                fontSize = DesignSystemFontSize.Typography7,
                maxFontSize = DesignSystemMaxFontSize.Typography7,
                lineHeight = DesignSystemLineHeight.Typography7,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            typography7Medium = textStyle(
                fontSize = DesignSystemFontSize.Typography7,
                maxFontSize = DesignSystemMaxFontSize.Typography7,
                lineHeight = DesignSystemLineHeight.Typography7,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            typography7Regular = textStyle(
                fontSize = DesignSystemFontSize.Typography7,
                maxFontSize = DesignSystemMaxFontSize.Typography7,
                lineHeight = DesignSystemLineHeight.Typography7,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography12Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography12,
                maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                lineHeight = DesignSystemLineHeight.SubTypography12,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography12Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography12,
                maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                lineHeight = DesignSystemLineHeight.SubTypography12,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography12Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography12,
                maxFontSize = DesignSystemMaxFontSize.SubTypography12,
                lineHeight = DesignSystemLineHeight.SubTypography12,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
            subTypography13Bold = textStyle(
                fontSize = DesignSystemFontSize.SubTypography13,
                maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                lineHeight = DesignSystemLineHeight.SubTypography13,
                weight = DesignSystemFontWeight.Bold,
                fontRes = R.font.bold,
                fontScale = fontScale
            ),
            subTypography13Medium = textStyle(
                fontSize = DesignSystemFontSize.SubTypography13,
                maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                lineHeight = DesignSystemLineHeight.SubTypography13,
                weight = DesignSystemFontWeight.Medium,
                fontRes = R.font.medium,
                fontScale = fontScale
            ),
            subTypography13Regular = textStyle(
                fontSize = DesignSystemFontSize.SubTypography13,
                maxFontSize = DesignSystemMaxFontSize.SubTypography13,
                lineHeight = DesignSystemLineHeight.SubTypography13,
                weight = DesignSystemFontWeight.Regular,
                fontRes = R.font.regular,
                fontScale = fontScale
            ),
        )
    }
}

val LocalTypography = staticCompositionLocalOf {
    DesignSystemTypography(
        typography1Bold = TextStyle.Default,
        typography1Medium = TextStyle.Default,
        typography1Regular = TextStyle.Default,
        subTypography1Bold = TextStyle.Default,
        subTypography1Medium = TextStyle.Default,
        subTypography1Regular = TextStyle.Default,
        subTypography2Bold = TextStyle.Default,
        subTypography2Medium = TextStyle.Default,
        subTypography2Regular = TextStyle.Default,
        subTypography3Bold = TextStyle.Default,
        subTypography3Medium = TextStyle.Default,
        subTypography3Regular = TextStyle.Default,
        typography2Bold = TextStyle.Default,
        typography2Medium = TextStyle.Default,
        typography2Regular = TextStyle.Default,
        subTypography4Bold = TextStyle.Default,
        subTypography4Medium = TextStyle.Default,
        subTypography4Regular = TextStyle.Default,
        subTypography5Bold = TextStyle.Default,
        subTypography5Medium = TextStyle.Default,
        subTypography5Regular = TextStyle.Default,
        subTypography6Bold = TextStyle.Default,
        subTypography6Medium = TextStyle.Default,
        subTypography6Regular = TextStyle.Default,
        typography3Bold = TextStyle.Default,
        typography3Medium = TextStyle.Default,
        typography3Regular = TextStyle.Default,
        subTypography7Bold = TextStyle.Default,
        subTypography7Medium = TextStyle.Default,
        subTypography7Regular = TextStyle.Default,
        typography4Bold = TextStyle.Default,
        typography4Medium = TextStyle.Default,
        typography4Regular = TextStyle.Default,
        subTypography8Bold = TextStyle.Default,
        subTypography8Medium = TextStyle.Default,
        subTypography8Regular = TextStyle.Default,
        subTypography9Bold = TextStyle.Default,
        subTypography9Medium = TextStyle.Default,
        subTypography9Regular = TextStyle.Default,
        typography5Bold = TextStyle.Default,
        typography5Medium = TextStyle.Default,
        typography5Regular = TextStyle.Default,
        subTypography10Bold = TextStyle.Default,
        subTypography10Medium = TextStyle.Default,
        subTypography10Regular = TextStyle.Default,
        typography6Bold = TextStyle.Default,
        typography6Medium = TextStyle.Default,
        typography6Regular = TextStyle.Default,
        subTypography11Bold = TextStyle.Default,
        subTypography11Medium = TextStyle.Default,
        subTypography11Regular = TextStyle.Default,
        typography7Bold = TextStyle.Default,
        typography7Medium = TextStyle.Default,
        typography7Regular = TextStyle.Default,
        subTypography12Bold = TextStyle.Default,
        subTypography12Medium = TextStyle.Default,
        subTypography12Regular = TextStyle.Default,
        subTypography13Bold = TextStyle.Default,
        subTypography13Medium = TextStyle.Default,
        subTypography13Regular = TextStyle.Default,
    )
}