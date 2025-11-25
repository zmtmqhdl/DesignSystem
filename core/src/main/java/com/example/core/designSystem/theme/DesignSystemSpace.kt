package com.example.core.designSystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object DesignSystemSpaces {
    val Space0 = 1.dp
    val Space1 = 4.dp
    val Space2 = 8.dp
    val Space3 = 12.dp
    val Space4 = 16.dp
    val Space5 = 20.dp
    val Space6 = 24.dp
    val Space7 = 28.dp
    val Space8 = 32.dp
    val Space9 = 36.dp
    val Space10 = 40.dp
    val Space11 = 44.dp
    val Space12 = 48.dp
}

@Immutable
class DesignSystemSpace(
    val space0: Dp,
    val space1: Dp,
    val space2: Dp,
    val space3: Dp,
    val space4: Dp,
    val space5: Dp,
    val space6: Dp,
    val space7: Dp,
    val space8: Dp,
    val space9: Dp,
    val space10: Dp,
    val space11: Dp,
    val space12: Dp,
)

val LocalSpace: ProvidableCompositionLocal<DesignSystemSpace> = staticCompositionLocalOf {
    error("LocalSpace not provided")
}