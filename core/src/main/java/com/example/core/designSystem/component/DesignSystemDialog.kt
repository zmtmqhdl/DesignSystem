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
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.example.core.designSystem.theme.DesignSystemTheme

@Composable
fun DesignSystemDialog(
    title: String? = null,
    certification: String? = null,
    subText: String? = null,
    text: String,
    onDismissRequest: (() -> Unit) = {},
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