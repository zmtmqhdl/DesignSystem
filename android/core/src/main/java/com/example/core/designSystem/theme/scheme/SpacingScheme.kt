package com.example.core.designSystem.theme.scheme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object SpacingToken {
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
    val Space13 = 52.dp
    val Space14 = 56.dp
    val Space15 = 60.dp
    val Space16 = 64.dp
    val Space17 = 68.dp
    val Space18 = 72.dp
    val Space19 = 76.dp
    val Space20 = 80.dp
    val Space21 = 84.dp
    val Space22 = 88.dp
    val Space23 = 92.dp
    val Space24 = 96.dp
}

@Immutable
class SpacingScheme(
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
    val space13: Dp,
    val space14: Dp,
    val space15: Dp,
    val space16: Dp,
    val space17: Dp,
    val space18: Dp,
    val space19: Dp,
    val space20: Dp,
    val space21: Dp,
    val space22: Dp,
    val space23: Dp,
    val space24: Dp,
)

val LocalSpacing: ProvidableCompositionLocal<SpacingScheme> = staticCompositionLocalOf {
    error("LocalSpacing not provided")
}