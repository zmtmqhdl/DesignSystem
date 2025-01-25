package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSingleColor
import com.example.presentation.theme.DesignSystemSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryNudging(
    title: String? = null,
    text: String,
    content: @Composable () -> Unit,
    onDisMissRequest: () -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDisMissRequest,
        modifier = Modifier.padding(start = DesignSystemSpace.Space2, end = DesignSystemSpace.Space2, bottom = DesignSystemSpace.Space2),
        shape = DesignSystemShape.PrimaryBottomSheepShape,
        containerColor = DesignSystemSingleColor.White,
        dragHandle = null
    ) {
        Surface(
            color = DesignSystemSingleColor.White,
            modifier = Modifier
                .padding(start = DesignSystemSpace.Space4, end = DesignSystemSpace.Space4, bottom = DesignSystemSpace.Space4)
        ) {
            Column() {
                Spacer(modifier = Modifier.height(DesignSystemSpace.Space10))
                if (title != null) {
                    Text(
                        text = title,
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



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryModal(

) {

}



object DesignSystemBottomSheet {
    object Primary {
        object Nudging {
            object Single {
                @Composable
                fun SingleArrangement(
                    title: String? = null,
                ) {

                }
            }
            object Double {
                @Composable
                fun ColumnArrangement() {}

                @Composable
                fun RowArrangement() {}
            }
        }

        object Modal {
            object Modal {
                object Primary {
                    @Composable
                    fun Fixed () {}

                    @Composable
                    fun Draggable() {}
                }
            }
        }
    }
}