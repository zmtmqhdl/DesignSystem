package com.example.presentation.theme

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

private val space = DesignSystemDp(
    dp0 = DesignSystemDps.Dp0,
    dp1 = DesignSystemDps.Dp1,
    dp2 = DesignSystemDps.Dp2,
    dp3 = DesignSystemDps.Dp3,
    dp4 = DesignSystemDps.Dp4,
    dp5 = DesignSystemDps.Dp5,
    dp6 = DesignSystemDps.Dp6,
    dp7 = DesignSystemDps.Dp7,
    dp8 = DesignSystemDps.Dp8,
    dp9 = DesignSystemDps.Dp9,
    dp10 = DesignSystemDps.Dp10,
    dp11 = DesignSystemDps.Dp11,
    dp12 = DesignSystemDps.Dp12,
)

private val shape = DesignSystemShape(
    buttonShape = DesignSystemShapes.ButtonShape,
    dialogShape = DesignSystemShapes.DialogShape,
    bottomSheet = DesignSystemShapes.BottomSheetShape
)


@Composable
fun DesignSystemTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val color = if (isDarkTheme) darkColor else lightColor

    CompositionLocalProvider(
        LocalDesignSystemColor provides color,
        LocalDesignSystemTypography provides typograpy,
        LocalDesignSystemDp provides space,
        content = content
    )
}

object DesignSystemTheme {
    val color: DesignSystemColor
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemColor.current

    val typography: DesignSystemTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemTypography.current

    val dp: DesignSystemDp
        @Composable
        @ReadOnlyComposable
        get() = LocalDesignSystemDp.current
}