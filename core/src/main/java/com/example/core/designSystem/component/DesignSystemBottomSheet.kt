package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.scheme.BackgroundColorSet
import com.example.core.designSystem.theme.scheme.ColorSet
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
    cancelButtonColorSet: ColorSet = DesignSystemTheme.color.red,
    isOpen: Boolean,
    backgroundColorSet: BackgroundColorSet = DesignSystemTheme.color.background,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    val onClickDismiss = remember(sheetState, scope, onDismissRequest) {
        { onClick: () -> Unit ->
            scope.launch {
                onClick()
                sheetState.hide()
                onDismissRequest()
            }
        }
    }

    LaunchedEffect(isOpen) {
        if (isOpen) {
            sheetState.show()
        }
    }

    if (isOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 8.dp),
            shape = DesignSystemTheme.shape.bottomSheet,
            containerColor = backgroundColorSet.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            ) {
                DesignSystemText(
                    text = title,
                    style = DesignSystemTheme.typography.typography4.bold,
                )

                description?.let {
                    Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space2))

                    DesignSystemText(
                        text = it,
                        style = DesignSystemTheme.typography.typography6.medium
                    )
                }

                Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space8))

                when (variant) {
                    BottomSheetVariant.CTA -> {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            DesignSystemButton(
                                text = confirmText,
                                onClick = {
                                    onClickDismiss {
                                        onConfirmClick()
                                    }
                                },
                                colorSet = DesignSystemTheme.color.blue,
                                full = true
                            )
                        }
                    }

                    BottomSheetVariant.DOUBLE_CTA -> {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            DesignSystemButton(
                                text = cancelText,
                                onClick = {
                                    onClickDismiss {
                                        onCancelClick()
                                    }
                                },
                                colorSet = cancelButtonColorSet,
                                variant = ButtonVariant.WEAK,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(weight = 1f)
                            )

                            Spacer(modifier = Modifier.width(width = DesignSystemTheme.space.space2))

                            DesignSystemButton(
                                text = confirmText,
                                onClick = {
                                    onClickDismiss {
                                        onConfirmClick()
                                    }
                                },
                                colorSet = DesignSystemTheme.color.blue,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(weight = 1f)
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
fun BottomSheetPreview() {
    DesignSystemTheme {
        DesignSystemBottomSheet(
            variant = BottomSheetVariant.CTA,
            title = "title",
            description = "description",
            confirmText = "confirm",
            cancelText = "cancel",
            onDismissRequest = {},
            isOpen = true
        )
    }
}