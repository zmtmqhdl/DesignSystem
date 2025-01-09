package com.example.presentation.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemFontSize
import com.example.presentation.theme.DesignSystemFontWeight
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.ProjectColor

object Button {
    object Primary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(48.dp)
                        .background(ProjectColor.PrimaryOutline)
                } else {
                    Modifier
                        .height(48.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.PrimaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.PrimaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XL,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(44.dp)
                        .background(ProjectColor.PrimaryOutline)
                } else {
                    Modifier
                        .height(44.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.PrimaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.PrimaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.L,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(36.dp)
                        .background(ProjectColor.PrimaryOutline)
                } else {
                    Modifier
                        .height(36.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.PrimaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.PrimaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.M,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(32.dp)
                        .background(ProjectColor.PrimaryOutline)
                } else {
                    Modifier
                        .height(32.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.PrimaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.PrimaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.S,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(28.dp)
                        .background(ProjectColor.PrimaryOutline)
                } else {
                    Modifier
                        .height(28.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.PrimaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.PrimaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XS,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }
    }

    object Secondary {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(48.dp)
                        .background(ProjectColor.SecondaryOutline)
                } else {
                    Modifier
                        .height(48.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.SecondaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.SecondaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XL,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(44.dp)
                        .background(ProjectColor.SecondaryOutline)
                } else {
                    Modifier
                        .height(44.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.SecondaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.SecondaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.L,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(36.dp)
                        .background(ProjectColor.SecondaryOutline)
                } else {
                    Modifier
                        .height(36.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.SecondaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.SecondaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.M,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(32.dp)
                        .background(ProjectColor.SecondaryOutline)
                } else {
                    Modifier
                        .height(32.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.SecondaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.SecondaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.S,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(28.dp)
                        .background(ProjectColor.SecondaryOutline)
                } else {
                    Modifier
                        .height(28.dp)
                        .background(DesignSystemColor.DisableFontColor)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(ProjectColor.SecondaryBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) ProjectColor.SecondaryFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XS,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }
    }

    object Warning {
        @Composable
        fun Xlarge(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(48.dp)
                        .background(DesignSystemColor.WarningOutline)
                } else {
                    Modifier
                        .height(48.dp)
                        .background(DesignSystemColor.DisableOutline)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(DesignSystemColor.WarningBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) DesignSystemColor.WarningFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XL,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Large(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(44.dp)
                        .background(DesignSystemColor.WarningOutline)
                } else {
                    Modifier
                        .height(44.dp)
                        .background(DesignSystemColor.DisableOutline)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(DesignSystemColor.WarningBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) DesignSystemColor.WarningFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.L,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Medium(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(36.dp)
                        .background(DesignSystemColor.WarningOutline)
                } else {
                    Modifier
                        .height(36.dp)
                        .background(DesignSystemColor.DisableOutline)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(DesignSystemColor.WarningBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.M,
                    end = DesignSystemSpace.M
                )
            ) {
                Text(
                    text = text,
                    color = if (state) DesignSystemColor.WarningFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.M,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }

        @Composable
        fun Small(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(32.dp)
                        .background(DesignSystemColor.WarningOutline)
                } else {
                    Modifier
                        .height(32.dp)
                        .background(DesignSystemColor.DisableOutline)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(DesignSystemColor.WarningBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) DesignSystemColor.WarningFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.S,
                    fontWeight = DesignSystemFontWeight.Regular,
                )
            }
        }

        @Composable
        fun Tiny(
            text: String,
            onClick: () -> Unit,
            state: Boolean = true
        ) {
            Button(
                onClick = onClick,
                modifier = if (state) {
                    Modifier
                        .height(28.dp)
                        .background(DesignSystemColor.WarningOutline)
                } else {
                    Modifier
                        .height(28.dp)
                        .background(DesignSystemColor.DisableOutline)
                },
                enabled = state,
                shape = DesignSystemShape.RoundedRectangle,
                colors = if (state) ButtonDefaults.buttonColors(DesignSystemColor.WarningBackground) else ButtonDefaults.buttonColors(
                    DesignSystemColor.DisableBackground
                ),
                contentPadding = PaddingValues(
                    start = DesignSystemSpace.S,
                    end = DesignSystemSpace.S
                )
            ) {
                Text(
                    text = text,
                    color = if (state) DesignSystemColor.WarningFontColor else DesignSystemColor.DisableOutline,
                    fontSize = DesignSystemFontSize.XS,
                    fontWeight = DesignSystemFontWeight.Regular
                )
            }
        }
    }
}

