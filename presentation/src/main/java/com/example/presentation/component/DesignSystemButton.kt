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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.presentation.common.IconPosition
import com.example.presentation.theme.DesignSystemColorSet
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
    icon: ImageVector? = null,
    iconPosition: IconPosition = IconPosition.DEFAULT,
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
        shape = DesignSystemTheme.shape.button,
        colors = if (state) ButtonDefaults.buttonColors(color.background) else ButtonDefaults.buttonColors(
            DesignSystemTheme.color.disable.background
        ),
        contentPadding = PaddingValues(
            start = space,
            end = space
        )
    ) {
        if (icon != null && iconPosition == IconPosition.LEFT) {
            DesignSystemIcon(name = icon, iconPosition = iconPosition)
        }
        Text(
            text = text,
            color = if (state) color.fontColor else DesignSystemTheme.color.disable.fontColor,
            style = style
        )
    }
    if (icon != null && iconPosition == IconPosition.RIGHT) {
        DesignSystemIcon(name = icon, iconPosition = iconPosition)
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space12,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space11,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space9,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space8,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space7,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space12,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space11,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space9,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space8,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.primary,
                width = width,
                height = DesignSystemTheme.space.space7,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemTheme.space.space12,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemTheme.space.space11,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemTheme.space.space9,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemTheme.space.space8,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.secondary,
                width = width,
                height = DesignSystemTheme.space.space7,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemTheme.space.space12,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemTheme.space.space11,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemTheme.space.space9,
                space = DesignSystemTheme.space.space4,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemTheme.space.space8,
                space = DesignSystemTheme.space.space3,
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
            icon: ImageVector? = null,
            iconPosition: IconPosition = IconPosition.LEFT
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemTheme.color.warning,
                width = width,
                height = DesignSystemTheme.space.space7,
                space = DesignSystemTheme.space.space3,
                style = DesignSystemTheme.typography.xs.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }
}