package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.core.designSystem.theme.DesignSystemTheme

enum class DialogVariant {
    ALERT,
    CONFIRM
}

@Composable
fun DesignSystemDialog(
    variant: DialogVariant = DialogVariant.ALERT,
    title: String,
    description: String? = null,

    onDismissRequest: (() -> Unit) = {},
    content: @Composable () -> Unit,
) {
//    (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0.4f)

    Dialog(
        onDismissRequest = onDismissRequest,
        content = {

            Column {
                Column (
                    modifier = Modifier
                        // dp 22
                        .padding(horizontal = DesignSystemTheme.space.space4)
                        .padding(top = DesignSystemTheme.space.space4)
                ) {
                    DesignSystemText(
                        text = title,
                        style = DesignSystemTheme.typography.typography4.bold,
                    )

                    description?.let {
                        DesignSystemText(
                            text = it,
                            style = DesignSystemTheme.typography.typography6.medium
                        )
                    }
                }


            }





            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = DesignSystemTheme.space.space8)
                    .background(
                        color = DesignSystemTheme.color.background.loadingBackground,
                        shape = DesignSystemTheme.shape.dialog
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = DesignSystemTheme.space.space4,
                            end = DesignSystemTheme.space.space4
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // gap 8
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                    title?.let {
                        Text(
                            text = it,
                            color = DesignSystemTheme.color.background.loadingBackground,
                            style = DesignSystemTheme.typography.xl.bold
                        )
                        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space2))
                    }


                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                    content()
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                }
            }
        }
    )
}