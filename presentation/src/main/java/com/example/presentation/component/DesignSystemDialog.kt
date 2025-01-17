package com.example.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun Overlay() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {}
}

@Composable
fun PrimarySurface(
    title: String = "",
    certification: String = "",
    subTitle: String = "",
    text: String,
    content: @Composable () -> Unit
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
            color = DesignSystemSingleColor.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (title != "") {
                    Text(text = title, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = DesignSystemSingleColor.Black, style = DesignSystemFontStyle.XL.Bold)
                }
                if (certification != "") {
                    Text(text = certification, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = DesignSystemColor.Primary.fontColor, style = DesignSystemFontStyle.XXL.Regular)
                }
                if (subTitle != "") {
                    Text(text = subTitle, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = DesignSystemSingleColor.Gray600, style = DesignSystemFontStyle.S.Regular)
                }
                Text(text = text,color = DesignSystemSingleColor.Black, style = DesignSystemFontStyle.M.Regular)
            }
        }
        Surface(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
        ) {
            content()
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
                subTitle = subTitle,
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
        fun Column() {}

        @Composable
        fun Row() {}
    }
}