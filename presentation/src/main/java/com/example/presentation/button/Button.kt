package com.example.presentation.button

import android.app.Notification
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.ButtonStyle
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemFontSize
import com.example.presentation.theme.DesignSystemFontWeight
import com.example.presentation.theme.DesignSystemSpace

object Button {
    object Primary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            style: ButtonStyle,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(48.dp)
                        .background(style.outlineColor)
                } else {
                    Modifier
                        .height(48.dp)
                        .background(DesignSystemColor.A)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(style.backgroundColor) else ButtonDefaults.buttonColors(
                    DesignSystemColor.A
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) style.fontColor else DesignSystemColor.A,
                    fontSize = DesignSystemFontSize.XL,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            style: ButtonStyle,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(44.dp)
                        .background(style.outlineColor)
                } else {
                    Modifier
                        .height(44.dp)
                        .background(DesignSystemColor.A)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(style.backgroundColor) else ButtonDefaults.buttonColors(
                    DesignSystemColor.A
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) style.fontColor else DesignSystemColor.A,
                    fontSize = DesignSystemFontSize.L,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            style: ButtonStyle,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(36.dp)
                        .background(style.outlineColor)
                } else {
                    Modifier
                        .height(36.dp)
                        .background(DesignSystemColor.A)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(style.backgroundColor) else ButtonDefaults.buttonColors(
                    DesignSystemColor.A
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) style.fontColor else DesignSystemColor.A,
                    fontSize = DesignSystemFontSize.M,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            style: ButtonStyle,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(32.dp)
                        .background(style.outlineColor)
                } else {
                    Modifier
                        .height(32.dp)
                        .background(DesignSystemColor.A)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(style.backgroundColor) else ButtonDefaults.buttonColors(
                    DesignSystemColor.A
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) style.fontColor else DesignSystemColor.A,
                    fontSize = DesignSystemFontSize.S,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            style: ButtonStyle,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(28.dp)
                        .background(style.outlineColor)
                } else {
                    Modifier
                        .height(28.dp)
                        .background(DesignSystemColor.A)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(style.backgroundColor) else ButtonDefaults.buttonColors(
                    DesignSystemColor.A
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) style.fontColor else DesignSystemColor.A,
                    fontSize = DesignSystemFontSize.XS,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }
    }
}

object Secondary {

}
