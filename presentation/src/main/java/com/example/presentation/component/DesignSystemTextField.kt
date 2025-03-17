package com.example.presentation.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import com.example.presentation.Icon.Close
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.util.DesignSystemPreview

object DesignSystemTextField {
    object Outlined {
        @Composable
        fun Primary(
            value: String,
            onValueChange: (String) -> Unit,
            label: String? = null,
            placeholder: String? = null,
            leadingIcon: ImageVector? = null,
            trailIcon: ImageVector? = null,
            visualTransformation: VisualTransformation = VisualTransformation.None,
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { label?.let { Text(it) } },
                placeholder = { placeholder?.let { Text(it) } },
                leadingIcon = leadingIcon?.let { { DesignSystemIcon(name = it) } },
                trailingIcon = trailIcon?.let { { DesignSystemIcon(name = it) } },
                visualTransformation = visualTransformation,
                singleLine = true,
                shape = DesignSystemTheme.shape.textField
            )
        }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemTextField_Outlined_Primary_Preview() {

    var newValue by remember { mutableStateOf("")}

    DesignSystemTextField.Outlined.Primary(
        value = "",
        onValueChange = { newValue = it },
        label = "label",
        placeholder = "placeholder",
        leadingIcon = Close,
        trailIcon = Close,
    )
}
