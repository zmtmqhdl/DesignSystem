package com.example.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.presentation.common.IconPosition
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun String.toDrawableResource(): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(this, "drawable", context.packageName)
}

@Composable
fun DesignSystemIcon(
    name: String,
    text: String? = null,
    color: Color = DesignSystemTheme.color.black,
    iconPosition: IconPosition = iconPosition.DEFAULT,
) {
    when (iconPosition) {
        iconPosition.DEFAULT ->
            Icon(
                painter = painterResource(name.toDrawableResource()),
                contentDescription = text,
                tint = color
            )

        iconPosition.LEFT ->
            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Icon(
                    painter = painterResource(name.toDrawableResource()),
                    contentDescription = text,
                    tint = color
                )
                Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
            }

        iconPosition.RIGHT ->
            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
                Icon(
                    painter = painterResource(name.toDrawableResource()),
                    contentDescription = text,
                    tint = color
                )
            }
    }
}
