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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.DesignSystemColor
import com.example.presentation.theme.DesignSystemFontStyle
import com.example.presentation.theme.DesignSystemShape
import com.example.presentation.theme.DesignSystemSingleColor
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun Overlay(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DesignSystemSingleColor.Gray600),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun PrimarySurface(
    title: String = "",
    certification: String = "",
    subText: String = "",
    text: String,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(280.dp)
            .wrapContentHeight()
    ) {
        Surface(
            shape = DesignSystemShape.PrimaryButtonShape,
            color = DesignSystemSingleColor.White
        ) {
            Column(
                modifier = Modifier
                    .width(280.dp)
                    .padding(start = DesignSystemSpace.Space4, end = DesignSystemSpace.Space4),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(DesignSystemSpace.Space4))
                if (title != "") {
                    Text(
                        text = title,
                        modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                        color = DesignSystemSingleColor.Black,
                        style = DesignSystemFontStyle.XL.Bold
                    )
                }
                if (certification != "") {
                    Text(
                        text = certification,
                        modifier = Modifier.padding(bottom = DesignSystemSpace.Space2),
                        color = DesignSystemColor.Primary.fontColor,
                        style = DesignSystemFontStyle.XXL.Regular
                    )
                }
                if (subText != "") {
                    Text(
                        text = subText,
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

object DesignSystemDialog {
    object Single {
        @Composable
        fun Primary(
            title: String = "",
            certification: String = "",
            subTitle: String = "",
            text: String,
            buttonText: String,
            onClick: () -> Unit
        ) {
            PrimarySurface(
                title = title,
                certification = certification,
                subText = subTitle,
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
        fun Column(
            title: String = "",
            certification: String = "",
            subTitle: String = "",
            text: String,
            buttonText1: String,
            buttonText2: String,
            onClick1: () -> Unit,
            onClick2: () -> Unit
        ) {
            PrimarySurface(
                title = title,
                certification = certification,
                subText = subTitle,
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
        fun Row(
            title: String = "",
            certification: String = "",
            subTitle: String = "",
            text: String,
            buttonText1: String,
            buttonText2: String,
            onClick1: () -> Unit,
            onClick2: () -> Unit,
        ) {
            PrimarySurface(
                title = title,
                certification = certification,
                subText = subTitle,
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

