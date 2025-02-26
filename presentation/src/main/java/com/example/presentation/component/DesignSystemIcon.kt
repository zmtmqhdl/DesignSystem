package com.example.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.presentation.theme.DesignSystemSpace
import com.example.presentation.theme.DesignSystemTheme

@SuppressLint("DiscouragedApi")
@Composable
fun String.toDrawableRes(): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(this, "drawable", context.packageName)
}

@Composable
fun DesignSystemIcon(
    name: String,
    text: String? = null,
    color: Color = DesignSystemTheme.color.black,
    iconPosition: String? = null,
) {
    Icon(
        painter = painterResource(name.toDrawableRes()),
        contentDescription = text,
        tint = color,
        modifier = when (iconPosition) {
            "left" -> {
                Modifier.padding(end = DesignSystemTheme.space.space1)
            }
            "right" -> {
                Modifier.padding(start = DesignSystemTheme.space.space1)
            }
            else -> {
                Modifier
            }
        }

    )
}
