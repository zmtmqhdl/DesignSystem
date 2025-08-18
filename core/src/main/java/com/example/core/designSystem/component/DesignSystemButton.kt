package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemColorSet
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.core.designSystem.type.IconPosition

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: DesignSystemColorSet,
    width: Dp? = null,
    fraction: Float = 1f,
    height: Dp,
    iconBoxWidth: Dp = DesignSystemTheme.space.space8,
    iconBoxHeight: Dp = DesignSystemTheme.space.space8,
    iconWidth: Dp = DesignSystemTheme.space.space4,
    iconHeight: Dp = DesignSystemTheme.space.space4,
    textStyle: TextStyle,
    icon: ImageVector? = null,
    iconPosition: IconPosition = IconPosition.Default,
) {
    Box(
        modifier = Modifier
            .then(
                if (width != null) Modifier.width(width) else Modifier.fillMaxWidth(fraction)
            )
            .height(height)
            .background(
                color = if (enabled) color.background else DesignSystemTheme.color.disable.background,
                shape = DesignSystemTheme.shape.button
            )
            .border(
                width = DesignSystemTheme.space.space1,
                color = color.outline,
                shape = DesignSystemTheme.shape.button
            )
            .clip(DesignSystemTheme.shape.button)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { if (enabled) onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (icon != null && iconPosition == IconPosition.Left) {
            DesignSystemIcon(
                icon = icon,
                color = color.fontColor,
                boxWidth = iconBoxWidth,
                boxHeight = iconBoxHeight,
                iconWidth = iconWidth,
                iconHeight = iconHeight
            )
            Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
        }
        Text(
            text = text,
            color = if (enabled) color.fontColor else DesignSystemTheme.color.disable.fontColor,
            style = textStyle
        )
        if (icon != null && iconPosition == IconPosition.Right) {
            Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
            DesignSystemIcon(
                icon = icon,
                color = color.fontColor,
                boxWidth = iconBoxWidth,
                boxHeight = iconBoxHeight,
                iconWidth = iconWidth,
                iconHeight = iconHeight
            )
        }
    }
}

object DesignSystemButton {
    object Primary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.primary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space12,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xl.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.primary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space11,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.l.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.primary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space9,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.m.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.primary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space8,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.s.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.primary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space7,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xs.regular,
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
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.secondary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space12,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xl.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.secondary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space11,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.l.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.secondary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space9,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.m.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.secondary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space8,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.s.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.secondary,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space7,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xs.regular,
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
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.warning,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space12,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xl.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.warning,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space11,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.l.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space4,
            iconHeight: Dp = DesignSystemTheme.space.space4,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.warning,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space9,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.m.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.warning,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space8,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.s.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            width: Dp? = null,
            fraction: Float = 1f,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconWidth: Dp = DesignSystemTheme.space.space3,
            iconHeight: Dp = DesignSystemTheme.space.space3,
            iconBoxWidth: Dp = DesignSystemTheme.space.space8,
            iconBoxHeight: Dp = DesignSystemTheme.space.space8,
            iconPosition: IconPosition = IconPosition.Default
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                enabled = enabled,
                color = DesignSystemTheme.color.warning,
                width = width,
                fraction = fraction,
                height = DesignSystemTheme.space.space7,
                iconWidth = iconWidth,
                iconHeight = iconHeight,
                iconBoxWidth = iconBoxWidth,
                iconBoxHeight = iconBoxHeight,
                textStyle = DesignSystemTheme.typography.xs.regular,
                icon = icon,
                iconPosition = iconPosition
            )
        }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Primary_Xlarge_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Primary_Large_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Primary_Medium_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesignSystemButton_Primary_Small_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Primary_Tiny_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Primary.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Secondary_Xlarge_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Secondary_Large_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Secondary_Medium_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Secondary_Small_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Secondary_Tiny_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Secondary.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Warning_Xlarge_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Xlarge(
            text = "Xlarge",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Warning_Large_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Large(
            text = "Large",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Warning_Medium_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Medium(
            text = "Medium",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Warning_Small_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Small(
            text = "Small",
            onClick = { },
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemButton_Warning_Tiny_Preview() {
    DesignSystemTheme {
        DesignSystemButton.Warning.Tiny(
            text = "Tiny",
            onClick = { },
        )
    }
}
