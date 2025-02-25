package com.example.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object DesignSystemDps{
    val Dp0 = 2.dp
    val Dp1 = 4.dp
    val Dp2 = 8.dp
    val Dp3 = 12.dp
    val Dp4 = 16.dp
    val Dp5 = 20.dp
    val Dp6 = 24.dp
    val Dp7 = 28.dp
    val Dp8 = 32.dp
    val Dp9 = 36.dp
    val Dp10 = 40.dp
    val Dp11 = 44.dp
    val Dp12 = 48.dp
}

@Stable
class DesignSystemDp(
    val dp0: Dp,
    val dp1: Dp,
    val dp2: Dp,
    val dp3: Dp,
    val dp4: Dp,
    val dp5: Dp,
    val dp6: Dp,
    val dp7: Dp,
    val dp8: Dp,
    val dp9: Dp,
    val dp10: Dp,
    val dp11: Dp,
    val dp12: Dp,
)

val LocalDesignSystemDp = staticCompositionLocalOf {
    DesignSystemDp(
        dp0 = Dp.Unspecified,
        dp1 = Dp.Unspecified,
        dp2 = Dp.Unspecified,
        dp3 = Dp.Unspecified,
        dp4 = Dp.Unspecified,
        dp5 = Dp.Unspecified,
        dp6 = Dp.Unspecified,
        dp7 = Dp.Unspecified,
        dp8 = Dp.Unspecified,
        dp9 = Dp.Unspecified,
        dp10 = Dp.Unspecified,
        dp11 = Dp.Unspecified,
        dp12 = Dp.Unspecified,
    )
}