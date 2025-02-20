package com.example.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightTheme = lightColorScheme(

)

private val DarkTheme = lightColorScheme(

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

// object에 맞춰서 스키마도 다시 정의하고, theme도 정의한다면?