package com.example.core.designSystem.component

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil3.compose.SubcomposeAsyncImage
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

@Composable
fun DSImage(
    model: Any,
    modifier: Modifier = Modifier,
    width: Dp = DSTheme.space.dimension8,
    height: Dp = DSTheme.space.dimension8,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Crop,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    onSuccess: () -> Unit = {},
    onLoading: () -> Unit = {},
    onError: () -> Unit = {}
) {
    val clickModifier = if (onClick != null || onLongClick != null) {
        Modifier.combinedClickable(
            onClick = onClick ?: {},
            onLongClick = onLongClick
        )
    } else {
        Modifier
    }

    SubcomposeAsyncImage(
        model = model,
        modifier = modifier
            .width(width)
            .height(height)
            .then(clickModifier),
        contentDescription = contentDescription,
        contentScale = contentScale,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .skeletonAnimation(isLoading = true)
            )
        },
        onSuccess = { onSuccess() },
        onLoading = { onLoading() },
        error = {
            // error
        },
        onError = { onError() }
    )
}

@DSPreview
@Composable
fun DSImagePreview() {
    DSTheme {
        DSImage(
            model  = "https://picsum.photos/id/237/200/200",
            contentDescription = "contentDescription"
        )
    }
}