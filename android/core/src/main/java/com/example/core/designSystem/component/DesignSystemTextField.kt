package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.core.R
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Cancel
import com.example.core.designSystem.icon.Invisibility
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.icon.Visibility
import com.example.core.designSystem.theme.DesignSystemTheme

enum class TextFieldVariant {
    TEXT, PASSWORD, NUMBER, SEARCH, EMAIL, PHONE_NUMBER
}

@Composable
fun DesignSystemTextField(
    variant: TextFieldVariant = TextFieldVariant.TEXT,
    state: TextFieldState,
    onKeyboardActionClick: () -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    imeAction: ImeAction = ImeAction.Default,
    placeholder: String? = null,
    singleLine: Boolean = true,
    minHeightInLines: Int = 1,
    maxHeightInLines: Int = Int.MAX_VALUE,
) {
    val color = DesignSystemTheme.color.textField
    val textColor = color.main
    val textStyle = DesignSystemTheme.typography.subTypography10.medium
    var visibility by remember { mutableStateOf(value = false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = color.container,
                shape = DesignSystemTheme.shape.textField
            )
            .padding(
                horizontal = DesignSystemTheme.space.space2,
                vertical = DesignSystemTheme.space.space1
            ),
        enabled = enabled,
        readOnly = readOnly,
        inputTransformation =
            when (variant) {
                TextFieldVariant.TEXT,
                TextFieldVariant.SEARCH -> null

                TextFieldVariant.NUMBER,
                TextFieldVariant.PHONE_NUMBER -> InputTransformation {
                    if (!asCharSequence().all { it.isDigit() }) {
                        revertAllChanges()
                    }
                }

                TextFieldVariant.EMAIL -> InputTransformation {
                    if (!asCharSequence().all {
                            it.isLetterOrDigit() || it == '@' || it == '.'
                        }
                    ) {
                        revertAllChanges()
                    }
                }

                TextFieldVariant.PASSWORD -> InputTransformation {
                    if (!asCharSequence().all {
                            it.isLetterOrDigit() ||
                                    "!@#$%^&*()_+-=[]{}|;:'\",.<>?/".contains(it)
                        }
                    ) {
                        revertAllChanges()
                    }
                }
            },
        outputTransformation = when (variant) {
            TextFieldVariant.TEXT,
            TextFieldVariant.SEARCH,
            TextFieldVariant.NUMBER,
            TextFieldVariant.PHONE_NUMBER,
            TextFieldVariant.EMAIL -> null

            TextFieldVariant.PASSWORD -> {
                if (visibility) {
                    null
                } else {
                    OutputTransformation {
                        val length = asCharSequence().length
                        replace(
                            start = 0,
                            end = length,
                            text = "•".repeat(length)
                        )
                    }
                }
            }
        },
        textStyle = textStyle,
        keyboardOptions = when (variant) {
            TextFieldVariant.TEXT,
            TextFieldVariant.SEARCH -> KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = imeAction
            )

            TextFieldVariant.PASSWORD -> KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = imeAction
            )

            TextFieldVariant.NUMBER,
            TextFieldVariant.PHONE_NUMBER -> KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = imeAction
            )

            TextFieldVariant.EMAIL -> KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = imeAction
            )
        },
        onKeyboardAction = KeyboardActionHandler { onKeyboardActionClick() },
        lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.MultiLine(
            minHeightInLines = minHeightInLines,
            maxHeightInLines = maxHeightInLines
        ),
        interactionSource = interactionSource,
        cursorBrush = SolidColor(
            value = textColor
        ),
        decorator = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when (variant) {
                    TextFieldVariant.SEARCH -> DesignSystemIcon(
                        icon = Search,
                        ariaLabel = stringResource(id = R.string.aria_label_search),
                    )

                    else -> {}
                }

                Box(modifier = Modifier.weight(1f)) {
                    if (placeholder != null && state.text.isEmpty() && !isFocused) {
                        DesignSystemText(
                            text = placeholder,
                            style = textStyle,
                            color = color.placeholder
                        )
                    }

                    innerTextField()
                }

                when (variant) {
                    TextFieldVariant.TEXT,
                    TextFieldVariant.NUMBER,
                    TextFieldVariant.EMAIL,
                    TextFieldVariant.SEARCH,
                    TextFieldVariant.PHONE_NUMBER -> DesignSystemIconButton(
                        icon = Cancel,
                        onClick = {
                            state.edit {
                                replace(
                                    start = 0,
                                    end = state.text.length,
                                    text = ""
                                )
                            }
                        },
                        ariaLabel = stringResource(id = R.string.aria_label_text_clear)
                    )

                    TextFieldVariant.PASSWORD -> DesignSystemIconButton(
                        icon = if (visibility) Visibility else Invisibility,
                        onClick = { visibility = !visibility },
                        ariaLabel = stringResource(id = if (visibility) R.string.aria_label_hide_password else R.string.aria_label_show_password)
                    )
                }
            }
        }
    )
}

@DesignSystemPreview
@Composable
fun DesignSystemTextFieldPreview() {
    val state = rememberTextFieldState()

    DesignSystemTheme {
        DesignSystemTextField(
            state = state,
            placeholder = "placeholder",
            onKeyboardActionClick = {},
            variant = TextFieldVariant.PASSWORD
        )
    }
}