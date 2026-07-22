package com.example.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.example.core.designSystem.theme.scheme.ColorScheme
import com.example.core.designSystem.theme.scheme.ColorSetSchemes
import com.example.core.designSystem.theme.scheme.DimensionScheme
import com.example.core.designSystem.theme.scheme.LocalColors
import com.example.core.designSystem.theme.scheme.LocalDimensions
import com.example.core.designSystem.theme.scheme.LocalShapes
import com.example.core.designSystem.theme.scheme.LocalTypography
import com.example.core.designSystem.theme.scheme.ShapeScheme
import com.example.core.designSystem.theme.scheme.TypographyScheme
import com.example.core.designSystem.theme.scheme.dimensionScheme
import com.example.core.designSystem.theme.scheme.shapeScheme
import com.example.core.designSystem.theme.scheme.typography

object DSTheme {
    @Composable
    operator fun invoke(
        content: @Composable () -> Unit
    ) {
        val color = if (isSystemInDarkTheme()) ColorSetSchemes.DarkColor else ColorSetSchemes.LightColor

        CompositionLocalProvider(
            LocalColors provides color,
            LocalTypography provides typography(),
            LocalDimensions provides dimensionScheme,
            LocalShapes provides shapeScheme,
            content = content
        )
    }

    val color: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: TypographyScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: ShapeScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val space: DimensionScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}