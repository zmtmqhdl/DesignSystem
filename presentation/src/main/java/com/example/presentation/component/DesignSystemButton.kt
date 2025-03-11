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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.presentation.common.IconPosition
import com.example.presentation.theme.DesignSystemColorSet
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier? = null,
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
        modifier = modifier
            ?: if (width != null) {
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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
            modifier: Modifier? = null,
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
                modifier = modifier,
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

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_CTA_Xlarge() {
    DesignSystemTheme {
        DesignSystemButton.CTA.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_CTA_Large() {
    DesignSystemTheme {
        DesignSystemButton.CTA.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_CTA_Medium() {
    DesignSystemTheme {
        DesignSystemButton.CTA.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_CTA_Small() {
    DesignSystemTheme {
        DesignSystemButton.CTA.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_CTA_Tiny() {
    DesignSystemTheme {
        DesignSystemButton.CTA.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Primary_Xlarge() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Primary_Large() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Primary_Medium() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Primary_Small() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Primary_Tiny() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Secondary_Xlarge() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Secondary_Large() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Secondary_Medium() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Secondary_Small() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Secondary_Tiny() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Warning_Xlarge() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Warning_Large() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Warning_Medium() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Warning_Small() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemButton_Warning_Tiny() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}
