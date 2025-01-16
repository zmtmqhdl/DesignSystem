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
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.ProjectColor

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
    subText: String = "",
    text: String,
    buttonContent: @Composable () -> Unit
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
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (title != "") {
                    Text(text = title, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = DesignSystemColor.Black, style = DesignSystemFontStyle.XL.Bold)
                }
                if (certification != "") {
                    Text(text = certification, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = ProjectColor.PrimaryFontColor, style = DesignSystemFontStyle.XXL.Regular)
                }
                if (subText != "") {
                    Text(text = subText, modifier = Modifier.padding(bottom = DesignSystemSpace.XS), color = DesignSystemColor.Gray600, style = DesignSystemFontStyle.S.Regular)
                }
                Text(text = text,color = DesignSystemColor.Black, style = DesignSystemFontStyle.M.Regular)
            }
        }
        Surface(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
        ) {
            buttonContent()
        }
    }
}

object DesignSystemDialog {
    object Single {
        @Composable
        fun Primary(
            title: String = "",
            certification: String = "",
            subText: String = "",
            text: String,
            buttonText: String,
            onClick: () -> Unit
        ) {
            PrimarySurface(
                title = title,
                certification = certification,
                subText = subText,
                text = text,
            ) {
                DesignSystemButton.Primary.Large(
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