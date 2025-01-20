package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    state: Boolean = true,
    color: DesignSystemColor,
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    height: Dp,
    space: Dp,
    style: TextStyle
) {
    Button(
        onClick = onClick,
        modifier = if (state) {
            modifier
                .height(height)
        } else {
            modifier
                .height(height)
        },
        enabled = state,
        shape = DesignSystemShape.RoundedRectangle,
        colors = if (state) ButtonDefaults.buttonColors(color.background) else ButtonDefaults.buttonColors(
            DesignSystemColor.Disable.background
        ),
        contentPadding = PaddingValues(
            start = space,
            end = space
        )
    ) {
        Text(
            text = text,
            color = if (state) color.fontColor else DesignSystemColor.Disable.fontColor,
            style = style
        )
    }
}

object DesignSystemButton {
    object CTA {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular
            )
        }
    }

    object Primary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Primary,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular
            )
        }
    }

    object Secondary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Secondary,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular
            )
        }
    }

    object Warning {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                height = DesignSystemSpace.Space12,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.XL.Regular
            )
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                height = DesignSystemSpace.Space11,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.L.Regular
            )
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                height = DesignSystemSpace.Space9,
                space = DesignSystemSpace.Space4,
                style = DesignSystemFontStyle.M.Regular
            )
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                height = DesignSystemSpace.Space8,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.S.Regular
            )
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            PrimaryButton(
                text = text,
                onClick = onClick,
                state = state,
                color = DesignSystemColor.Warning,
                height = DesignSystemSpace.Space7,
                space = DesignSystemSpace.Space3,
                style = DesignSystemFontStyle.XS.Regular
            )
        }
    }
}

