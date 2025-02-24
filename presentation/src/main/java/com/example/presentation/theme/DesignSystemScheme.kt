package com.example.presentation.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//sealed class ThemeMode {
//    data object Light : ThemeMode()
//    data object Dark : ThemeMode()
//}

//data class DesignSystemColorSetValues(
//    val fontColor: Color,
//    val background: Color,
//    val outline: Color
//)

object DesignSystemColor{
    object Light {
        object Primary {
            val fontColor = Color(0xFF067CFB)
            val background = Color(0xFFC9E6FD)
            val outline = Color(0xFFECF5FD)
        }
        object Secondary {
            val fontColor = Color(0xFF00C200)
            val background = Color(0xFFA4F29F)
            val outline = Color(0xFFE3FAE1)
        }
        object Tertiary {
            val fontColor = Color(0xFF6A1B9A)
            val background = Color(0xFFF1C6FF)
            val outline = Color(0xFFEEA9D3)
        }
        object Warning {
            val fontColor = Color(0xFFED2B2A)
            val background = Color(0xFFFDD8D9)
            val outline = Color(0xFFFDF3F3)
        }
        object Alarm {
            val fontColor = Color(0xFF067CFB)
            val background = Color(0xFFC9E6FD)
            val outline = Color(0xFFECF5FD)
        }
        object Success {
            val fontColor = Color(0xFF00C200)
            val background = Color(0xFFA4F29F)
            val outline = Color(0xFFE3FAE1)
        }
        object Caution {
            val fontColor = Color(0xFFFDD000)
            val background = Color(0xFFFBF6C9)
            val outline = Color(0xFFFDFAE3)
        }
        object Disable {
            val fontColor = Color(0xFFFDD000)
            val background = Color(0xFFFBF6C9)
            val outline = Color(0xFFFDFAE3)
        }
        object Single {
            val white = Color(0xFFFFFFFF)
            val black = Color(0xFF000000)
            val gray600 = Color(0xFF757575)
        }
    }
    object Dark {
        object Primary {
            val fontColor = Color(0xFF067CFB)
            val background = Color(0xFF2B3E9B)
            val outline = Color(0xFF3A5E9F)
        }
        object Secondary {
            val fontColor = Color(0xFF00C200)
            val background = Color(0xFF307D32)
            val outline = Color(0xFF4E9F4E)
        }
        object Tertiary {
            val fontColor = Color(0xFF6A1B9A)
            val background = Color(0xFF9C4F9A)
            val outline = Color(0xFF6F3072)
        }
        object Warning {
            val fontColor = Color(0xFFED2B2A)
            val background = Color(0xFF9B5D5D)
            val outline = Color(0xFF9F4C4C)
        }
        object Alarm {
            val fontColor = Color(0xFF067CFB)
            val background = Color(0xFF2B3E9B)
            val outline = Color(0xFF3A5E9F)
        }
        object Success {
            val fontColor = Color(0xFF00C200)
            val background = Color(0xFF307D32)
            val outline = Color(0xFF4E9F4E)
        }
        object Caution {
            val fontColor = Color(0xFFFDD000)
            val background = Color(0xFFAB8A2A)
            val outline = Color(0xFFB69F59)
        }
        object Disable {
            val fontColor = Color(0xFFFDD000)
            val background = Color(0xFFAB8A2A)
            val outline = Color(0xFFB69F59)
        }
        object Single {
            val white = Color(0xFFFFFFFF)
            val black = Color(0xFF000000)
            val gray600 = Color(0xFF757575)
        }
    }
}

@Stable
class DesignSystemScheme(
    primaryFontColor: Color,
    primaryBackground: Color,
    primaryOutline: Color,
    secondaryFontColor: Color,
    secondaryBackground: Color,
    secondaryOutline: Color,
    tertiaryFontColor: Color,
    tertiaryBackground: Color,
    tertiaryOutline: Color,
    warningFontColor: Color,
    warningBackground: Color,
    warningOutline: Color,
    alarmFontColor: Color,
    alarmBackground: Color,
    alarmOutline: Color,
    successFontColor: Color,
    successBackground: Color,
    successOutline: Color,
    cautionFontColor: Color,
    cautionBackground: Color,
    cautionOutline: Color,
    disableFontColor: Color,
    disableBackground: Color,
    disableOutline: Color,
    white: Color,
    black: Color,
    gray600: Color
)

val LocalDesignSystemScheme = staticCompositionLocalOf {
    DesignSystemScheme(
        primaryFontColor = Color.Unspecified,
        primaryBackground = Color.Unspecified,
        primaryOutline = Color.Unspecified,
        secondaryFontColor = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        secondaryOutline = Color.Unspecified,
        tertiaryFontColor = Color.Unspecified,
        tertiaryBackground = Color.Unspecified,
        tertiaryOutline = Color.Unspecified,
        warningFontColor = Color.Unspecified,
        warningBackground = Color.Unspecified,
        warningOutline = Color.Unspecified,
        alarmFontColor = Color.Unspecified,
        alarmBackground = Color.Unspecified,
        alarmOutline = Color.Unspecified,
        successFontColor = Color.Unspecified,
        successBackground = Color.Unspecified,
        successOutline = Color.Unspecified,
        cautionFontColor = Color.Unspecified,
        cautionBackground = Color.Unspecified,
        cautionOutline = Color.Unspecified,
        disableFontColor = Color.Unspecified,
        disableBackground = Color.Unspecified,
        disableOutline = Color.Unspecified,
        white = Color.Unspecified,
        black = Color.Unspecified,
        gray600 = Color.Unspecified
    )
}