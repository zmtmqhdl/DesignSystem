package com.example.presentation.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

object DesignSystemColor {
    val WarningFontColor = Color(0xFFED2B2A)
    val WarningBackground = Color(0xFFFDD8D9)
    val WarningOutline = Color(0xFFFDF3F3)

    val AlarmFontColor = Color(0xFF067CFB)
    val AlarmBackground = Color(0xFFC9E6FD)
    val AlarmOutline = Color(0xFFECF5FD)

    val SuccessFontColor = Color(0xFF00C200)
    val SuccessBackground = Color(0xFFA4F29F)
    val SuccessOutline = Color(0xFFE3FAE1)

    val CautionFontColor = Color(0xFFFDD000)
    val CautionBackground = Color(0xFFFBF6C9)
    val CautionOutline = Color(0xFFFDFAE3)

    // 죽은 버젼 하나 만들어야됨
    val A = Color(0xFFFDD000)
}

data class ButtonStyle(
    val fontColor: Color,
    val backgroundColor: Color,
    val outlineColor: Color
)