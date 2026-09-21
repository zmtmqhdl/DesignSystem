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
    val dimension49 = get(49)
    val dimension50 = get(50)
    val dimension51 = get(51)
    val dimension52 = get(52)
    val dimension53 = get(53)
    val dimension54 = get(54)
    val dimension55 = get(55)
    val dimension56 = get(56)
    val dimension57 = get(57)
    val dimension58 = get(58)
    val dimension59 = get(59)
    val dimension60 = get(60)
    val dimension61 = get(61)
    val dimension62 = get(62)
    val dimension63 = get(63)
    val dimension64 = get(64)
    val dimension65 = get(65)
    val dimension66 = get(66)
    val dimension67 = get(67)
    val dimension68 = get(68)
    val dimension69 = get(69)
    val dimension70 = get(70)
    val dimension71 = get(71)
    val dimension72 = get(72)
    val dimension73 = get(73)
    val dimension74 = get(74)
    val dimension75 = get(75)
    val dimension76 = get(76)
    val dimension77 = get(77)
    val dimension78 = get(78)
    val dimension79 = get(79)
    val dimension80 = get(80)
    val dimension81 = get(81)
    val dimension82 = get(82)
    val dimension83 = get(83)
    val dimension84 = get(84)
    val dimension85 = get(85)
    val dimension86 = get(86)
    val dimension87 = get(87)
    val dimension88 = get(88)
    val dimension89 = get(89)
    val dimension90 = get(90)
    val dimension91 = get(91)
    val dimension92 = get(92)
    val dimension93 = get(93)
    val dimension94 = get(94)
    val dimension95 = get(95)
    val dimension96 = get(96)
    val dimension97 = get(97)
    val dimension98 = get(98)
    val dimension99 = get(99)
    val dimension100 = get(100)
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
    val dimension48: Dp,
    val dimension49: Dp,
    val dimension50: Dp,
    val dimension51: Dp,
    val dimension52: Dp,
    val dimension53: Dp,
    val dimension54: Dp,
    val dimension55: Dp,
    val dimension56: Dp,
    val dimension57: Dp,
    val dimension58: Dp,
    val dimension59: Dp,
    val dimension60: Dp,
    val dimension61: Dp,
    val dimension62: Dp,
    val dimension63: Dp,
    val dimension64: Dp,
    val dimension65: Dp,
    val dimension66: Dp,
    val dimension67: Dp,
    val dimension68: Dp,
    val dimension69: Dp,
    val dimension70: Dp,
    val dimension71: Dp,
    val dimension72: Dp,
    val dimension73: Dp,
    val dimension74: Dp,
    val dimension75: Dp,
    val dimension76: Dp,
    val dimension77: Dp,
    val dimension78: Dp,
    val dimension79: Dp,
    val dimension80: Dp,
    val dimension81: Dp,
    val dimension82: Dp,
    val dimension83: Dp,
    val dimension84: Dp,
    val dimension85: Dp,
    val dimension86: Dp,
    val dimension87: Dp,
    val dimension88: Dp,
    val dimension89: Dp,
    val dimension90: Dp,
    val dimension91: Dp,
    val dimension92: Dp,
    val dimension93: Dp,
    val dimension94: Dp,
    val dimension95: Dp,
    val dimension96: Dp,
    val dimension97: Dp,
    val dimension98: Dp,
    val dimension99: Dp,
    val dimension100: Dp
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
    dimension48 = DimensionToken.dimension48,
    dimension49 = DimensionToken.dimension49,
    dimension50 = DimensionToken.dimension50,
    dimension51 = DimensionToken.dimension51,
    dimension52 = DimensionToken.dimension52,
    dimension53 = DimensionToken.dimension53,
    dimension54 = DimensionToken.dimension54,
    dimension55 = DimensionToken.dimension55,
    dimension56 = DimensionToken.dimension56,
    dimension57 = DimensionToken.dimension57,
    dimension58 = DimensionToken.dimension58,
    dimension59 = DimensionToken.dimension59,
    dimension60 = DimensionToken.dimension60,
    dimension61 = DimensionToken.dimension61,
    dimension62 = DimensionToken.dimension62,
    dimension63 = DimensionToken.dimension63,
    dimension64 = DimensionToken.dimension64,
    dimension65 = DimensionToken.dimension65,
    dimension66 = DimensionToken.dimension66,
    dimension67 = DimensionToken.dimension67,
    dimension68 = DimensionToken.dimension68,
    dimension69 = DimensionToken.dimension69,
    dimension70 = DimensionToken.dimension70,
    dimension71 = DimensionToken.dimension71,
    dimension72 = DimensionToken.dimension72,
    dimension73 = DimensionToken.dimension73,
    dimension74 = DimensionToken.dimension74,
    dimension75 = DimensionToken.dimension75,
    dimension76 = DimensionToken.dimension76,
    dimension77 = DimensionToken.dimension77,
    dimension78 = DimensionToken.dimension78,
    dimension79 = DimensionToken.dimension79,
    dimension80 = DimensionToken.dimension80,
    dimension81 = DimensionToken.dimension81,
    dimension82 = DimensionToken.dimension82,
    dimension83 = DimensionToken.dimension83,
    dimension84 = DimensionToken.dimension84,
    dimension85 = DimensionToken.dimension85,
    dimension86 = DimensionToken.dimension86,
    dimension87 = DimensionToken.dimension87,
    dimension88 = DimensionToken.dimension88,
    dimension89 = DimensionToken.dimension89,
    dimension90 = DimensionToken.dimension90,
    dimension91 = DimensionToken.dimension91,
    dimension92 = DimensionToken.dimension92,
    dimension93 = DimensionToken.dimension93,
    dimension94 = DimensionToken.dimension94,
    dimension95 = DimensionToken.dimension95,
    dimension96 = DimensionToken.dimension96,
    dimension97 = DimensionToken.dimension97,
    dimension98 = DimensionToken.dimension98,
    dimension99 = DimensionToken.dimension99,
    dimension100 = DimensionToken.dimension100
)