package com.example.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.presentation.theme.DesignSystemColorSet
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    state: Boolean,
    color: DesignSystemColorSet,
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
            DesignSystemTheme.color.disable.background
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
            color = if (state) color.fontColor else DesignSystemTheme.color.disable.fontColor,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.xl.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.l.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.m.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.s.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.xs.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.xl.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.l.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.m.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.s.regular,
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
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.xs.regular,
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
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.xl.regular,
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
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.l.regular,
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
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.m.regular,
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
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.s.regular,
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
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.xs.regular,
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
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.xl.regular,
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
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.l.regular,
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
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemTheme.typography.m.regular,
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
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.s.regular,
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
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemTheme.typography.xs.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }
}

