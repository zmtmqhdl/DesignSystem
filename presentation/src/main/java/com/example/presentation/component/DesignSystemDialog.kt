package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.util.DesignSystemPreview

@Composable
fun PrimaryDialog(
    title: String? = null,
    certification: String? = null,
    subText: String? = null,
    text: String,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0.4f)

    Dialog(
        onDismissRequest = onDismissRequest,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = DesignSystemTheme.space.space8)
                    .background(
                        color = DesignSystemTheme.color.white,
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
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                    title?.let {
                        Text(
                            text = it,
                            color = DesignSystemTheme.color.black,
                            style = DesignSystemTheme.typography.xl.bold
                        )
                        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space2))
                    }
                    certification?.let {
                        Text(
                            text = it,
                            color = DesignSystemTheme.color.primary.fontColor,
                            style = DesignSystemTheme.typography.xxl.regular
                        )
                        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space2))
                    }
                    subText?.let {
                        Text(
                            text = it,
                            color = DesignSystemTheme.color.gray600,
                            style = DesignSystemTheme.typography.s.regular
                        )
                        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space2))
                    }
                    Text(
                        text = text,
                        color = DesignSystemTheme.color.black,
                        style = DesignSystemTheme.typography.m.regular
                    )
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                    content()
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space4))
                }
            }
        }
    )
}

object DesignSystemDialog {
    object Single {
        @Composable
        fun SingleArrangement(
            title: String? = null,
            certification: String? = null,
            subText: String? = null,
            text: String,
            buttonText: String,
            onClick: () -> Unit,
            onDismissRequest: () -> Unit
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
                onDismissRequest = onDismissRequest
            ) {
                DesignSystemButton.Primary.Medium(
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
            certification: String? = null,
            subText: String? = null,
            text: String,
            buttonText1: String,
            buttonText2: String,
            onClick1: () -> Unit,
            onClick2: () -> Unit,
            onDismissRequest: () -> Unit
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
                onDismissRequest = onDismissRequest
            ) {
                Column {
                    DesignSystemButton.Primary.Medium(
                        text = buttonText2,
                        onClick = onClick2,
                    )
                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space3))
                    DesignSystemButton.Primary.Medium(
                        text = buttonText1,
                        onClick = onClick1,
                    )
                }
            }
        }

        @Composable
        fun RowArrangement(
            title: String? = null,
            certification: String? = null,
            subText: String? = null,
            text: String,
            buttonText1: String,
            buttonText2: String,
            onClick1: () -> Unit,
            onClick2: () -> Unit,
            onDismissRequest: () -> Unit
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
                onDismissRequest = onDismissRequest
            ) {
                Row {
                    DesignSystemButton.Primary.Medium(
                        text = buttonText2,
                        onClick = onClick2,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(DesignSystemTheme.space.space2))
                    DesignSystemButton.Primary.Medium(
                        text = buttonText1,
                        onClick = onClick1,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemDialog_Single_SingleArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemDialog.Single.SingleArrangement(
            title = "title",
            certification = "certification",
            subText = "subText",
            text = "text",
            buttonText = "button",
            onClick = { },
            onDismissRequest = {}
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemDialog_Double_ColumnArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemDialog.Double.ColumnArrangement(
            title = "title",
            certification = "certification",
            subText = "subText",
            text = "text",
            buttonText1 = "button1",
            buttonText2 = "button2",
            onClick1 = { },
            onClick2 = { },
            onDismissRequest = {}
        )
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemDialog_Double_RowArrangement_Preview() {
    DesignSystemTheme {
        DesignSystemDialog.Double.RowArrangement(
            title = "title",
            certification = "certification",
            subText = "subText",
            text = "text",
            buttonText1 = "button1",
            buttonText2 = "button2",
            onClick1 = { },
            onClick2 = { },
            onDismissRequest = {}
        )
    }
}