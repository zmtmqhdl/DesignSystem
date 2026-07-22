package com.example.core.designSystem.theme.scheme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object DimensionToken {
    val Dimension0 = 1.dp
    val Dimension1 = 4.dp
    val Dimension2 = 8.dp
    val Dimension3 = 12.dp
    val Dimension4 = 16.dp
    val Dimension5 = 20.dp
    val Dimension6 = 24.dp
    val Dimension7 = 28.dp
    val Dimension8 = 32.dp
    val Dimension9 = 36.dp
    val Dimension10 = 40.dp
    val Dimension11 = 44.dp
    val Dimension12 = 48.dp
    val Dimension13 = 52.dp
    val Dimension14 = 56.dp
    val Dimension15 = 60.dp
    val Dimension16 = 64.dp
    val Dimension17 = 68.dp
    val Dimension18 = 72.dp
    val Dimension19 = 76.dp
    val Dimension20 = 80.dp
    val Dimension21 = 84.dp
    val Dimension22 = 88.dp
    val Dimension23 = 92.dp
    val Dimension24 = 96.dp
}

@Immutable
class DimensionScheme(
    val dimension0: Dp,
    val dimension1: Dp,
    val dimension2: Dp,
    val dimension3: Dp,
    val dimension4: Dp,
    val dimension5: Dp,
    val dimension6: Dp,
    val dimension7: Dp,
    val dimension8: Dp,
    val dimension9: Dp,
    val dimension10: Dp,
    val dimension11: Dp,
    val dimension12: Dp,
    val dimension13: Dp,
    val dimension14: Dp,
    val dimension15: Dp,
    val dimension16: Dp,
    val dimension17: Dp,
    val dimension18: Dp,
    val dimension19: Dp,
    val dimension20: Dp,
    val dimension21: Dp,
    val dimension22: Dp,
    val dimension23: Dp,
    val dimension24: Dp,
)

val LocalDimensions: ProvidableCompositionLocal<DimensionScheme> = staticCompositionLocalOf {
    error("LocalDimension not provided")
}

val dimensionScheme = DimensionScheme(
    dimension0 = DimensionToken.Dimension0,
    dimension1 = DimensionToken.Dimension1,
    dimension2 = DimensionToken.Dimension2,
    dimension3 = DimensionToken.Dimension3,
    dimension4 = DimensionToken.Dimension4,
    dimension5 = DimensionToken.Dimension5,
    dimension6 = DimensionToken.Dimension6,
    dimension7 = DimensionToken.Dimension7,
    dimension8 = DimensionToken.Dimension8,
    dimension9 = DimensionToken.Dimension9,
    dimension10 = DimensionToken.Dimension10,
    dimension11 = DimensionToken.Dimension11,
    dimension12 = DimensionToken.Dimension12,
    dimension13 = DimensionToken.Dimension13,
    dimension14 = DimensionToken.Dimension14,
    dimension15 = DimensionToken.Dimension15,
    dimension16 = DimensionToken.Dimension16,
    dimension17 = DimensionToken.Dimension17,
    dimension18 = DimensionToken.Dimension18,
    dimension19 = DimensionToken.Dimension19,
    dimension20 = DimensionToken.Dimension20,
    dimension21 = DimensionToken.Dimension21,
    dimension22 = DimensionToken.Dimension22,
    dimension23 = DimensionToken.Dimension23,
    dimension24 = DimensionToken.Dimension24,
)