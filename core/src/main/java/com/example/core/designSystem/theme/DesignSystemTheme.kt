package com.example.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val space = DesignSystemSpace(
    space0 = DesignSystemSpaces.Space0,
    space1 = DesignSystemSpaces.Space1,
    space2 = DesignSystemSpaces.Space2,
    space3 = DesignSystemSpaces.Space3,
    space4 = DesignSystemSpaces.Space4,
    space5 = DesignSystemSpaces.Space5,
    space6 = DesignSystemSpaces.Space6,
    space7 = DesignSystemSpaces.Space7,
    space8 = DesignSystemSpaces.Space8,
    space9 = DesignSystemSpaces.Space9,
    space10 = DesignSystemSpaces.Space10,
    space11 = DesignSystemSpaces.Space11,
    space12 = DesignSystemSpaces.Space12,
)

private val shape = DesignSystemShape(
    bottomSheet = DesignSystemShapes.BottomSheet,
    button = DesignSystemShapes.Button,
    dialog = DesignSystemShapes.Dialog,
    snackBar = DesignSystemShapes.SnackBar,
    textField =  DesignSystemShapes.TextField,
    box = DesignSystemShapes.Box,
    iconButton = DesignSystemShapes.IconButton
)

@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val color = if (isDarkTheme) DesignSystemColorSet.LightColor else DesignSystemColorSet.DarkColor

    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typography(),
        LocalSpace provides space,
        LocalShape provides shape,
        content = content
    )
}

object DesignSystemTheme {
    val color: DesignSystemColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val typography: DesignSystemTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shape: DesignSystemShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current

    val space: DesignSystemSpace
        @Composable
        @ReadOnlyComposable
        get() = LocalSpace.current
}