package com.example.core.designSystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class DesignSystemColor(
    // Grey
    val grey50: Color,
    val grey100: Color,
    val grey200: Color,
    val grey300: Color,
    val grey400: Color,
    val grey500: Color,
    val grey600: Color,
    val grey700: Color,
    val grey800: Color,
    val grey900: Color,

    // Blue
    val blue50: Color,
    val blue100: Color,
    val blue200: Color,
    val blue300: Color,
    val blue400: Color,
    val blue500: Color,
    val blue600: Color,
    val blue700: Color,
    val blue800: Color,
    val blue900: Color,

    // Red
    val red50: Color,
    val red100: Color,
    val red200: Color,
    val red300: Color,
    val red400: Color,
    val red500: Color,
    val red600: Color,
    val red700: Color,
    val red800: Color,
    val red900: Color,

    // GrayOpacity
    val greyOpacity50: Color,
    val greyOpacity100: Color,
    val greyOpacity200: Color,
    val greyOpacity300: Color,
    val greyOpacity400: Color,
    val greyOpacity500: Color,
    val greyOpacity600: Color,
    val greyOpacity700: Color,
    val greyOpacity800: Color,
    val greyOpacity900: Color,

    // Orange
    val orange50: Color,
    val orange100: Color,
    val orange200: Color,
    val orange300: Color,
    val orange400: Color,
    val orange500: Color,
    val orange600: Color,
    val orange700: Color,
    val orange800: Color,
    val orange900: Color,

    // Yellow
    val yellow50: Color,
    val yellow100: Color,
    val yellow200: Color,
    val yellow300: Color,
    val yellow400: Color,
    val yellow500: Color,
    val yellow600: Color,
    val yellow700: Color,
    val yellow800: Color,
    val yellow900: Color,

    // Green
    val green50: Color,
    val green100: Color,
    val green200: Color,
    val green300: Color,
    val green400: Color,
    val green500: Color,
    val green600: Color,
    val green700: Color,
    val green800: Color,
    val green900: Color,

    // Teal
    val teal50: Color,
    val teal100: Color,
    val teal200: Color,
    val teal300: Color,
    val teal400: Color,
    val teal500: Color,
    val teal600: Color,
    val teal700: Color,
    val teal800: Color,
    val teal900: Color,

    // Purple
    val purple50: Color,
    val purple100: Color,
    val purple200: Color,
    val purple300: Color,
    val purple400: Color,
    val purple500: Color,
    val purple600: Color,
    val purple700: Color,
    val purple800: Color,
    val purple900: Color,

    // Background
    val background: Color,
    val greyBackground: Color,
    val layeredBackground: Color,
    val floatedBackground: Color
)

object DesignSystemColorSet {
    val LightColor = DesignSystemColor(
        // Grey
        grey50 = Color(0xFFF9FAFB),
        grey100 = Color(0xFFF2F4F6),
        grey200 = Color(0xFFE5E8EB),
        grey300 = Color(0xFFD1D6DB),
        grey400 = Color(0xFFB0B8C1),
        grey500 = Color(0xFF8B95A1),
        grey600 = Color(0xFF6B7684),
        grey700 = Color(0xFF4E5968),
        grey800 = Color(0xFF333D4B),
        grey900 = Color(0xFF191F28),

        // Blue
        blue50 = Color(0xFFE8F3FF),
        blue100 = Color(0xFFC9E2FF),
        blue200 = Color(0xFF90C2FF),
        blue300 = Color(0xFF64A8FF),
        blue400 = Color(0xFF4593FC),
        blue500 = Color(0xFF3182F6),
        blue600 = Color(0xFF2272EB),
        blue700 = Color(0xFF1B64DA),
        blue800 = Color(0xFF1957C2),
        blue900 = Color(0xFF194AA6),

        // Red
        red50 = Color(0xFFFFEEEE),
        red100 = Color(0xFFFFD4D6),
        red200 = Color(0xFFFEAFB4),
        red300 = Color(0xFFFB8890),
        red400 = Color(0xFFF66570),
        red500 = Color(0xFFF04452),
        red600 = Color(0xFFE42939),
        red700 = Color(0xFFD22030),
        red800 = Color(0xFFBC1B2A),
        red900 = Color(0xFFA51926),

        // Grey Opacity
        greyOpacity50 = Color(0x05001733),
        greyOpacity100 = Color(0x0C022047),
        greyOpacity200 = Color(0x19001B37),
        greyOpacity300 = Color(0x2E001D3A),
        greyOpacity400 = Color(0x4F001936),
        greyOpacity500 = Color(0x75031832),
        greyOpacity600 = Color(0x9300132B),
        greyOpacity700 = Color(0xB2031228),
        greyOpacity800 = Color(0xCC000C1E),
        greyOpacity900 = Color(0xE8020913),

        // Orange
        orange50 = Color(0xFFFFF3E0),
        orange100 = Color(0xFFFFE0B0),
        orange200 = Color(0xFFFFCD80),
        orange300 = Color(0xFFFFBD51),
        orange400 = Color(0xFFFFA927),
        orange500 = Color(0xFFFE9800),
        orange600 = Color(0xFFFB8800),
        orange700 = Color(0xFFF57800),
        orange800 = Color(0xFFED6700),
        orange900 = Color(0xFFE45600),

        // Yellow
        yellow50 = Color(0xFFFFF9E7),
        yellow100 = Color(0xFFFFEFBF),
        yellow200 = Color(0xFFFFE69B),
        yellow300 = Color(0xFFFFDD78),
        yellow400 = Color(0xFFFFD158),
        yellow500 = Color(0xFFFFC342),
        yellow600 = Color(0xFFFFB331),
        yellow700 = Color(0xFFFAA131),
        yellow800 = Color(0xFFEE8F11),
        yellow900 = Color(0xFFDD7D02),

        // Green
        green50 = Color(0xFFF0FAF6),
        green100 = Color(0xFFAEEFD5),
        green200 = Color(0xFF76E4B8),
        green300 = Color(0xFF3FD599),
        green400 = Color(0xFF15C47E),
        green500 = Color(0xFF03B26C),
        green600 = Color(0xFF02A262),
        green700 = Color(0xFF029359),
        green800 = Color(0xFF028450),
        green900 = Color(0xFF027648),

        // Teal
        teal50 = Color(0xFFEDF8F8),
        teal100 = Color(0xFFBCE9E9),
        teal200 = Color(0xFF89D8D8),
        teal300 = Color(0xFF58C7C7),
        teal400 = Color(0xFF30B6B6),
        teal500 = Color(0xFF18A5A5),
        teal600 = Color(0xFF109595),
        teal700 = Color(0xFF0C8585),
        teal800 = Color(0xFF097575),
        teal900 = Color(0xFF076565),

        // Purple
        purple50 = Color(0xFFF9F0FC),
        purple100 = Color(0xFFEDCCF8),
        purple200 = Color(0xFFDA9BEF),
        purple300 = Color(0xFFC770E4),
        purple400 = Color(0xFFB44BD7),
        purple500 = Color(0xFFA234C7),
        purple600 = Color(0xFF9128B4),
        purple700 = Color(0xFF8222A2),
        purple800 = Color(0xFF73228E),
        purple900 = Color(0xFF65237B),

        // Background
        background = Color(0xFFFFFFFF),
        greyBackground = Color(0xFFF2F4F6),
        layeredBackground = Color(0xFFFFFFFF),
        floatedBackground = Color(0xFFFFFFFF)
    )

    val DarkColor = DesignSystemColor(
        // Grey
        grey50 = Color(0xFFF9FAFB),
        grey100 = Color(0xFFF2F4F6),
        grey200 = Color(0xFFE5E8EB),
        grey300 = Color(0xFFD1D6DB),
        grey400 = Color(0xFFB0B8C1),
        grey500 = Color(0xFF8B95A1),
        grey600 = Color(0xFF6B7684),
        grey700 = Color(0xFF4E5968),
        grey800 = Color(0xFF333D4B),
        grey900 = Color(0xFF191F28),

        // Blue
        blue50 = Color(0xFFE8F3FF),
        blue100 = Color(0xFFC9E2FF),
        blue200 = Color(0xFF90C2FF),
        blue300 = Color(0xFF64A8FF),
        blue400 = Color(0xFF4593FC),
        blue500 = Color(0xFF3182F6),
        blue600 = Color(0xFF2272EB),
        blue700 = Color(0xFF1B64DA),
        blue800 = Color(0xFF1957C2),
        blue900 = Color(0xFF194AA6),

        // Red
        red50 = Color(0xFFFFEEEE),
        red100 = Color(0xFFFFD4D6),
        red200 = Color(0xFFFEAFB4),
        red300 = Color(0xFFFB8890),
        red400 = Color(0xFFF66570),
        red500 = Color(0xFFF04452),
        red600 = Color(0xFFE42939),
        red700 = Color(0xFFD22030),
        red800 = Color(0xFFBC1B2A),
        red900 = Color(0xFFA51926),

        // Grey Opacity
        greyOpacity50 = Color(0x05001733),
        greyOpacity100 = Color(0x0C022047),
        greyOpacity200 = Color(0x19001B37),
        greyOpacity300 = Color(0x2E001D3A),
        greyOpacity400 = Color(0x4F001936),
        greyOpacity500 = Color(0x75031832),
        greyOpacity600 = Color(0x9300132B),
        greyOpacity700 = Color(0xB2031228),
        greyOpacity800 = Color(0xCC000C1E),
        greyOpacity900 = Color(0xE8020913),

        // Orange
        orange50 = Color(0xFFFFF3E0),
        orange100 = Color(0xFFFFE0B0),
        orange200 = Color(0xFFFFCD80),
        orange300 = Color(0xFFFFBD51),
        orange400 = Color(0xFFFFA927),
        orange500 = Color(0xFFFE9800),
        orange600 = Color(0xFFFB8800),
        orange700 = Color(0xFFF57800),
        orange800 = Color(0xFFED6700),
        orange900 = Color(0xFFE45600),

        // Yellow
        yellow50 = Color(0xFFFFF9E7),
        yellow100 = Color(0xFFFFEFBF),
        yellow200 = Color(0xFFFFE69B),
        yellow300 = Color(0xFFFFDD78),
        yellow400 = Color(0xFFFFD158),
        yellow500 = Color(0xFFFFC342),
        yellow600 = Color(0xFFFFB331),
        yellow700 = Color(0xFFFAA131),
        yellow800 = Color(0xFFEE8F11),
        yellow900 = Color(0xFFDD7D02),

        // Green
        green50 = Color(0xFFF0FAF6),
        green100 = Color(0xFFAEEFD5),
        green200 = Color(0xFF76E4B8),
        green300 = Color(0xFF3FD599),
        green400 = Color(0xFF15C47E),
        green500 = Color(0xFF03B26C),
        green600 = Color(0xFF02A262),
        green700 = Color(0xFF029359),
        green800 = Color(0xFF028450),
        green900 = Color(0xFF027648),

        // Teal
        teal50 = Color(0xFFEDF8F8),
        teal100 = Color(0xFFBCE9E9),
        teal200 = Color(0xFF89D8D8),
        teal300 = Color(0xFF58C7C7),
        teal400 = Color(0xFF30B6B6),
        teal500 = Color(0xFF18A5A5),
        teal600 = Color(0xFF109595),
        teal700 = Color(0xFF0C8585),
        teal800 = Color(0xFF097575),
        teal900 = Color(0xFF076565),

        // Purple
        purple50 = Color(0xFFF9F0FC),
        purple100 = Color(0xFFEDCCF8),
        purple200 = Color(0xFFDA9BEF),
        purple300 = Color(0xFFC770E4),
        purple400 = Color(0xFFB44BD7),
        purple500 = Color(0xFFA234C7),
        purple600 = Color(0xFF9128B4),
        purple700 = Color(0xFF8222A2),
        purple800 = Color(0xFF73228E),
        purple900 = Color(0xFF65237B),

        // Background
        background = Color(0xFFFFFFFF),
        greyBackground = Color(0xFFF2F4F6),
        layeredBackground = Color(0xFFFFFFFF),
        floatedBackground = Color(0xFFFFFFFF)
    )
}


val LocalColor = staticCompositionLocalOf {
    DesignSystemColor(
        // Grey
        grey50 = Color.Unspecified,
        grey100 = Color.Unspecified,
        grey200 = Color.Unspecified,
        grey300 = Color.Unspecified,
        grey400 = Color.Unspecified,
        grey500 = Color.Unspecified,
        grey600 = Color.Unspecified,
        grey700 = Color.Unspecified,
        grey800 = Color.Unspecified,
        grey900 = Color.Unspecified,

        // Blue
        blue50 = Color.Unspecified,
        blue100 = Color.Unspecified,
        blue200 = Color.Unspecified,
        blue300 = Color.Unspecified,
        blue400 = Color.Unspecified,
        blue500 = Color.Unspecified,
        blue600 = Color.Unspecified,
        blue700 = Color.Unspecified,
        blue800 = Color.Unspecified,
        blue900 = Color.Unspecified,

        // Red
        red50 = Color.Unspecified,
        red100 = Color.Unspecified,
        red200 = Color.Unspecified,
        red300 = Color.Unspecified,
        red400 = Color.Unspecified,
        red500 = Color.Unspecified,
        red600 = Color.Unspecified,
        red700 = Color.Unspecified,
        red800 = Color.Unspecified,
        red900 = Color.Unspecified,

        // Grey Opacity
        greyOpacity50 = Color.Unspecified,
        greyOpacity100 = Color.Unspecified,
        greyOpacity200 = Color.Unspecified,
        greyOpacity300 = Color.Unspecified,
        greyOpacity400 = Color.Unspecified,
        greyOpacity500 = Color.Unspecified,
        greyOpacity600 = Color.Unspecified,
        greyOpacity700 = Color.Unspecified,
        greyOpacity800 = Color.Unspecified,
        greyOpacity900 = Color.Unspecified,

        // Orange
        orange50 = Color.Unspecified,
        orange100 = Color.Unspecified,
        orange200 = Color.Unspecified,
        orange300 = Color.Unspecified,
        orange400 = Color.Unspecified,
        orange500 = Color.Unspecified,
        orange600 = Color.Unspecified,
        orange700 = Color.Unspecified,
        orange800 = Color.Unspecified,
        orange900 = Color.Unspecified,

        // Yellow
        yellow50 = Color.Unspecified,
        yellow100 = Color.Unspecified,
        yellow200 = Color.Unspecified,
        yellow300 = Color.Unspecified,
        yellow400 = Color.Unspecified,
        yellow500 = Color.Unspecified,
        yellow600 = Color.Unspecified,
        yellow700 = Color.Unspecified,
        yellow800 = Color.Unspecified,
        yellow900 = Color.Unspecified,

        // Green
        green50 = Color.Unspecified,
        green100 = Color.Unspecified,
        green200 = Color.Unspecified,
        green300 = Color.Unspecified,
        green400 = Color.Unspecified,
        green500 = Color.Unspecified,
        green600 = Color.Unspecified,
        green700 = Color.Unspecified,
        green800 = Color.Unspecified,
        green900 = Color.Unspecified,

        // Teal
        teal50 = Color.Unspecified,
        teal100 = Color.Unspecified,
        teal200 = Color.Unspecified,
        teal300 = Color.Unspecified,
        teal400 = Color.Unspecified,
        teal500 = Color.Unspecified,
        teal600 = Color.Unspecified,
        teal700 = Color.Unspecified,
        teal800 = Color.Unspecified,
        teal900 = Color.Unspecified,

        // Purple
        purple50 = Color.Unspecified,
        purple100 = Color.Unspecified,
        purple200 = Color.Unspecified,
        purple300 = Color.Unspecified,
        purple400 = Color.Unspecified,
        purple500 = Color.Unspecified,
        purple600 = Color.Unspecified,
        purple700 = Color.Unspecified,
        purple800 = Color.Unspecified,
        purple900 = Color.Unspecified,

        // Background
        background = Color.Unspecified,
        greyBackground = Color.Unspecified,
        layeredBackground = Color.Unspecified,
        floatedBackground = Color.Unspecified
    )
}