package com.example.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

fun customLightColorScheme

private val LightTheme = lightColorScheme(

)

private val DarkTheme = darkColorScheme(

)


@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = if (isDarkTheme) DarkTheme else LightTheme

    MaterialTheme(
        colorScheme = theme,
        typography = Typography,
        content = content
    )
}