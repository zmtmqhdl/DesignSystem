package com.example.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object DesignSystemSingleColor {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    val Gray600 = Color(0xFF757575)
}

sealed class DesignSystemColor {

    abstract val fontColor: Color
    abstract val background: Color
    abstract val outline: Color

    private fun themeColor(light: Color, dark: Color): Color {
        return if (isDarkTheme()) dark else light
    }

    data object Primary : DesignSystemColor() {
        override val fontColor get() = themeColor(Color(0xFF067CFB),Color(0xFF067CFB) )
        override val background = Color(0xFFC9E6FD)
        override val outline = Color(0xFFECF5FD)
    }

    data object Secondary : DesignSystemColor() {
        override val fontColor = Color(0xFF00C200)
        override val background = Color(0xFFA4F29F)
        override val outline = Color(0xFFE3FAE1)
    }

    data object Tertiary : DesignSystemColor() {
        override val fontColor = Color(0xFF6A1B9A)
        override val background = Color(0xFFF1C6FF)
        override val outline = Color(0xFFEEA9D3)
    }

    data object Warning : DesignSystemColor() {
        override val fontColor = Color(0xFFED2B2A)
        override val background = Color(0xFFFDD8D9)
        override val outline = Color(0xFFFDF3F3)
    }

    data object Alarm : DesignSystemColor() {
        override val fontColor = Color(0xFF067CFB)
        override val background = Color(0xFFC9E6FD)
        override val outline = Color(0xFFECF5FD)
    }

    data object Success : DesignSystemColor() {
        override val fontColor = Color(0xFF00C200)
        override val background = Color(0xFFA4F29F)
        override val outline = Color(0xFFE3FAE1)
    }

    data object Caution : DesignSystemColor() {
        override val fontColor = Color(0xFFFDD000)
        override val background = Color(0xFFFBF6C9)
        override val outline = Color(0xFFFDFAE3)
    }

    data object Disable : DesignSystemColor() {
        override val fontColor = Color(0xFFFDD000)
        override val background = Color(0xFFFBF6C9)
        override val outline = Color(0xFFFDFAE3)
    }
}

@Immutable
data class ColorSet(


    val material: ColorScheme,
    val background: Color,
    val white: Color = White,
    val primary100: Color,
    val primary30: Color,
    val primary10: Color,
    val primary5: Color,
    val accent100: Color,
    val accent10: Color,
    val orange50: Color,
    val yellow50: Color,
    val gray90: Color,
    val gray80: Color,
    val gray70: Color,
    val gray60: Color,
    val gray50: Color,
    val gray40: Color,
    val gray30: Color,
    val gray20: Color,
    val gray10: Color,
    val profile: Color,
    val bgElevated: Color,
    val dividerLine: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textInfo: Color,
    val textDisabled: Color,
    val iconDefault: Color,
    val iconSecondary: Color,
    val iconDisabled: Color,
    val textFieldDefault: Color,
    val textFieldDisabled: Color,
    val textFieldBtnBase: Color,
    val textFieldBtnText: Color,
)
//
//internal val lightColorSet = ColorSet(
//    material = lightColorScheme(),
//    background = Background,
//    primary100 = Primary100,
//    primary30 = Primary30,
//    primary10 = Primary10,
//    primary5 = Primary05,
//    accent100 = Accent,
//    accent10 = AccentToast,
//    orange50 = Noti,
//    yellow50 = Favorite,
//    gray90 = Gray90,
//    gray80 = Gray80,
//    gray70 = Gray70,
//    gray60 = Gray60,
//    gray50 = Gray50,
//    gray40 = Gray40,
//    gray30 = Gray30,
//    gray20 = Gray20,
//    gray10 = Gray10,
//    profile = Profile,
//    bgElevated = White,
//    dividerLine = Gray10,
//    textPrimary = Gray90,
//    textSecondary = Gray60,
//    textInfo = Gray50,
//    textDisabled = Gray40,
//    iconDefault = Gray60,
//    iconSecondary = Gray50,
//    iconDisabled = Gray40,
//    textFieldDefault = White,
//    textFieldDisabled = Gray10,
//    textFieldBtnBase = Gray20,
//    textFieldBtnText = White
//)
//
//internal val darkColorSet = ColorSet(
//    material = darkColorScheme(),
//    background = BackgroundDark,
//    primary100 = Primary100Dark,
//    primary30 = PrimaryLightDark,
//    primary10 = PrimaryBaseDark,
//    primary5 = PrimaryToastDark,
//    accent100 = AccentDark,
//    accent10 = AccentToastDark,
//    orange50 = NotiDark,
//    yellow50 = FavoriteDark,
//    gray90 = Gray90Dark,
//    gray80 = Gray80Dark,
//    gray70 = Gray70Dark,
//    gray60 = Gray60Dark,
//    gray50 = Gray50Dark,
//    gray40 = Gray40Dark,
//    gray30 = Gray30Dark,
//    gray20 = Gray20Dark,
//    gray10 = Gray10Dark,
//    profile = ProfileDark,
//    bgElevated = Gray10Dark,
//    dividerLine = Gray20Dark,
//    textPrimary = Gray80Dark,
//    textSecondary = Gray60Dark,
//    textInfo = Gray50Dark,
//    textDisabled = Gray40Dark,
//    iconDefault = Gray60Dark,
//    iconSecondary = Gray50Dark,
//    iconDisabled = Gray40Dark,
//    textFieldDefault = Gray30Dark,
//    textFieldDisabled = Gray20Dark,
//    textFieldBtnBase = Gray40Dark,
//    textFieldBtnText = Gray50Dark
//)
//
//internal val LocalColorSet = androidx.compose.runtime.compositionLocalOf { lightColorSet }

