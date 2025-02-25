package com.example.presentation.theme

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

object DesignSystemColors{
    object Light {
        val Primary = DesignSystemColorSet(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFFC9E6FD),
            outline = Color(0xFFECF5FD)
        )
        val Secondary = DesignSystemColorSet(
            fontColor = Color(0xFF00C200),
            background = Color(0xFFA4F29F),
            outline = Color(0xFFE3FAE1)
        )
        val Tertiary = DesignSystemColorSet(
            fontColor = Color(0xFF6A1B9A),
            background = Color(0xFFF1C6FF),
            outline = Color(0xFFEEA9D3)
        )
        val Warning = DesignSystemColorSet(
            fontColor = Color(0xFFED2B2A),
            background = Color(0xFFFDD8D9),
            outline = Color(0xFFFDF3F3)
        )
        val Alarm = DesignSystemColorSet(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFFC9E6FD),
            outline = Color(0xFFECF5FD)
        )
        val Success = DesignSystemColorSet(
            fontColor = Color(0xFF00C200),
            background = Color(0xFFA4F29F),
            outline = Color(0xFFE3FAE1)
        )
        val Caution = DesignSystemColorSet(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFFBF6C9),
            outline = Color(0xFFFDFAE3)
        )
        val Disable = DesignSystemColorSet(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFFBF6C9),
            outline = Color(0xFFFDFAE3)
        )
        val white = Color(0xFFFFFFFF)
        val black = Color(0xFF000000)
        val gray600 = Color(0xFF757575)
    }
    object Dark {
        val Primary = DesignSystemColorSet(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFF2B3E9B),
            outline = Color(0xFF3A5E9F)
        )
        val Secondary = DesignSystemColorSet(
            fontColor = Color(0xFF00C200),
            background = Color(0xFF307D32),
            outline = Color(0xFF4E9F4E)
        )
        val Tertiary = DesignSystemColorSet(
            fontColor = Color(0xFF6A1B9A),
            background = Color(0xFF9C4F9A),
            outline = Color(0xFF6F3072)
        )
        val Warning = DesignSystemColorSet(
            fontColor = Color(0xFFED2B2A),
            background = Color(0xFF9B5D5D),
            outline = Color(0xFF9F4C4C)
        )
        val Alarm = DesignSystemColorSet(
            fontColor = Color(0xFF067CFB),
            background = Color(0xFF2B3E9B),
            outline = Color(0xFF3A5E9F)
        )
        val Success = DesignSystemColorSet(
            fontColor = Color(0xFF00C200),
            background = Color(0xFF307D32),
            outline = Color(0xFF4E9F4E)
        )
        val Caution = DesignSystemColorSet(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFAB8A2A),
            outline = Color(0xFFB69F59)
        )
        val Disable = DesignSystemColorSet(
            fontColor = Color(0xFFFDD000),
            background = Color(0xFFAB8A2A),
            outline = Color(0xFFB69F59)
        )
        val white = Color(0xFFFFFFFF)
        val black = Color(0xFF000000)
        val gray600 = Color(0xFF757575)
    }
}

@Stable
class DesignSystemColor(
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
    val gray600: Color
)

val LocalDesignSystemColor = staticCompositionLocalOf {
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
        gray600 = Color.Unspecified
    )
}