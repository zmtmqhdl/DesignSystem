package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.presentation.util.DesignSystemPreview
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
            Column(
                modifier = Modifier.padding(
                    start = DesignSystemTheme.space.space4,
                    end = DesignSystemTheme.space.space4,
                    bottom = DesignSystemTheme.space.space4
                )
            ) {
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
            fun ColumnArrangement(
                title: String? = null,
                text: String,
                onDismissRequest: () -> Unit,
                show: Boolean,
                buttonText1: String,
                buttonText2: String,
                onClick1: () -> Unit,
                onClick2: () -> Unit,
            ) {
                PrimaryModal(
                    title = title,
                    text = text,
                    onDismissRequest = onDismissRequest,
                    show = show,
                ) {
                    Column {
                        DesignSystemButton.CTA.Medium(
                            text = buttonText1,
                            onClick = onClick1,
                        )
                        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space3))
                        DesignSystemButton.CTA.Medium(
                            text = buttonText2,
                            onClick = onClick2,
                        )
                    }
                }
            }

            @Composable
            fun RowArrangement(
                title: String? = null,
                text: String,
                onDismissRequest: () -> Unit,
                show: Boolean,
                buttonText1: String,
                buttonText2: String,
                onClick1: () -> Unit,
                onClick2: () -> Unit,
            ) {
                PrimaryModal(
                    title = title,
                    text = text,
                    onDismissRequest = onDismissRequest,
                    show = show,
                ) {
                    Row {
                        DesignSystemButton.CTA.Medium(
                            text = buttonText1,
                            onClick = onClick1,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(DesignSystemTheme.space.space2))
                        DesignSystemButton.CTA.Medium(
                            text = buttonText2,
                            onClick = onClick2,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemBottomSheet_Modal_Single_SingleArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemBottomSheet.Modal.Single.SingleArrangement(
            title = "title",
            text = "text",
            onDismissRequest = {},
            show = true,
            buttonText = "button",
            onClick = {}
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemBottomSheet_Modal_Double_ColumnArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemBottomSheet.Modal.Double.ColumnArrangement(
            title = "title",
            text = "text",
            onDismissRequest = {},
            show = true,
            buttonText1 = "button1",
            buttonText2 = "button2",
            onClick1 = {},
            onClick2 = {}
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemBottomSheet_Modal_Double_RowArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemBottomSheet.Modal.Double.RowArrangement(
            title = "title",
            text = "text",
            onDismissRequest = {},
            show = true,
            buttonText1 = "button1",
            buttonText2 = "button2",
            onClick1 = {},
            onClick2 = {}
        )
    }
}