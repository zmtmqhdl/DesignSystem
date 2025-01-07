package com.example.presentation.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.FontSize
import com.example.presentation.theme.FontWeight
import com.example.presentation.theme.Shape
import com.example.presentation.theme.Space

object Button {
    object Primary {
        object Xlarge {
            object XXXL {
                @Composable
                fun Bold(
                    text: String,
                    onClick: () -> Unit
                ) {
                    Button(
                        onClick = onClick,
                        modifier = Modifier.height(48.dp),
                        shape = Shape.RoundedRectangle,
                        contentPadding = PaddingValues(
                            start = Space.M,
                            end = Space.M
                        )
                    ) {
                        Text(
                            text = text,
                            fontSize = FontSize.XXXL,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                @Composable
                fun Medium(
                    text: String,
                    onClick: () -> Unit
                ) {
                    Button(
                        onClick = onClick,
                        modifier = Modifier.height(48.dp),
                        shape = Shape.RoundedRectangle,
                        contentPadding = PaddingValues(
                            start = Space.M,
                            end = Space.M
                        )
                    ) {
                        Text(
                            text = text,
                            fontSize = FontSize.XXXL,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                @Composable
                fun Regular(
                    text: String,
                    onClick: () -> Unit
                ) {
                    Button(
                        onClick = onClick,
                        modifier = Modifier.height(48.dp),
                        shape = Shape.RoundedRectangle,
                        contentPadding = PaddingValues(
                            start = Space.M,
                            end = Space.M
                        )
                    ) {
                        Text(
                            text = text,
                            fontSize = FontSize.XXXL,
                            fontWeight = FontWeight.Regular
                        )
                    }
                }
            }
            object XXL {

            }
            object XL {

            }
            object L {

            }
            object M {

            }
            object S {

            }
            object XS {

            }
            object XXS {

            }
        }
        object Large {

        }
        object Medium {

        }
        object Small {

        }
        object Tiny
    }
    object Secondary {

    }

    object Disable {

    }
}









object PrimaryButton {
    @Composable
    fun Bold(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(48.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Large(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(44.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Medium(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(36.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Small(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(32.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.XS,
                end = Space.XS
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Tiny(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(28.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.XS,
                end = Space.XS
            )
        ) {
            Text(
                text = text
            )
        }
    }

}

// Secondary

object SecondaryButton {
    @Composable
    fun Xlarge(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(48.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Large(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(44.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Medium(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(36.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.M,
                end = Space.M
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Small(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(32.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.XS,
                end = Space.XS
            )
        ) {
            Text(
                text = text
            )
        }
    }

    @Composable
    fun Tiny(
        text: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.height(28.dp),
            shape = Shape.RoundedRectangle,
            contentPadding = PaddingValues(
                start = Space.XS,
                end = Space.XS
            )
        ) {
            Text(
                text = text
            )
        }
    }
}