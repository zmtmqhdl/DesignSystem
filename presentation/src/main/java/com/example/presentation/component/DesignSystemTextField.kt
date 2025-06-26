package com.example.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.example.presentation.component.Icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.presentation.core.DesignSystemPreview

object DesignSystemTextField {
    object Outlined {
        @Composable
        fun Primary(
            value: String,
            onValueChange: (String) -> Unit,
            modifier: Modifier = Modifier,
            width: Dp? = null,
            height: Dp = DesignSystemTheme.space.space9,
            enabled: Boolean = true,
            textStyle: TextStyle = DesignSystemTheme.typography.s.regular,
            label: String? = null,
            labelColor: Color = DesignSystemTheme.color.text,
            labelTextStyle: TextStyle = DesignSystemTheme.typography.s.regular,
            placeholder: String? = null,
            placeholderColor: Color = DesignSystemTheme.color.text,
            placeholderTextStyle: TextStyle = DesignSystemTheme.typography.s.regular,
            leadingIcon: ImageVector? = null,
            leadingIconColor: Color = DesignSystemTheme.color.inactiveIcon,
            leadingIconWidth: Dp = DesignSystemTheme.space.space4,
            leadingIconHeight: Dp = DesignSystemTheme.space.space4,
            trailIcon: ImageVector? = null,
            trailIconColor: Color = DesignSystemTheme.color.inactiveIcon,
            trailIconWidth: Dp = DesignSystemTheme.space.space4,
            trailIconHeight: Dp = DesignSystemTheme.space.space4,
            alwaysVisibleTrailIcon: Boolean = false,
            onTrailIconClick: (() -> Unit) = { },
            visualTransformation: VisualTransformation = VisualTransformation.None,
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier
                    .height(height)
                    .then(
                        if (width == null) {
                            Modifier.fillMaxWidth()
                        } else {
                            Modifier.width(width)
                        }
                    ),
                enabled = enabled,
                textStyle = textStyle,
                label = {
                    label?.let {
                        Text(
                            text = it,
                            color = labelColor,
                            style = labelTextStyle
                        )
                    }
                },
                placeholder = {
                    placeholder?.let {
                        Text(
                            text = it,
                            color = placeholderColor,
                            style = placeholderTextStyle
                        )
                    }
                },
                leadingIcon = leadingIcon?.let {
                    {
                        DesignSystemIcon(
                            icon = it,
                            color = leadingIconColor,
                            iconWidth = leadingIconWidth,
                            iconHeight = leadingIconHeight,
                        )
                    }
                },
                trailingIcon = trailIcon?.let {
                    {
                        if (alwaysVisibleTrailIcon) {
                            DesignSystemIcon(
                                icon = it,
                                color = trailIconColor,
                                iconWidth = trailIconWidth,
                                iconHeight = trailIconHeight,
                                onClick = onTrailIconClick
                            )
                        } else {
                            if (value.isNotBlank()) {
                                DesignSystemIcon(
                                    icon = it,
                                    color = trailIconColor,
                                    iconWidth = trailIconWidth,
                                    iconHeight = trailIconHeight,
                                    onClick = onTrailIconClick
                                )
                            }
                        }

                    }
                },
                visualTransformation = visualTransformation,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions.Default,
                singleLine = true,
                shape = DesignSystemTheme.shape.textField,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = DesignSystemTheme.color.text,
                    unfocusedTextColor = DesignSystemTheme.color.text,
                    focusedContainerColor = DesignSystemTheme.color.backgroundElevated,
                    unfocusedContainerColor = DesignSystemTheme.color.backgroundElevated,
                    focusedBorderColor = DesignSystemTheme.color.primary.outline,
                    cursorColor = DesignSystemTheme.color.primary.background,
                )
            )
        }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemTextField_Outlined_Primary_Preview() {

    var newValue by remember { mutableStateOf("") }

    DesignSystemTextField.Outlined.Primary(
        value = "",
        onValueChange = { newValue = it },
        label = "label",
        placeholder = "placeholder",
        leadingIcon = Close,
        trailIcon = Close,
    )
}