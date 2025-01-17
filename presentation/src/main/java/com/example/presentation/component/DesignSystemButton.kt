package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
    space: Dp,
    style: TextStyle
) {
    Button(
        onClick = onClick,
        modifier = if (state) {
            Modifier
                .height(48.dp)
                .background(color.outline)
        } else {
            Modifier
                .height(48.dp)
                .background(DesignSystemColor.Disable.outline)
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.M,
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
                space = DesignSystemSpace.S,
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
                space = DesignSystemSpace.S,
                style = DesignSystemFontStyle.XS.Regular
            )
        }
    }
}

