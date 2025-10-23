package com.example.core.designSystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.core.designSystem.theme.ColorSet

/**
 * 글씨 색 : gray900
 *
 *
 */
// ------- Light Color -------
val lightGrey50 = Color(0xFFF9FAFB)
val lightGrey100 = Color(0xFFF2F4F6)
val lightGrey200 = Color(0xFFE5E8EB)
val lightGrey300 = Color(0xFFD1D6DB)
val lightGrey400 = Color(0xFFB0B8C1)
val lightGrey500 = Color(0xFF8B95A1)
val lightGrey600 = Color(0xFF6B7684)
val lightGrey700 = Color(0xFF4E5968)
val lightGrey800 = Color(0xFF333D4B)
val lightGrey900 = Color(0xFF191F28)

val lightBlue50 = Color(0xFFE8F3FF)
val lightBlue100 = Color(0xFFC9E2FF)
val lightBlue200 = Color(0xFF90C2FF)
val lightBlue300 = Color(0xFF64A8FF)
val lightBlue400 = Color(0xFF4593FC)
val lightBlue500 = Color(0xFF3182F6)
val lightBlue600 = Color(0xFF2272EB)
val lightBlue700 = Color(0xFF1B64DA)
val lightBlue800 = Color(0xFF1957C2)
val lightBlue900 = Color(0xFF194AA6)

val lightRed50 = Color(0xFFFFEEEE)
val lightRed100 = Color(0xFFFFD4D6)
val lightRed200 = Color(0xFFFEAFB4)
val lightRed300 = Color(0xFFFB8890)
val lightRed400 = Color(0xFFF66570)
val lightRed500 = Color(0xFFF04452)
val lightRed600 = Color(0xFFE42939)
val lightRed700 = Color(0xFFD22030)
val lightRed800 = Color(0xFFBC1B2A)
val lightRed900 = Color(0xFFA51926)

val lightGreyOpacity50 = Color(0x05001733)
val lightGreyOpacity100 = Color(0x0C022047)
val lightGreyOpacity200 = Color(0x19001B37)
val lightGreyOpacity300 = Color(0x2E001D3A)
val lightGreyOpacity400 = Color(0x4F001936)
val lightGreyOpacity500 = Color(0x75031832)
val lightGreyOpacity600 = Color(0x9300132B)
val lightGreyOpacity700 = Color(0xB2031228)
val lightGreyOpacity800 = Color(0xCC000C1E)
val lightGreyOpacity900 = Color(0xE8020913)

val lightOrange50 = Color(0xFFFFF3E0)
val lightOrange100 = Color(0xFFFFE0B0)
val lightOrange200 = Color(0xFFFFCD80)
val lightOrange300 = Color(0xFFFFBD51)
val lightOrange400 = Color(0xFFFFA927)
val lightOrange500 = Color(0xFFFE9800)
val lightOrange600 = Color(0xFFFB8800)
val lightOrange700 = Color(0xFFF57800)
val lightOrange800 = Color(0xFFED6700)
val lightOrange900 = Color(0xFFE45600)

val lightYellow50 = Color(0xFFFFF9E7)
val lightYellow100 = Color(0xFFFFEFBF)
val lightYellow200 = Color(0xFFFFE69B)
val lightYellow300 = Color(0xFFFFDD78)
val lightYellow400 = Color(0xFFFFD158)
val lightYellow500 = Color(0xFFFFC342)
val lightYellow600 = Color(0xFFFFB331)
val lightYellow700 = Color(0xFFFAA131)
val lightYellow800 = Color(0xFFEE8F11)
val lightYellow900 = Color(0xFFDD7D02)

val lightGreen50 = Color(0xFFF0FAF6)
val lightGreen100 = Color(0xFFAEEFD5)
val lightGreen200 = Color(0xFF76E4B8)
val lightGreen300 = Color(0xFF3FD599)
val lightGreen400 = Color(0xFF15C47E)
val lightGreen500 = Color(0xFF03B26C)
val lightGreen600 = Color(0xFF02A262)
val lightGreen700 = Color(0xFF029359)
val lightGreen800 = Color(0xFF028450)
val lightGreen900 = Color(0xFF027648)

val lightTeal50 = Color(0xFFEDF8F8)
val lightTeal100 = Color(0xFFBCE9E9)
val lightTeal200 = Color(0xFF89D8D8)
val lightTeal300 = Color(0xFF58C7C7)
val lightTeal400 = Color(0xFF30B6B6)
val lightTeal500 = Color(0xFF18A5A5)
val lightTeal600 = Color(0xFF109595)
val lightTeal700 = Color(0xFF0C8585)
val lightTeal800 = Color(0xFF097575)
val lightTeal900 = Color(0xFF076565)

val lightPurple50 = Color(0xFFF9F0FC)
val lightPurple100 = Color(0xFFEDCCF8)
val lightPurple200 = Color(0xFFDA9BEF)
val lightPurple300 = Color(0xFFC770E4)
val lightPurple400 = Color(0xFFB44BD7)
val lightPurple500 = Color(0xFFA234C7)
val lightPurple600 = Color(0xFF9128B4)
val lightPurple700 = Color(0xFF8222A2)
val lightPurple800 = Color(0xFF73228E)
val lightPurple900 = Color(0xFF65237B)

val lightBackground = Color(0xFFFFFFFF)
val lightGreyBackground = Color(0xFFF2F4F6)
val lightLayeredBackground = Color(0xFFFFFFFF)
val lightFloatedBackground = Color(0xFFFFFFFF)

// ------- Dark Color -------
val darkGrey50 = Color(0xFFF9FAFB)
val darkGrey100 = Color(0xFFF2F4F6)
val darkGrey200 = Color(0xFFE5E8EB)
val darkGrey300 = Color(0xFFD1D6DB)
val darkGrey400 = Color(0xFFB0B8C1)
val darkGrey500 = Color(0xFF8B95A1)
val darkGrey600 = Color(0xFF6B7684)
val darkGrey700 = Color(0xFF4E5968)
val darkGrey800 = Color(0xFF333D4B)
val darkGrey900 = Color(0xFF191F28)

val darkBlue50 = Color(0xFFE8F3FF)
val darkBlue100 = Color(0xFFC9E2FF)
val darkBlue200 = Color(0xFF90C2FF)
val darkBlue300 = Color(0xFF64A8FF)
val darkBlue400 = Color(0xFF4593FC)
val darkBlue500 = Color(0xFF3182F6)
val darkBlue600 = Color(0xFF2272EB)
val darkBlue700 = Color(0xFF1B64DA)
val darkBlue800 = Color(0xFF1957C2)
val darkBlue900 = Color(0xFF194AA6)

val darkRed50 = Color(0xFFFFEEEE)
val darkRed100 = Color(0xFFFFD4D6)
val darkRed200 = Color(0xFFFEAFB4)
val darkRed300 = Color(0xFFFB8890)
val darkRed400 = Color(0xFFF66570)
val darkRed500 = Color(0xFFF04452)
val darkRed600 = Color(0xFFE42939)
val darkRed700 = Color(0xFFD22030)
val darkRed800 = Color(0xFFBC1B2A)
val darkRed900 = Color(0xFFA51926)

val darkGreyOpacity50 = Color(0x05001733)
val darkGreyOpacity100 = Color(0x0C022047)
val darkGreyOpacity200 = Color(0x19001B37)
val darkGreyOpacity300 = Color(0x2E001D3A)
val darkGreyOpacity400 = Color(0x4F001936)
val darkGreyOpacity500 = Color(0x75031832)
val darkGreyOpacity600 = Color(0x9300132B)
val darkGreyOpacity700 = Color(0xB2031228)
val darkGreyOpacity800 = Color(0xCC000C1E)
val darkGreyOpacity900 = Color(0xE8020913)

val darkOrange50 = Color(0xFFFFF3E0)
val darkOrange100 = Color(0xFFFFE0B0)
val darkOrange200 = Color(0xFFFFCD80)
val darkOrange300 = Color(0xFFFFBD51)
val darkOrange400 = Color(0xFFFFA927)
val darkOrange500 = Color(0xFFFE9800)
val darkOrange600 = Color(0xFFFB8800)
val darkOrange700 = Color(0xFFF57800)
val darkOrange800 = Color(0xFFED6700)
val darkOrange900 = Color(0xFFE45600)

val darkYellow50 = Color(0xFFFFF9E7)
val darkYellow100 = Color(0xFFFFEFBF)
val darkYellow200 = Color(0xFFFFE69B)
val darkYellow300 = Color(0xFFFFDD78)
val darkYellow400 = Color(0xFFFFD158)
val darkYellow500 = Color(0xFFFFC342)
val darkYellow600 = Color(0xFFFFB331)
val darkYellow700 = Color(0xFFFAA131)
val darkYellow800 = Color(0xFFEE8F11)
val darkYellow900 = Color(0xFFDD7D02)

val darkGreen50 = Color(0xFFF0FAF6)
val darkGreen100 = Color(0xFFAEEFD5)
val darkGreen200 = Color(0xFF76E4B8)
val darkGreen300 = Color(0xFF3FD599)
val darkGreen400 = Color(0xFF15C47E)
val darkGreen500 = Color(0xFF03B26C)
val darkGreen600 = Color(0xFF02A262)
val darkGreen700 = Color(0xFF029359)
val darkGreen800 = Color(0xFF028450)
val darkGreen900 = Color(0xFF027648)

val darkTeal50 = Color(0xFFEDF8F8)
val darkTeal100 = Color(0xFFBCE9E9)
val darkTeal200 = Color(0xFF89D8D8)
val darkTeal300 = Color(0xFF58C7C7)
val darkTeal400 = Color(0xFF30B6B6)
val darkTeal500 = Color(0xFF18A5A5)
val darkTeal600 = Color(0xFF109595)
val darkTeal700 = Color(0xFF0C8585)
val darkTeal800 = Color(0xFF097575)
val darkTeal900 = Color(0xFF076565)

val darkPurple50 = Color(0xFFF9F0FC)
val darkPurple100 = Color(0xFFEDCCF8)
val darkPurple200 = Color(0xFFDA9BEF)
val darkPurple300 = Color(0xFFC770E4)
val darkPurple400 = Color(0xFFB44BD7)
val darkPurple500 = Color(0xFFA234C7)
val darkPurple600 = Color(0xFF9128B4)
val darkPurple700 = Color(0xFF8222A2)
val darkPurple800 = Color(0xFF73228E)
val darkPurple900 = Color(0xFF65237B)

val darkBackground = Color(0xFFFFFFFF)
val darkGreyBackground = Color(0xFFF2F4F6)
val darkLayeredBackground = Color(0xFFFFFFFF)
val darkFloatedBackground = Color(0xFFFFFFFF)

val white = Color(0xFFFFFFFF)

@Immutable
data class ColorSet(
    val mainBackgroundColor: Color,
    val mainFontColor: Color,
    val subBackgroundColor: Color,
    val subFontColor: Color
)

@Immutable
data class TextColorSet(
    val mainColor: Color,
    val subColor: Color
)

@Immutable
data class BackgroundColorSet(
    val background: Color,
    val loading: Color,
    val loadingBackground: Color
)

@Immutable
data class DesignSystemColor(
    val grey: ColorSet,
    val blue: ColorSet,
    val red: ColorSet,
    val orange: ColorSet,
    val yellow: ColorSet,
    val green: ColorSet,
    val teal: ColorSet,
    val purple: ColorSet,
    val textColor: TextColorSet,
    val buttonLoader: Color,
    val background: BackgroundColorSet
)

@Immutable
object DesignSystemColorSet {
    val LightColor = DesignSystemColor(
        grey = ColorSet(
            mainBackgroundColor = lightGrey700,
            mainFontColor = white,
            subBackgroundColor = lightGreyOpacity100,
            subFontColor = lightGreyOpacity600
        ),
        blue = ColorSet(
            mainBackgroundColor = lightBlue500,
            mainFontColor = white,
            subBackgroundColor = lightBlue100,
            subFontColor = lightBlue600
        ),
        red = ColorSet(
            mainBackgroundColor = lightRed500,
            mainFontColor = white,
            subBackgroundColor = lightRed100,
            subFontColor = lightRed600
        ),
        orange = ColorSet(
            mainBackgroundColor = lightOrange500,
            mainFontColor = white,
            subBackgroundColor = lightOrange100,
            subFontColor = lightOrange600
        ),
        yellow = ColorSet(
            mainBackgroundColor = lightYellow500,
            mainFontColor = white,
            subBackgroundColor = lightYellow100,
            subFontColor = lightYellow600
        ),
        green = ColorSet(
            mainBackgroundColor = lightGreen500,
            mainFontColor = white,
            subBackgroundColor = lightGreen100,
            subFontColor = lightGreen600
        ),
        teal = ColorSet(
            mainBackgroundColor = lightTeal500,
            mainFontColor = white,
            subBackgroundColor = lightTeal100,
            subFontColor = lightTeal600
        ),
        purple = ColorSet(
            mainBackgroundColor = lightPurple500,
            mainFontColor = white,
            subBackgroundColor = lightPurple100,
            subFontColor = lightPurple600
        ),
        textColor = TextColorSet(
            mainColor = lightGreyOpacity800,
            subColor = lightGrey600
        ),
        buttonLoader = white,
        background = BackgroundColorSet(
            background = lightBackground,
            loading = lightBlue500,
            loadingBackground = lightGreyOpacity900
        )
    )

    val DarkColor = DesignSystemColor(
        grey = ColorSet(
            mainBackgroundColor = darkGrey700,
            mainFontColor = white,
            subBackgroundColor = darkGreyOpacity100,
            subFontColor = darkGreyOpacity600
        ),
        blue = ColorSet(
            mainBackgroundColor = darkBlue500,
            mainFontColor = white,
            subBackgroundColor = darkBlue100,
            subFontColor = darkBlue600
        ),
        red = ColorSet(
            mainBackgroundColor = darkRed500,
            mainFontColor = white,
            subBackgroundColor = darkRed100,
            subFontColor = darkRed600
        ),
        orange = ColorSet(
            mainBackgroundColor = darkOrange500,
            mainFontColor = white,
            subBackgroundColor = darkOrange100,
            subFontColor = darkOrange600
        ),
        yellow = ColorSet(
            mainBackgroundColor = darkYellow500,
            mainFontColor = white,
            subBackgroundColor = darkYellow100,
            subFontColor = darkYellow600
        ),
        green = ColorSet(
            mainBackgroundColor = darkGreen500,
            mainFontColor = white,
            subBackgroundColor = darkGreen100,
            subFontColor = darkGreen600
        ),
        teal = ColorSet(
            mainBackgroundColor = darkTeal500,
            mainFontColor = white,
            subBackgroundColor = darkTeal100,
            subFontColor = darkTeal600
        ),
        purple = ColorSet(
            mainBackgroundColor = darkPurple500,
            mainFontColor = white,
            subBackgroundColor = darkPurple100,
            subFontColor = darkPurple600
        ),
        textColor = TextColorSet(
            mainColor = darkGreyOpacity800,
            subColor = darkGrey600
        ),
        buttonLoader = white,
        background = BackgroundColorSet(
            background = darkBackground,
            loading = darkBlue500,
            loadingBackground = darkGreyOpacity900
        )
    )
}


val LocalColor: ProvidableCompositionLocal<DesignSystemColor> = staticCompositionLocalOf {
    error("LocalColor not provided")
}