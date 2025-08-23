package com.example.core.designSystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class DesignSystemColorSet(
    val fontColor: Color,
    val background: Color,
    val outline: Color
) {
    companion object {
        val Unspecified = DesignSystemColorSet(
            fontColor = Color.Unspecified,
            background = Color.Unspecified,
            outline = Color.Unspecified
        )
    }
}

// light
val LightPrimaryFontColor = Color(0xFF067CFB)
val LightPrimaryBackground = Color(0xFFC9E6FD)
val LightPrimaryOutline = Color(0xFFECF5FD)

val LightSecondaryFontColor = Color(0xFF00C200)
val LightSecondaryBackground = Color(0xFFA4F29F)
val LightSecondaryOutline = Color(0xFFE3FAE1)

val LightTertiaryFontColor = Color(0xFF6A1B9A)
val LightTertiaryBackground = Color(0xFFF1C6FF)
val LightTertiaryOutline = Color(0xFFEEA9D3)

val LightWarningFontColor = Color(0xFFED2B2A)
val LightWarningBackground = Color(0xFFFDD8D9)
val LightWarningOutline = Color(0xFFFDF3F3)

val LightAlarmFontColor = Color(0xFF067CFB)
val LightAlarmBackground = Color(0xFFC9E6FD)
val LightAlarmOutline = Color(0xFFECF5FD)

val LightSuccessFontColor = Color(0xFF00C200)
val LightSuccessBackground = Color(0xFFA4F29F)
val LightSuccessOutline = Color(0xFFE3FAE1)

val LightCautionFontColor = Color(0xFFFDD000)
val LightCautionBackground = Color(0xFFFBF6C9)
val LightCautionOutline = Color(0xFFFDFAE3)

val LightDisableFontColor = Color(0xFFFDD000)
val LightDisableBackground = Color(0xFFFBF6C9)
val LightDisableOutline = Color(0xFFFDFAE3)

val LightWhite = Color(0xFFFFFFFF)
val LightBlack = Color(0xFF000000)
val LightGray600 = Color(0xFF757575)
val LightBackground = Color(0xFFF3F4F6)
val LightBackgroundElevated = Color(0xFFFFFFFF)
val LightActiveIcon = Color(0xFFB0B9C2)
val LightInactiveIcon = Color(0xFF181F29)
val LightText = Color(0xFF161D27)

// dark
val DarkPrimaryFontColor = Color(0xFF067CFB)
val DarkPrimaryBackground = Color(0xFF2B3E9B)
val DarkPrimaryOutline = Color(0xFF3A5E9F)

val DarkSecondaryFontColor = Color(0xFF00C200)
val DarkSecondaryBackground = Color(0xFF307D32)
val DarkSecondaryOutline = Color(0xFF4E9F4E)

val DarkTertiaryFontColor = Color(0xFF6A1B9A)
val DarkTertiaryBackground = Color(0xFF9C4F9A)
val DarkTertiaryOutline = Color(0xFF6F3072)

val DarkWarningFontColor = Color(0xFFED2B2A)
val DarkWarningBackground = Color(0xFF9B5D5D)
val DarkWarningOutline = Color(0xFF9F4C4C)

val DarkAlarmFontColor = Color(0xFF067CFB)
val DarkAlarmBackground = Color(0xFF2B3E9B)
val DarkAlarmOutline = Color(0xFF3A5E9F)

val DarkSuccessFontColor = Color(0xFF00C200)
val DarkSuccessBackground = Color(0xFF307D32)
val DarkSuccessOutline = Color(0xFF4E9F4E)

val DarkCautionFontColor = Color(0xFFFDD000)
val DarkCautionBackground = Color(0xFFAB8A2A)
val DarkCautionOutline = Color(0xFFB69F59)

val DarkDisableFontColor = Color(0xFFFDD000)
val DarkDisableBackground = Color(0xFFAB8A2A)
val DarkDisableOutline = Color(0xFFB69F59)

val DarkWhite = Color(0xFFFFFFFF)
val DarkBlack = Color(0xFF000000)
val DarkGray600 = Color(0xFF757575)
val DarkBackground = Color(0xFF101012)
val DarkBackgroundElevated = Color(0xFF18171C)
val DarkActiveIcon = Color(0xFF63636D)
val DarkInactiveIcon = Color(0xFFFFFFFF)
val DarkText = Color(0xFFFFFFFF)


object DesignSystemColors{
    object Light {
        val Primary = DesignSystemColorSet(
            fontColor = LightPrimaryFontColor,
            background = LightPrimaryBackground,
            outline = LightPrimaryOutline
        )
        val Secondary = DesignSystemColorSet(
            fontColor = LightSecondaryFontColor,
            background = LightSecondaryBackground,
            outline = LightSecondaryOutline
        )
        val Tertiary = DesignSystemColorSet(
            fontColor = LightTertiaryFontColor,
            background = LightTertiaryBackground,
            outline = LightTertiaryOutline
        )
        val Warning = DesignSystemColorSet(
            fontColor = LightWarningFontColor,
            background = LightWarningBackground,
            outline = LightWarningOutline
        )
        val Alarm = DesignSystemColorSet(
            fontColor = LightAlarmFontColor,
            background = LightAlarmBackground,
            outline = LightAlarmOutline
        )
        val Success = DesignSystemColorSet(
            fontColor = LightSuccessFontColor,
            background = LightSuccessBackground,
            outline = LightSuccessOutline
        )
        val Caution = DesignSystemColorSet(
            fontColor = LightCautionFontColor,
            background = LightCautionBackground,
            outline = LightCautionOutline
        )
        val Disable = DesignSystemColorSet(
            fontColor = LightDisableFontColor,
            background = LightDisableBackground,
            outline = LightDisableOutline
        )
        val white = LightWhite
        val black = LightBlack
        val gray600 = LightGray600
        val background = LightBackground
        val backgroundElevated = LightBackgroundElevated
        val activeIcon = LightActiveIcon
        val inactiveIcon = LightInactiveIcon
        val text = LightText
    }
    object Dark {
        val Primary = DesignSystemColorSet(
            fontColor = DarkPrimaryFontColor,
            background = DarkPrimaryBackground,
            outline = DarkPrimaryOutline
        )
        val Secondary = DesignSystemColorSet(
            fontColor = DarkSecondaryFontColor,
            background = DarkSecondaryBackground,
            outline = DarkSecondaryOutline
        )
        val Tertiary = DesignSystemColorSet(
            fontColor = DarkTertiaryFontColor,
            background = DarkTertiaryBackground,
            outline = DarkTertiaryOutline
        )
        val Warning = DesignSystemColorSet(
            fontColor = DarkWarningFontColor,
            background = DarkWarningBackground,
            outline = DarkWarningOutline
        )
        val Alarm = DesignSystemColorSet(
            fontColor = DarkAlarmFontColor,
            background = DarkAlarmBackground,
            outline = DarkAlarmOutline
        )
        val Success = DesignSystemColorSet(
            fontColor = DarkSuccessFontColor,
            background = DarkSuccessBackground,
            outline = DarkSuccessOutline
        )
        val Caution = DesignSystemColorSet(
            fontColor = DarkCautionFontColor,
            background = DarkCautionBackground,
            outline = DarkCautionOutline
        )
        val Disable = DesignSystemColorSet(
            fontColor = DarkDisableFontColor,
            background = DarkDisableBackground,
            outline = DarkDisableOutline
        )
        val white = DarkWhite
        val black = DarkBlack
        val gray600 = DarkGray600
        val background = DarkBackground
        val backgroundElevated = DarkBackgroundElevated
        val activeIcon = DarkActiveIcon
        val inactiveIcon = DarkInactiveIcon
        val text = DarkText
    }
}

@Immutable
data class DesignSystemColor(
    val primary: DesignSystemColorSet,
    val secondary: DesignSystemColorSet,
    val tertiary: DesignSystemColorSet,
    val warning: DesignSystemColorSet,
    val alarm: DesignSystemColorSet,
    val success: DesignSystemColorSet,
    val caution: DesignSystemColorSet,
    val disable: DesignSystemColorSet,
    val white: Color,
    val black: Color,
    val gray600: Color,
    val background: Color,
    val backgroundElevated: Color,
    val activeIcon: Color,
    val inactiveIcon: Color,
    val text: Color
)

val LocalColor = staticCompositionLocalOf {
    DesignSystemColor(
        primary = DesignSystemColorSet.Unspecified,
        secondary = DesignSystemColorSet.Unspecified,
        tertiary = DesignSystemColorSet.Unspecified,
        warning = DesignSystemColorSet.Unspecified,
        alarm = DesignSystemColorSet.Unspecified,
        success = DesignSystemColorSet.Unspecified,
        caution = DesignSystemColorSet.Unspecified,
        disable = DesignSystemColorSet.Unspecified,
        white = Color.Unspecified,
        black = Color.Unspecified,
        gray600 = Color.Unspecified,
        background = Color.Unspecified,
        backgroundElevated = Color.Unspecified,
        activeIcon = Color.Unspecified,
        inactiveIcon = Color.Unspecified,
        text = Color.Unspecified
    )
}