package com.example.core.designSystem.theme.scheme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
object DimensionToken {
    private val base = 1.dp
    fun get(value: Int): Dp {
        return base * value
    }

    val dimension1 = get(1)
    val dimension2 = get(2)
    val dimension3 = get(3)
    val dimension4 = get(4)
    val dimension5 = get(5)
    val dimension6 = get(6)
    val dimension7 = get(7)
    val dimension8 = get(8)
    val dimension9 = get(9)
    val dimension10 = get(10)
    val dimension11 = get(11)
    val dimension12 = get(12)
    val dimension13 = get(13)
    val dimension14 = get(14)
    val dimension15 = get(15)
    val dimension16 = get(16)
    val dimension17 = get(17)
    val dimension18 = get(18)
    val dimension19 = get(19)
    val dimension20 = get(20)
    val dimension21 = get(21)
    val dimension22 = get(22)
    val dimension23 = get(23)
    val dimension24 = get(24)
    val dimension25 = get(25)
    val dimension26 = get(26)
    val dimension27 = get(27)
    val dimension28 = get(28)
    val dimension29 = get(29)
    val dimension30 = get(30)
    val dimension31 = get(31)
    val dimension32 = get(32)
    val dimension33 = get(33)
    val dimension34 = get(34)
    val dimension35 = get(35)
    val dimension36 = get(36)
    val dimension37 = get(37)
    val dimension38 = get(38)
    val dimension39 = get(39)
    val dimension40 = get(40)
    val dimension41 = get(41)
    val dimension42 = get(42)
    val dimension43 = get(43)
    val dimension44 = get(44)
    val dimension45 = get(45)
    val dimension46 = get(46)
    val dimension47 = get(47)
    val dimension48 = get(48)
}

@Immutable
class DimensionScheme(
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
    val dimension25: Dp,
    val dimension26: Dp,
    val dimension27: Dp,
    val dimension28: Dp,
    val dimension29: Dp,
    val dimension30: Dp,
    val dimension31: Dp,
    val dimension32: Dp,
    val dimension33: Dp,
    val dimension34: Dp,
    val dimension35: Dp,
    val dimension36: Dp,
    val dimension37: Dp,
    val dimension38: Dp,
    val dimension39: Dp,
    val dimension40: Dp,
    val dimension41: Dp,
    val dimension42: Dp,
    val dimension43: Dp,
    val dimension44: Dp,
    val dimension45: Dp,
    val dimension46: Dp,
    val dimension47: Dp,
    val dimension48: Dp
)

val LocalDimensions: ProvidableCompositionLocal<DimensionScheme> = staticCompositionLocalOf {
    error("LocalDimension not provided")
}

val dimensionScheme = DimensionScheme(
    dimension1 = DimensionToken.dimension1,
    dimension2 = DimensionToken.dimension2,
    dimension3 = DimensionToken.dimension3,
    dimension4 = DimensionToken.dimension4,
    dimension5 = DimensionToken.dimension5,
    dimension6 = DimensionToken.dimension6,
    dimension7 = DimensionToken.dimension7,
    dimension8 = DimensionToken.dimension8,
    dimension9 = DimensionToken.dimension9,
    dimension10 = DimensionToken.dimension10,
    dimension11 = DimensionToken.dimension11,
    dimension12 = DimensionToken.dimension12,
    dimension13 = DimensionToken.dimension13,
    dimension14 = DimensionToken.dimension14,
    dimension15 = DimensionToken.dimension15,
    dimension16 = DimensionToken.dimension16,
    dimension17 = DimensionToken.dimension17,
    dimension18 = DimensionToken.dimension18,
    dimension19 = DimensionToken.dimension19,
    dimension20 = DimensionToken.dimension20,
    dimension21 = DimensionToken.dimension21,
    dimension22 = DimensionToken.dimension22,
    dimension23 = DimensionToken.dimension23,
    dimension24 = DimensionToken.dimension24,
    dimension25 = DimensionToken.dimension25,
    dimension26 = DimensionToken.dimension26,
    dimension27 = DimensionToken.dimension27,
    dimension28 = DimensionToken.dimension28,
    dimension29 = DimensionToken.dimension29,
    dimension30 = DimensionToken.dimension30,
    dimension31 = DimensionToken.dimension31,
    dimension32 = DimensionToken.dimension32,
    dimension33 = DimensionToken.dimension33,
    dimension34 = DimensionToken.dimension34,
    dimension35 = DimensionToken.dimension35,
    dimension36 = DimensionToken.dimension36,
    dimension37 = DimensionToken.dimension37,
    dimension38 = DimensionToken.dimension38,
    dimension39 = DimensionToken.dimension39,
    dimension40 = DimensionToken.dimension40,
    dimension41 = DimensionToken.dimension41,
    dimension42 = DimensionToken.dimension42,
    dimension43 = DimensionToken.dimension43,
    dimension44 = DimensionToken.dimension44,
    dimension45 = DimensionToken.dimension45,
    dimension46 = DimensionToken.dimension46,
    dimension47 = DimensionToken.dimension47,
    dimension48 = DimensionToken.dimension48
)