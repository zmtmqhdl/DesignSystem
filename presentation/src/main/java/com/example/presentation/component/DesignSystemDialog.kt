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
import com.example.presentation.theme.DesignSystemScheme
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.DesignSystemTheme

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
            .background(color = DesignSystemTheme.color.gray600),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
        ) {
            Surface(
                shape = DesignSystemShape.PrimaryDialogShape,
                color = DesignSystemTheme.color.white
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
                            color = DesignSystemTheme.color.black,
                            style = DesignSystemTheme.typography.xl.bold
                        )
                    }
                    certification?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemTheme.color.primary.fontColor,
                            style = DesignSystemTheme.typography.xxl.regular
                        )
                    }
                    subText?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                            color = DesignSystemTheme.color.gray600,
                            style = DesignSystemTheme.typography.s.regular
                        )
                    }
                    Text(
                        text = text,
                        modifier = Modifier.padding(bottom = DesignSystemSpace.Space4),
                        color = DesignSystemTheme.color.black,
                        style = DesignSystemTheme.typography.m.regular
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

