package com.example.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    state: Boolean,
    color: DesignSystemColor,
    width: Dp? = null,
    height: Dp,
    space: Dp,
    style: TextStyle,
    icon: String? = null,
    iconPosition: String? = "left",
) {
    Button(
        onClick = onClick,
        modifier = if (width != null) {
            Modifier
                .width(width)
                .height(height)
        } else {
            Modifier
                .fillMaxWidth()
                .height(height)
        },
        enabled = state,
        shape = DesignSystemShape.PrimaryButtonShape,
        colors = if (state) ButtonDefaults.buttonColors(color.background) else ButtonDefaults.buttonColors(
            DesignSystemColor.Disable.background
        ),
        contentPadding = PaddingValues(
            start = space,
            end = space
        )
    ) {
        if (icon != null && iconPosition == "left") {
            DesignSystemIcon(name = icon, iconPosition = iconPosition)
        }
        Text(
            text = text,
            color = if (state) color.fontColor else DesignSystemColor.Disable.fontColor,
            style = style
        )
        if (icon != null && iconPosition == "right") {
            DesignSystemIcon(name = icon, iconPosition = iconPosition)
        }
    }
}

object DesignSystemButton {
    object CTA {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }

    object Primary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }

    object Secondary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }

    object Warning {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            state: Boolean = true,
            icon: String? = null,
            iconPosition: String = "left",
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }
}

