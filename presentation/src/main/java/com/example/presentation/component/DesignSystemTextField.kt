package com.example.presentation.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object DesignSystemTextField {
    object Outlined {
        @Composable
        fun Primary(
            text: String,
            onValueChange: (String) -> Unit,
            label: String,
            leadingIconName: String? = null,
            trailIconName: String? = null,
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = onValueChange,
                label = { Text(label) },
                leadingIcon = leadingIconName?.let { { DesignSystemIcon(name = it) } },
                trailingIcon = trailIconName?.let { { DesignSystemIcon(name = it) } },
                singleLine = true
            )
        }
    }
}

