package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.core.designSystem.core.DSPreview
import com.example.core.util.extension.conditional
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.BackgroundColorSet

sealed interface ScreenVariant {
    data object Column : ScreenVariant
    data object ScrollColumn : ScreenVariant
    data class WebView(
        val url: String
    ) : ScreenVariant
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DSScreen(
    variant: ScreenVariant = ScreenVariant.Column,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackBarState: DSSnackBarState? = null,
    imePadding: Boolean = false,
    padding: Boolean = false,
    scrollState: ScrollState = rememberScrollState(),
    color: BackgroundColorSet = DSTheme.color.background,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = {
            snackBarState?.let {
                DSSnackBar(
                    snackBarState = snackBarState
                )
            }
        },
        containerColor = color.background,
    ) { paddingValues ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .conditional(imePadding) {
                imePadding()
            }
            .conditional(padding) {
                padding(horizontal = DSTheme.space.dimension4)
            }

        when (variant) {
            ScreenVariant.Column -> {
                Column(
                    modifier = modifier
                ) {
                    content()
                }
            }

            ScreenVariant.ScrollColumn -> {
                Column(
                    modifier = modifier
                        .verticalScroll(state = scrollState)
                ) {
                    content()
                }
            }

            is ScreenVariant.WebView -> {
                val context = LocalContext.current

                val webView = remember {
                    WebView(context.applicationContext).apply {
                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled = true
                    }
                }

                DisposableEffect(webView) {
                    onDispose {
                        webView.stopLoading()
                        webView.clearHistory()
                        webView.removeAllViews()
                        webView.destroy()
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AndroidView(
                        modifier = modifier,
                        factory = { webView },
                        update = {
                            it.loadUrl(variant.url)
                        }
                    )
                }
            }
        }
    }
}

@DSPreview
@Composable
fun ScreenPreview() {
    DSTheme {
        DSScreen(
            variant = ScreenVariant.Column
        ) {

        }
    }
}


