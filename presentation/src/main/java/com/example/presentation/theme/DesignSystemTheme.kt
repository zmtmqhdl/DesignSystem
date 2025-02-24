package com.example.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val lightScheme = DesignSystemScheme(
    primaryFontColor = DesignSystemColor.Light.Primary.fontColor,
    primaryBackground = DesignSystemColor.Light.Primary.background,
    primaryOutline = DesignSystemColor.Light.Primary.outline,
    secondaryFontColor = DesignSystemColor.Light.Secondary.fontColor,
    secondaryBackground = DesignSystemColor.Light.Secondary.background,
    secondaryOutline = DesignSystemColor.Light.Secondary.outline,
    tertiaryFontColor = DesignSystemColor.Light.Tertiary.fontColor,
    tertiaryBackground = DesignSystemColor.Light.Tertiary.background,
    tertiaryOutline = DesignSystemColor.Light.Tertiary.outline,
    warningFontColor = DesignSystemColor.Light.Warning.fontColor,
    warningBackground = DesignSystemColor.Light.Warning.background,
    warningOutline = DesignSystemColor.Light.Warning.outline,
    alarmFontColor = DesignSystemColor.Light.Alarm.fontColor,
    alarmBackground = DesignSystemColor.Light.Alarm.background,
    alarmOutline = DesignSystemColor.Light.Alarm.outline,
    successFontColor = DesignSystemColor.Light.Success.fontColor,
    successBackground = DesignSystemColor.Light.Success.background,
    successOutline = DesignSystemColor.Light.Success.outline,
    cautionFontColor = DesignSystemColor.Light.Caution.fontColor,
    cautionBackground = DesignSystemColor.Light.Caution.background,
    cautionOutline = DesignSystemColor.Light.Caution.outline,
    disableFontColor = DesignSystemColor.Light.Caution.fontColor,
    disableBackground = DesignSystemColor.Light.Caution.background,
    disableOutline = DesignSystemColor.Light.Caution.outline,
    white = DesignSystemColor.Light.Single.white,
    black = DesignSystemColor.Light.Single.black,
    gray600 = DesignSystemColor.Light.Single.gray600,
)

private val darkScheme = DesignSystemScheme(
    primaryFontColor = DesignSystemColor.Dark.Primary.fontColor,
    primaryBackground = DesignSystemColor.Dark.Primary.background,
    primaryOutline = DesignSystemColor.Dark.Primary.outline,
    secondaryFontColor = DesignSystemColor.Dark.Secondary.fontColor,
    secondaryBackground = DesignSystemColor.Dark.Secondary.background,
    secondaryOutline = DesignSystemColor.Dark.Secondary.outline,
    tertiaryFontColor = DesignSystemColor.Dark.Tertiary.fontColor,
    tertiaryBackground = DesignSystemColor.Dark.Tertiary.background,
    tertiaryOutline = DesignSystemColor.Dark.Tertiary.outline,
    warningFontColor = DesignSystemColor.Dark.Warning.fontColor,
    warningBackground = DesignSystemColor.Dark.Warning.background,
    warningOutline = DesignSystemColor.Dark.Warning.outline,
    alarmFontColor = DesignSystemColor.Dark.Alarm.fontColor,
    alarmBackground = DesignSystemColor.Dark.Alarm.background,
    alarmOutline = DesignSystemColor.Dark.Alarm.outline,
    successFontColor = DesignSystemColor.Dark.Success.fontColor,
    successBackground = DesignSystemColor.Dark.Success.background,
    successOutline = DesignSystemColor.Dark.Success.outline,
    cautionFontColor = DesignSystemColor.Dark.Caution.fontColor,
    cautionBackground = DesignSystemColor.Dark.Caution.background,
    cautionOutline = DesignSystemColor.Dark.Caution.outline,
    disableFontColor = DesignSystemColor.Dark.Caution.fontColor,
    disableBackground = DesignSystemColor.Dark.Caution.background,
    disableOutline = DesignSystemColor.Dark.Caution.outline,
    white = DesignSystemColor.Dark.Single.white,
    black = DesignSystemColor.Dark.Single.black,
    gray600 = DesignSystemColor.Dark.Single.gray600,
)


@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (isDarkTheme) darkScheme else lightScheme

    CompositionLocalProvider(
        LocalDesignSystemScheme provides scheme,
        content = content
    )
}

object DesignSystemTheme {
    val colors: DesignSystemScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemScheme.current
}