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
    primary = DesignSystemColor.Light.Primary,
    secondary = DesignSystemColor.Light.Secondary,
    tertiary = DesignSystemColor.Light.Tertiary,
    warning = DesignSystemColor.Light.Warning,
    alarm = DesignSystemColor.Light.Alarm,
    success = DesignSystemColor.Light.Success,
    caution = DesignSystemColor.Light.Caution,
    disable = DesignSystemColor.Light.Caution,
    white = DesignSystemColor.Light.white,
    black = DesignSystemColor.Light.black,
    gray600 = DesignSystemColor.Light.gray600,
)

private val darkScheme = DesignSystemScheme(
    primary = DesignSystemColor.Dark.Primary,
    secondary = DesignSystemColor.Dark.Secondary,
    tertiary = DesignSystemColor.Dark.Tertiary,
    warning = DesignSystemColor.Dark.Warning,
    alarm = DesignSystemColor.Dark.Alarm,
    success = DesignSystemColor.Dark.Success,
    caution = DesignSystemColor.Dark.Caution,
    disable = DesignSystemColor.Dark.Caution,
    white = DesignSystemColor.Dark.white,
    black = DesignSystemColor.Dark.black,
    gray600 = DesignSystemColor.Dark.gray600,
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
    val color: DesignSystemScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemScheme.current
}