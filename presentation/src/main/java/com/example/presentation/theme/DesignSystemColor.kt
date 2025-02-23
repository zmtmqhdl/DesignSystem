package com.example.presentation.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

sealed class ThemeMode {
    data object Light : ThemeMode()
    data object Dark : ThemeMode()
}

data class DesignSystemColorSetValues(
    val fontColor: Color,
    val background: Color,
    val outline: Color
)

data class DesignSystemColorSet(
    val primary: DesignSystemColorSetValues,
    val secondary: DesignSystemColorSetValues,
    val tertiary: DesignSystemColorSetValues,
    val warning: DesignSystemColorSetValues,
    val alarm: DesignSystemColorSetValues,
    val success: DesignSystemColorSetValues,
    val caution: DesignSystemColorSetValues,
    val disable: DesignSystemColorSetValues,
    val white: Color,
    val black: Color,
    val gray600: Color,
)

object DesignSystemColor {
    object Light {
        val Primary = DesignSystemColorSetValues(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFFC9E6FD),
            outline = Color(0xFFECF5FD)
        )

        val Secondary = DesignSystemColorSetValues(
            fontColor = Color(0xFF00C200),
            background = Color(0xFFA4F29F),
            outline = Color(0xFFE3FAE1)
        )

        val Tertiary = DesignSystemColorSetValues(
            fontColor = Color(0xFF6A1B9A),
            background = Color(0xFFF1C6FF),
            outline = Color(0xFFEEA9D3)
        )

        val Warning = DesignSystemColorSetValues(
            fontColor = Color(0xFFED2B2A),
            background = Color(0xFFFDD8D9),
            outline = Color(0xFFFDF3F3)
        )

        val Alarm = DesignSystemColorSetValues(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFFC9E6FD),
            outline = Color(0xFFECF5FD)
        )

        val Success = DesignSystemColorSetValues(
            fontColor = Color(0xFF00C200),
            background = Color(0xFFA4F29F),
            outline = Color(0xFFE3FAE1)
        )

        val Caution = DesignSystemColorSetValues(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFFBF6C9),
            outline = Color(0xFFFDFAE3)
        )

        val Disable = DesignSystemColorSetValues(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFFBF6C9),
            outline = Color(0xFFFDFAE3)
        )

        val White = Color(0xFFFFFFFF)
        val Black = Color(0xFF000000)
        val Gray600 = Color(0xFF757575)
    }

    object Dark {
        val Primary = DesignSystemColorSetValues(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFF2B3E9B),
            outline = Color(0xFF3A5E9F)
        )

        val Secondary = DesignSystemColorSetValues(
            fontColor = Color(0xFF00C200),
            background = Color(0xFF307D32),
            outline = Color(0xFF4E9F4E)
        )

        val Tertiary = DesignSystemColorSetValues(
            fontColor = Color(0xFF6A1B9A),
            background = Color(0xFF9C4F9A),
            outline = Color(0xFF6F3072)
        )

        val Warning = DesignSystemColorSetValues(
            fontColor = Color(0xFFED2B2A),
            background = Color(0xFF9B5D5D),
            outline = Color(0xFF9F4C4C)
        )

        val Alarm = DesignSystemColorSetValues(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFF2B3E9B),
            outline = Color(0xFF3A5E9F)
        )

        val Success = DesignSystemColorSetValues(
            fontColor = Color(0xFF00C200),
            background = Color(0xFF307D32),
            outline = Color(0xFF4E9F4E)
        )

        val Caution = DesignSystemColorSetValues(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFAB8A2A),
            outline = Color(0xFFB69F59)
        )

        val Disable = DesignSystemColorSetValues(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFAB8A2A),
            outline = Color(0xFFB69F59)
        )

        val White = Color(0xFFFFFFFF)
        val Black = Color(0xFF000000)
        val Gray600 = Color(0xFF757575)
    }
}

fun getDesignSystemColorSet(themeMode: ThemeMode): DesignSystemColorSet {
    return when (themeMode) {
        ThemeMode.Light -> DesignSystemColorSet(
            primary = DesignSystemColor.Light.Primary,
            secondary = DesignSystemColor.Light.Secondary,
            tertiary = DesignSystemColor.Light.Tertiary,
            warning = DesignSystemColor.Light.Warning,
            alarm = DesignSystemColor.Light.Alarm,
            success = DesignSystemColor.Light.Success,
            caution = DesignSystemColor.Light.Caution,
            disable = DesignSystemColor.Light.Disable,
            white = DesignSystemColor.Light.White,
            black = DesignSystemColor.Light.Black,
            gray600 = DesignSystemColor.Light.Gray600
        )

        ThemeMode.Dark -> DesignSystemColorSet(
            primary = DesignSystemColor.Dark.Primary,
            secondary = DesignSystemColor.Dark.Secondary,
            tertiary = DesignSystemColor.Dark.Tertiary,
            warning = DesignSystemColor.Dark.Warning,
            alarm = DesignSystemColor.Dark.Alarm,
            success = DesignSystemColor.Dark.Success,
            caution = DesignSystemColor.Dark.Caution,
            disable = DesignSystemColor.Dark.Disable,
            white = DesignSystemColor.Dark.White,
            black = DesignSystemColor.Dark.Black,
            gray600 = DesignSystemColor.Dark.Gray600
        )
    }
}

//internal val LocalDesignSystemColorSet  = compositionLocalOf { getDesignSystemColorSet(ThemeMode.Light) }
//
