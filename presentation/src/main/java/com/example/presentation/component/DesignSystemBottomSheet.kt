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
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSingleColor
import com.example.presentation.theme.DesignSystemSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryModal(
    title: String? = null,
    text: String,
    onDismissRequest: () -> Unit,
    show: Boolean,
    content: @Composable () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    LaunchedEffect(show, sheetState.currentValue) {
        if (show) {
            sheetState.show()
        } else if (sheetState.currentValue == SheetValue.Hidden) {
            onDismissRequest()
        } else {
            sheetState.hide()
        }
    }

    if (show || sheetState.currentValue != SheetValue.Hidden) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier.padding(
                start = DesignSystemSpace.Space2,
                end = DesignSystemSpace.Space2,
                bottom = DesignSystemSpace.Space2
            ),
            shape = DesignSystemShape.PrimaryBottomSheepShape,
            containerColor = DesignSystemSingleColor.White,
            dragHandle = null
        ) {
            Surface(
                color = DesignSystemSingleColor.White,
                modifier = Modifier.padding(
                    start = DesignSystemSpace.Space4,
                    end = DesignSystemSpace.Space4,
                    bottom = DesignSystemSpace.Space4
                )
            ) {
                Column {
                    Spacer(modifier = Modifier.height(DesignSystemSpace.Space10))
                    title?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemSingleColor.Black,
                            style = DesignSystemFontStyle.XL.Bold
                        )
                    }

                    Text(
                        text = text,
                        modifier = Modifier.padding(bottom = DesignSystemSpace.Space4),
                        color = DesignSystemSingleColor.Black,
                        style = DesignSystemFontStyle.M.Regular
                    )
                    Spacer(modifier = Modifier.height(DesignSystemSpace.Space6))
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