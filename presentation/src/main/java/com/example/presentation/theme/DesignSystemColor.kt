package com.example.presentation.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

object DesignSystemSingleColor {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    val Gray600 = Color(0xFF757575)
}

sealed class DesignSystemColor {

    abstract val fontColor: Color
    abstract val background: Color
    abstract val outline: Color

    data object Primary : DesignSystemColor() {
        override val fontColor = Color(0xFF067CFB)
        override val background = Color(0xFFC9E6FD)
        override val outline = Color(0xFFECF5FD)
    }

    data object Secondary : DesignSystemColor() {
        override val fontColor = Color(0xFF00C200)
        override val background = Color(0xFFA4F29F)
        override val outline = Color(0xFFE3FAE1)
    }

    data object Tertiary : DesignSystemColor() {
        override val fontColor = Color(0xFF6A1B9A)
        override val background = Color(0xFFF1C6FF)
        override val outline = Color(0xFFEEA9D3)
    }

    data object Warning : DesignSystemColor() {
        override val fontColor = Color(0xFFED2B2A)
        override val background = Color(0xFFFDD8D9)
        override val outline = Color(0xFFFDF3F3)
    }

    data object Alarm : DesignSystemColor() {
        override val fontColor = Color(0xFF067CFB)
        override val background = Color(0xFFC9E6FD)
        override val outline = Color(0xFFECF5FD)
    }

    data object Success : DesignSystemColor() {
        override val fontColor = Color(0xFF00C200)
        override val background = Color(0xFFA4F29F)
        override val outline = Color(0xFFE3FAE1)
    }

    data object Caution : DesignSystemColor() {
        override val fontColor = Color(0xFFFDD000)
        override val background = Color(0xFFFBF6C9)
        override val outline = Color(0xFFFDFAE3)
    }

    data object Disable : DesignSystemColor() {
        override val fontColor = Color(0xFFFDD000)
        override val background = Color(0xFFFDD000)
        override val outline = Color(0xFFFDD000)
    }

}