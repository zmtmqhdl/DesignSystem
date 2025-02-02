package com.example.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSingleColor
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimaryDialog(
    title: String? = null,
    certification: String? = null,
    subText: String? = null,
    text: String,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DesignSystemSingleColor.Gray600),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
        ) {
            Surface(
                shape = DesignSystemShape.PrimaryDialogShape,
                color = DesignSystemSingleColor.White
            ) {
                Column(
                    modifier = Modifier
                        .width(280.dp)
                        .padding(start = DesignSystemSpace.Space4, end = DesignSystemSpace.Space4),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(DesignSystemSpace.Space4))
                    title?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemSingleColor.Black,
                            style = DesignSystemFontStyle.XL.Bold
                        )
                    }
                    certification?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemColor.Primary.fontColor,
                            style = DesignSystemFontStyle.XXL.Regular
                        )
                    }
                    subText?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemSingleColor.Gray600,
                            style = DesignSystemFontStyle.S.Regular
                        )
                    }
                    Text(
                        text = text,
                        modifier = Modifier.padding(bottom = DesignSystemSpace.Space4),
                        color = DesignSystemSingleColor.Black,
                        style = DesignSystemFontStyle.M.Regular
                    )
                    content()
                    Spacer(modifier = Modifier.height(DesignSystemSpace.Space4))
                }
            }
        }
    }
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
            onClick: () -> Unit
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
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
            certification: String? = null,
            subText: String? = null,
            text: String,
            buttonText1: String,
            buttonText2: String,
            onClick1: () -> Unit,
            onClick2: () -> Unit
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
            ) {
                Column {
                    DesignSystemButton.CTA.Medium(
                        text = buttonText2,
                        onClick = onClick2,
                    )
                    Spacer(modifier = Modifier.height(DesignSystemSpace.Space3))
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
        ) {
            PrimaryDialog(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
            ) {
                Row {
                    DesignSystemButton.CTA.Medium(
                        text = buttonText2,
                        onClick = onClick2,
                        width = 120.dp
                    )
                    Spacer(modifier = Modifier.width(DesignSystemSpace.Space2))
                    DesignSystemButton.Primary.Medium(
                        text = buttonText1,
                        onClick = onClick1,
                        width = 120.dp
                    )
                }
            }
        }
    }
}

