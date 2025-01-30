package com.example.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.presentation.theme.DesignSystemSingleColor
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun String.toDrawableRes(): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(this, "drawable", context.packageName)
}

@Composable
fun DesignSystemIcon(
    name: String,
    text: String? = null,
    color: Color = DesignSystemSingleColor.Black,
    iconPosition: String? = null,
) {
    Icon(
        painter = painterResource(id = name.toDrawableRes()),
        contentDescription = text,
        tint = color,
        modifier = if (iconPosition == "left") {
            Modifier.padding(end = DesignSystemSpace.Space1)
        } else if (iconPosition == "right") {
            Modifier.padding(start = DesignSystemSpace.Space1)
        } else {
            Modifier
        }

    )
}
