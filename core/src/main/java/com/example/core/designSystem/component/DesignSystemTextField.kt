package com.example.core.designSystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.icon.Invisibility
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.icon.Visibility
import com.example.core.designSystem.theme.DesignSystemTheme

enum class TextFieldVariant {
    TEXT, PASSWORD, SEARCH
}

@Composable
fun DesignSystemTextField(
    variant: TextFieldVariant = TextFieldVariant.TEXT,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onIconClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    placeholder: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 2,
) {
    val color = DesignSystemTheme.colorSet.textField
    val iconColor = color.icon
    var visibility by remember { mutableStateOf(value = false) }

    val state = remember { TextFieldState("Hello") }

    BasicTextField(
        state = state

    )

//    OutlinedTextField(
//        value = value,
//        onValueChange = {
//            onValueChange(it)
//        },
//        modifier = Modifier
//            .fillMaxWidth(),
//        enabled = enabled,
//        readOnly = readOnly,
//        placeholder = {
//            placeholder?.let {
//                DesignSystemText(
//                    text = it,
//                    color = DesignSystemTheme.colorSet.textField.placeholder,
//                    style = DesignSystemTheme.typography.subTypography10.medium
//                )
//            }
//        },
//        textStyle = DesignSystemTheme.typography.subTypography10.medium,
//        leadingIcon = {
//            when (variant) {
//                TextFieldVariant.SEARCH -> {
//                    DesignSystemIcon(
//                        icon = Search,
//                        color = iconColor,
//                        ariaLabel = ""
//                    )
//                }
//                else -> null
//            }
//        },
//        trailingIcon = {
//            when (variant) {
//                TextFieldVariant.TEXT,
//                TextFieldVariant.SEARCH -> {
//                    DesignSystemIconButton(
//                        icon = Close,
//                        onClick = { onIconClick?.invoke() },
//                        ariaLabel = ""
//                    )
//                }
//
//                TextFieldVariant.PASSWORD -> {
//                    DesignSystemIconButton(
//                        icon = if (visibility) Visibility else Invisibility,
//                        onClick = { visibility = !visibility },
//                        ariaLabel = ""
//                    )
//                }
//            }
//        },
//        isError = isError,
//        keyboardOptions = keyboardOptions,
//        keyboardActions = keyboardActions,
//        singleLine = singleLine,
//        maxLines = maxLines,
//        shape = DesignSystemTheme.shape.textField,
////        colors = TextFieldColors(
////            focusedTextColor = color.main,
////            unfocusedTextColor = color.main,
////            disabledTextColor = color.disabled,
////            errorTextColor = color.error,
////            focusedContainerColor = color.container,
////            unfocusedContainerColor = color.container,
////            disabledContainerColor = color.container,
////            errorContainerColor = color.container,
////            cursorColor = color.main,
////            errorCursorColor = color.main,
////
////            textSelectionColors = TODO(),
////            focusedIndicatorColor = TODO(),
////            unfocusedIndicatorColor = TODO(),
////            disabledIndicatorColor = TODO(),
////            errorIndicatorColor = TODO(),
////            focusedLeadingIconColor = TODO(),
////            unfocusedLeadingIconColor = TODO(),
////            disabledLeadingIconColor = TODO(),
////            errorLeadingIconColor = TODO(),
////            focusedTrailingIconColor = TODO(),
////            unfocusedTrailingIconColor = TODO(),
////            disabledTrailingIconColor = TODO(),
////            errorTrailingIconColor = TODO(),
////            focusedLabelColor = TODO(),
////            unfocusedLabelColor = TODO(),
////            disabledLabelColor = TODO(),
////            errorLabelColor = TODO(),
////            focusedPlaceholderColor = TODO(),
////            unfocusedPlaceholderColor = TODO(),
////            disabledPlaceholderColor = TODO(),
////            errorPlaceholderColor = TODO(),
////            focusedSupportingTextColor = TODO(),
////            unfocusedSupportingTextColor = TODO(),
////            disabledSupportingTextColor = TODO(),
////            errorSupportingTextColor = TODO(),
////            focusedPrefixColor = TODO(),
////            unfocusedPrefixColor = TODO(),
////            disabledPrefixColor = TODO(),
////            errorPrefixColor = TODO(),
////            focusedSuffixColor = TODO(),
////            unfocusedSuffixColor = TODO(),
////            disabledSuffixColor = TODO(),
////            errorSuffixColor = TODO(),
////        )
//    )
}

@DesignSystemPreview
@Composable
fun DesignSystemTextFieldPreview() {
    var value by remember { mutableStateOf(TextFieldValue(""))}

    DesignSystemTheme {
        DesignSystemTextField(
            value = value,
            onValueChange = { value = it },
            placeholder = "preview"
        )
    }
}