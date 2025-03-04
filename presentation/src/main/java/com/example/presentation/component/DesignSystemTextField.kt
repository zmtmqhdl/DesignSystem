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
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.Icon.close
import com.example.presentation.theme.DesignSystemTheme

object DesignSystemTextField {
    object Outlined {
        @Composable
        fun Primary(
            value: String,
            onValueChange: (String) -> Unit,
            label: String? = null,
            placeholder: @Composable (() -> Unit)? = null,
            leadingIcon: ImageVector? = null,
            trailIcon: ImageVector? = null,
            visualTransformation: VisualTransformation = VisualTransformation.None,
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { label?.let { Text(it) } },
                placeholder = { placeholder?.let { it() } },
                leadingIcon = leadingIcon?.let { { DesignSystemIcon(name = it) } },
                trailingIcon = trailIcon?.let { { DesignSystemIcon(name = it) } },
                visualTransformation = visualTransformation,
                singleLine = true,
                shape = DesignSystemTheme.shape.textField
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DesignSystemTextField_Outlined_Primary() {

    var newValue by remember { mutableStateOf("")}

    DesignSystemTextField.Outlined.Primary(
        value = " ",
        onValueChange = { newValue = it },
        label = "label",
        leadingIcon = close,
        trailIcon = close,
    )
}
