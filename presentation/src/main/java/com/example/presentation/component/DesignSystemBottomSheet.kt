package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
    content: @Composable () -> Unit,
    onDisMissRequest: () -> Unit,
    show: MutableState<Boolean>,
    state: SheetState
) {
    if (show.value) {
        ModalBottomSheet(
            onDismissRequest = onDisMissRequest,
            sheetState = state,
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
            ) {

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