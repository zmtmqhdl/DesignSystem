package com.example.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.presentation.common.IconPosition
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun DesignSystemIcon(
    name: ImageVector,
    text: String? = null,
    onClick: () -> Unit,
    color: Color = DesignSystemTheme.color.black,
    iconPosition: IconPosition = IconPosition.DEFAULT,
) {
    when (iconPosition) {
        IconPosition.DEFAULT ->
            Icon(
                imageVector = name,
                contentDescription = text,
                modifier = Modifier.clickable {
                    onClick()
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
                    tint = color
                )
            }
    }
}
