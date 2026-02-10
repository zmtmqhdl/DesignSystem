package com.example.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.core.designSystem.theme.scheme.ColorScheme
import com.example.core.designSystem.theme.scheme.ColorSetSchemes
import com.example.core.designSystem.theme.scheme.ShapeScheme
import com.example.core.designSystem.theme.scheme.ShapeToken
import com.example.core.designSystem.theme.scheme.TypographyScheme
import com.example.core.designSystem.theme.scheme.LocalColor
import com.example.core.designSystem.theme.scheme.LocalSpacing
import com.example.core.designSystem.theme.scheme.LocalShape
import com.example.core.designSystem.theme.scheme.LocalTypography
import com.example.core.designSystem.theme.scheme.SpacingScheme
import com.example.core.designSystem.theme.scheme.SpacingToken
import com.example.core.designSystem.theme.scheme.typography

private val space = SpacingScheme(
    space0 = SpacingToken.Space0,
    space1 = SpacingToken.Space1,
    space2 = SpacingToken.Space2,
    space3 = SpacingToken.Space3,
    space4 = SpacingToken.Space4,
    space5 = SpacingToken.Space5,
    space6 = SpacingToken.Space6,
    space7 = SpacingToken.Space7,
    space8 = SpacingToken.Space8,
    space9 = SpacingToken.Space9,
    space10 = SpacingToken.Space10,
    space11 = SpacingToken.Space11,
    space12 = SpacingToken.Space12,
    space13 = SpacingToken.Space13,
    space14 = SpacingToken.Space14,
    space15 = SpacingToken.Space15,
    space16 = SpacingToken.Space16,
    space17 = SpacingToken.Space17,
    space18 = SpacingToken.Space18,
    space19 = SpacingToken.Space19,
    space20 = SpacingToken.Space20,
    space21 = SpacingToken.Space21,
    space22 = SpacingToken.Space22,
    space23 = SpacingToken.Space23,
    space24 = SpacingToken.Space24,
)

private val shape = ShapeScheme(
    bottomSheet = ShapeToken.BottomSheet,
    button = ShapeToken.Button,
    dialog = ShapeToken.Dialog,
    snackBar = ShapeToken.SnackBar,
    textField = ShapeToken.TextField,
    box = ShapeToken.Box,
    iconButton = ShapeToken.IconButton,
)

@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val color = if (isDarkTheme) ColorSetSchemes.LightColor else ColorSetSchemes.DarkColor

    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typography(),
        LocalSpacing provides space,
        LocalShape provides shape,
        content = content
    )
}

@Immutable
object DesignSystemTheme {
    val color: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val typography: TypographyScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: ShapeScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current

    val space: SpacingScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current
}