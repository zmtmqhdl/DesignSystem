package com.example.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.example.presentation.Icon.Close
import com.example.presentation.common.IconPosition
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.util.DesignSystemPreview

@Composable
fun DesignSystemIcon(
    name: ImageVector,
    text: String? = null,
    onClick: (() -> Unit)? = null,
    size: Dp = DesignSystemTheme.space.space4,
    color: Color = DesignSystemTheme.color.black,
    iconPosition: IconPosition = IconPosition.DEFAULT,
) {
    when (iconPosition) {
        IconPosition.DEFAULT ->
            Icon(
                imageVector = name,
                contentDescription = text,
                modifier = if (onClick != null) {
                    Modifier
                        .size(size)
                        .clickable {
                            onClick()
                        }
                } else {
                    Modifier.size(size)
                },
                tint = color
            )

        IconPosition.LEFT ->
            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Icon(
                    imageVector = name,
                    contentDescription = text,
                    modifier = if (onClick != null) {
                        Modifier
                            .size(size)
                            .clickable {
                                onClick()
                            }
                    } else {
                        Modifier.size(size)
                    },
                    tint = color
                )
                Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
            }

        IconPosition.RIGHT ->
            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
                Icon(
                    imageVector = name,
                    contentDescription = text,
                    modifier = if (onClick != null) {
                        Modifier
                            .size(size)
                            .clickable {
                                onClick()
                            }
                    } else {
                        Modifier.size(size)
                    },
                    tint = color
                )
            }
    }
}

@DesignSystemPreview
@Composable
private fun DesignSystemIconPreview() {
    DesignSystemIcon(
        name = Close,
        text = "Icon",
        onClick = { },
    )
}