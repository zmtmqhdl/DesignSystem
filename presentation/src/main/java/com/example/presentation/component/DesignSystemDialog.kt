package com.example.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimarySurface(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .width(280.dp)
            .wrapContentHeight()
    ) {
        Surface(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
                .padding(start = DesignSystemSpace.M, top = DesignSystemSpace.XXL, end = DesignSystemSpace.M, bottom = DesignSystemSpace.XXL),
            shape = DesignSystemShape.RoundedRectangle,
            color = DesignSystemColor.White,
        ) {}
        Surface() {
        }
    }
}

object DesignSystemDialog {
    object Single {
        @Composable
        fun Title(
            title: String,
            text: String,
            onConfirm: () -> Unit,
            onDismiss: () -> Unit,
            showDialog: Boolean
        ) {
            if (showDialog) {

            }
        }

        @Composable
        fun NoTitle() {

        }
    }



    object Double {
        @Composable
        fun Column() {}

        @Composable
        fun Row() {}
    }
}