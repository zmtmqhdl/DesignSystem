package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryModal(
    title: String? = null,
    text: String,
    onDismissRequest: () -> Unit,
    show: Boolean,
    content: @Composable () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == SheetValue.Expanded && !show) {
            onDismissRequest()
        }
    }

    LaunchedEffect(show) {
        if (show) {
            scope.launch { sheetState.expand() }
        } else {
            scope.launch { sheetState.hide() }
        }
    }

    if (show || sheetState.currentValue != SheetValue.Hidden) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier.padding(
                start = DesignSystemTheme.space.space2,
                end = DesignSystemTheme.space.space2,
                bottom = DesignSystemTheme.space.space2
            ),
            shape = DesignSystemTheme.shape.bottomSheet,
            containerColor = DesignSystemTheme.color.white,
            dragHandle = null
        ) {
            Surface(
                color = DesignSystemTheme.color.white,
                modifier = Modifier.padding(
                    start = DesignSystemTheme.space.space4,
                    end = DesignSystemTheme.space.space4,
                    bottom = DesignSystemTheme.space.space4
                )
            ) {
                Column {
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space10))
                    title?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemTheme.space.space2),
                            color = DesignSystemTheme.color.black,
                            style = DesignSystemTheme.typography.xl.bold
                        )
                    }

                    Text(
                        text = text,
                        modifier = Modifier.padding(bottom = DesignSystemTheme.space.space4),
                        color = DesignSystemTheme.color.black,
                        style = DesignSystemTheme.typography.m.regular
                    )
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space6))
                    content()
                }
            }
        }
    }
}


object DesignSystemBottomSheet {
    object Modal {
        object Single {
            @Composable
            fun SingleArrangement(
                title: String? = null,
                text: String,
                onDismissRequest: () -> Unit,
                show: Boolean,
                buttonText: String,
                onClick: () -> Unit,
            ) {
                PrimaryModal(
                    title = title,
                    text = text,
                    onDismissRequest = onDismissRequest,
                    show = show,
                ) {
                    DesignSystemButton.CTA.Medium(
                        text = buttonText,
                        onClick = onClick,
                    )
                }
            }
        }

        object Double {
            @Composable
            fun ColumnArrangement() {
            }

            @Composable
            fun RowArrangement() {
            }
        }
    }
}