package com.example.core.designSystem.component

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
    url: String,
    modifier: Modifier = Modifier,
    width: Dp = DSTheme.space.dimension8,
    height: Dp = DSTheme.space.dimension8,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Crop,
    onSuccess: () -> Unit = {},
    onLoading: () -> Unit = {},
    onError: () -> Unit = {}
) {
    SubcomposeAsyncImage(
        model = url,
        modifier = modifier
            .width(width)
            .height(height),
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
            url  = "https://picsum.photos/id/237/200/200",
            contentDescription = "contentDescription"
        )
    }
}