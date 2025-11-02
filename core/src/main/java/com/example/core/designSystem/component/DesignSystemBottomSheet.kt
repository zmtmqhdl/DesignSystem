package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.BackgroundColorSet
import com.example.core.designSystem.theme.ColorSet
import com.example.core.designSystem.theme.DesignSystemTheme
import kotlinx.coroutines.launch

enum class BottomSheetVariant {
    CTA, DOUBLE_CTA
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignSystemBottomSheet(
    variant: BottomSheetVariant = BottomSheetVariant.CTA,
    title: String,
    description: String? = null,
    onDismissRequest: () -> Unit,
    confirmText: String,
    onConfirmClick: () -> Unit = {},
    cancelText: String = "",
    onCancelClick: () -> Unit = {},
    cancelButtonColor: ColorSet = DesignSystemTheme.colorSet.red,
    open: Boolean,
    colorSet: BackgroundColorSet = DesignSystemTheme.colorSet.background,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == SheetValue.Expanded && !open) {
            onDismissRequest()
        }
    }

    LaunchedEffect(open) {
        if (open) {
            scope.launch { sheetState.expand() }
        } else {
            scope.launch { sheetState.hide() }
        }
    }

    if (open || sheetState.currentValue != SheetValue.Hidden) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
                .padding(bottom = DesignSystemTheme.space.space2)
                .padding(horizontal = DesignSystemTheme.space.space2),
            shape = DesignSystemTheme.shape.bottomSheet,
            containerColor = colorSet.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = DesignSystemTheme.space.space4)
            ) {
                DesignSystemText(
                    text = title,
                    style = DesignSystemTheme.typography.typography4.bold,
                )

                description?.let {
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space2))

                    DesignSystemText(
                        text = it,
                        style = DesignSystemTheme.typography.typography6.medium
                    )
                }

                Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))

                when (variant) {
                    BottomSheetVariant.CTA -> {
                        DesignSystemButton(
                            text = confirmText,
                            onClick = onConfirmClick,
                            colorSet = DesignSystemTheme.colorSet.blue,
                            full = true
                        )
                    }
                    BottomSheetVariant.DOUBLE_CTA -> {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            DesignSystemButton(
                                text = cancelText,
                                onClick = onCancelClick,
                                colorSet = cancelButtonColor,
                                variant = ButtonVariant.WEAK,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(1f)
                            )

                            Spacer(modifier = Modifier.width(DesignSystemTheme.space.space2))

                            DesignSystemButton(
                                text = confirmText,
                                onClick = onConfirmClick,
                                colorSet = DesignSystemTheme.colorSet.blue,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@DesignSystemPreview
@Composable
fun DesignSystemBottomSheetPreview() {
    DesignSystemTheme {
        DesignSystemBottomSheet(
            variant = BottomSheetVariant.DOUBLE_CTA,
            title = "title",
            description = "description",
            confirmText = "confirm",
            cancelText = "cancel",
            onDismissRequest = {},
            open = true
        )
    }
}