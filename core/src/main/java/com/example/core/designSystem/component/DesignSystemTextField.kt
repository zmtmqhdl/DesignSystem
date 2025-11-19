package com.example.core.designSystem.component

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Cancel
import com.example.core.designSystem.icon.Invisibility
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.icon.Visibility
import com.example.core.designSystem.theme.DesignSystemTheme

enum class TextFieldVariant {
    TEXT, PASSWORD, NUMBER, SEARCH, EMAIL
}

@Composable
fun DesignSystemTextField(
    variant: TextFieldVariant = TextFieldVariant.TEXT,
    state: TextFieldState,
    onKeyboardActionClick: () -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    placeholder: String? = null,
    singleLine: Boolean = true,
    minHeightInLines: Int = 1,
    maxHeightInLines: Int = Int.MAX_VALUE,
) {
    val color = DesignSystemTheme.colorSet.textField
    val textColor = color.main
    val textStyle = DesignSystemTheme.typography.subTypography10.medium
    var visibility by remember { mutableStateOf(value = false) }


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
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        textStyle = textStyle,
        keyboardOptions = when (variant) {
            TextFieldVariant.TEXT -> KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )

            TextFieldVariant.PASSWORD -> KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )

            TextFieldVariant.NUMBER -> KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )

            TextFieldVariant.SEARCH -> KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            )

            TextFieldVariant.EMAIL -> KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        },
        onKeyboardAction = KeyboardActionHandler { onKeyboardActionClick() },
        lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.MultiLine(
            minHeightInLines = minHeightInLines,
            maxHeightInLines = maxHeightInLines
        ),
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
                    if (placeholder != null && state.text.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = textStyle,
                            color = color.placeholder,
                        )
                    }

                    innerTextField()
                }

                when (variant) {
                    TextFieldVariant.TEXT,
                    TextFieldVariant.NUMBER,
                    TextFieldVariant.EMAIL,
                    TextFieldVariant.SEARCH -> DesignSystemIconButton(
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
                        icon = if (visibility) Invisibility else Visibility,
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
            variant = TextFieldVariant.SEARCH
        )
    }
}