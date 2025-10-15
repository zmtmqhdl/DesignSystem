package com.example.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val lightColor = DesignSystemColor(
    primary = DesignSystemColors.Light.Primary,
    secondary = DesignSystemColors.Light.Secondary,
    tertiary = DesignSystemColors.Light.Tertiary,
    warning = DesignSystemColors.Light.Warning,
    alarm = DesignSystemColors.Light.Alarm,
    success = DesignSystemColors.Light.Success,
    caution = DesignSystemColors.Light.Caution,
    disable = DesignSystemColors.Light.Caution,
    white = DesignSystemColors.Light.white,
    black = DesignSystemColors.Light.black,
    gray600 = DesignSystemColors.Light.gray600,
    background = DesignSystemColors.Light.background,
    backgroundElevated = DesignSystemColors.Light.backgroundElevated,
    activeIcon = DesignSystemColors.Light.activeIcon,
    inactiveIcon = DesignSystemColors.Light.inactiveIcon,
    text = DesignSystemColors.Light.text

)

private val darkColor = DesignSystemColor(
    primary = DesignSystemColors.Dark.Primary,
    secondary = DesignSystemColors.Dark.Secondary,
    tertiary = DesignSystemColors.Dark.Tertiary,
    warning = DesignSystemColors.Dark.Warning,
    alarm = DesignSystemColors.Dark.Alarm,
    success = DesignSystemColors.Dark.Success,
    caution = DesignSystemColors.Dark.Caution,
    disable = DesignSystemColors.Dark.Caution,
    white = DesignSystemColors.Dark.white,
    black = DesignSystemColors.Dark.black,
    gray600 = DesignSystemColors.Dark.gray600,
    background = DesignSystemColors.Dark.background,
    backgroundElevated = DesignSystemColors.Dark.backgroundElevated,
    activeIcon = DesignSystemColors.Dark.activeIcon,
    inactiveIcon = DesignSystemColors.Dark.inactiveIcon,
    text = DesignSystemColors.Dark.text
)

private val typograpy = DesignSystemTypography(
    xxxl = DesignSystemTextStyles.XXXL,
    xxl = DesignSystemTextStyles.XXL,
    xl = DesignSystemTextStyles.XL,
    l = DesignSystemTextStyles.L,
    m = DesignSystemTextStyles.M,
    s = DesignSystemTextStyles.S,
    xs = DesignSystemTextStyles.XS,
    xxs = DesignSystemTextStyles.XXS,
)

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
    space13 = DesignSystemSpaces.Space13,
    space14 = DesignSystemSpaces.Space14,
    space15 = DesignSystemSpaces.Space15,
    space16 = DesignSystemSpaces.Space16,
)

private val shape = DesignSystemShape(
    bottomSheet = DesignSystemShapes.BottomSheet,
    button = DesignSystemShapes.Button,
    dialog = DesignSystemShapes.Dialog,
    snackBar = DesignSystemShapes.SnackBar,
    textField =  DesignSystemShapes.TextField,
    box = DesignSystemShapes.Box
)

@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val color = if (isDarkTheme) darkColor else lightColor

    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typograpy,
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

    val shape: DesignSystemShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current

    val space: DesignSystemSpace
        @Composable
        @ReadOnlyComposable
        get() = LocalSpace.current

    val typography: DesignSystemTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}