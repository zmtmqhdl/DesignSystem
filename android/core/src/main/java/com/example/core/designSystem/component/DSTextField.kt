package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.core.R
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.icon.Cancel
import com.example.core.designSystem.icon.Invisibility
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.icon.Visibility
import com.example.core.designSystem.theme.DSTheme
import com.example.core.util.extension.conditional

enum class TextFieldVariant {
    TEXT, PASSWORD, NUMBER, SEARCH, EMAIL, PHONE_NUMBER
}

@Composable
fun DSTextField(
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
    isLoading: Boolean = false
) {
    val color = DSTheme.color.textField
    val shape = DSTheme.shape.textField
    val textStyle = DSTheme.typography.subTypography10.medium
    var visibility by rememberSaveable { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .height(DSTheme.space.dimension12)
            .clip(shape)
            .conditional(condition = !isLoading) {
                background(
                    color = color.container,
                    shape = shape
                )
            }
            .skeletonAnimation(isLoading = isLoading)
            .padding(
                horizontal = DSTheme.space.dimension2,
                vertical = DSTheme.space.dimension1
            ),
        enabled = enabled && !isLoading,
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

                TextFieldVariant.EMAIL -> null
//                    InputTransformation {
//                    if (!asCharSequence().all {
//                            it.isLetterOrDigit() || it == '@' || it == '.'
//                        }
//                    ) {
//                        revertAllChanges()
//                    }
//                }
                TextFieldVariant.PASSWORD -> null
//                    InputTransformation {
//                    if (!asCharSequence().all {
//                            it.isLetterOrDigit() ||
//                                    "!@#$%^&*()_+-=[]{}|;:'\",.<>?/".contains(it)
//                        }
//                    ) {
//                        revertAllChanges()
//                    }

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
        keyboardOptions = KeyboardOptions(
            keyboardType = when (variant) {
                TextFieldVariant.TEXT,
                TextFieldVariant.SEARCH -> KeyboardType.Text

                TextFieldVariant.PASSWORD -> KeyboardType.Password
                TextFieldVariant.NUMBER -> KeyboardType.Number
                TextFieldVariant.PHONE_NUMBER -> KeyboardType.Phone
                TextFieldVariant.EMAIL -> KeyboardType.Email
            },
            imeAction = imeAction
        ),
        onKeyboardAction = KeyboardActionHandler { onKeyboardActionClick() },
        lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.MultiLine(
            minHeightInLines = minHeightInLines,
            maxHeightInLines = maxHeightInLines
        ),
        interactionSource = interactionSource,
        cursorBrush = SolidColor(
            value = color.main
        ),
        decorator = { innerTextField ->
            if (!isLoading) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    when (variant) {
                        TextFieldVariant.SEARCH -> {
                            DSIcon(
                                icon = Search,
                                ariaLabel = stringResource(id = R.string.aria_label_search),
                            )
                        }

                        else -> {
                            Spacer(modifier = Modifier.width(width = DSTheme.space.dimension4))
                        }
                    }

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (placeholder != null && state.text.isEmpty()) {
                            DSText(
                                text = placeholder,
                                maxLines = 1,
                                style = textStyle,
                                color = color.placeholder
                            )
                        }

                        innerTextField()
                    }

                    if (isFocused && state.text.isNotEmpty()) {
                        Spacer(modifier = Modifier.width(width = DSTheme.space.dimension1))

                        when (variant) {
                            TextFieldVariant.TEXT,
                            TextFieldVariant.NUMBER,
                            TextFieldVariant.EMAIL,
                            TextFieldVariant.SEARCH,
                            TextFieldVariant.PHONE_NUMBER -> {
                                DSIconButton(
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
                            }

                            TextFieldVariant.PASSWORD -> {
                                DSIconButton(
                                    icon = if (visibility) Visibility else Invisibility,
                                    onClick = { visibility = !visibility },
                                    ariaLabel = stringResource(id = if (visibility) R.string.aria_label_hide_password else R.string.aria_label_show_password)
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}


@DSPreview
@Composable
fun TextFieldPreview() {
    val state = rememberTextFieldState()

    DSTheme {
        DSTextField(
            state = state,
            placeholder = "placeholder",
            onKeyboardActionClick = {},
            variant = TextFieldVariant.PASSWORD
        )
    }
}