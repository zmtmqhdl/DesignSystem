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
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.modifier.conditional
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.BackgroundColorSet

enum class ScreenVariant {
    COLUMN,
    SCROLL_COLUMN,
    WEB_VIEW
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DSScreen(
    variant: ScreenVariant = ScreenVariant.COLUMN,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackBarState: DSSnackBarState? = null,
    imePadding: Boolean = false,
    padding: Boolean = false,
    scrollState: ScrollState = rememberScrollState(),
    color: BackgroundColorSet = DSTheme.color.background,
    url: String? = null,
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
        when (variant) {
            ScreenVariant.COLUMN -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .conditional(condition = imePadding) {
                            imePadding()
                        }
                        .conditional(condition = padding) {
                            padding(horizontal = DSTheme.space.space4)
                        }
                ) {
                    content()
                }
            }

            ScreenVariant.SCROLL_COLUMN -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = scrollState)
                        .padding(paddingValues)
                        .conditional(condition = imePadding) {
                            imePadding()
                        }
                        .conditional(condition = padding) {
                            padding(horizontal = DSTheme.space.space4)
                        }
                ) {
                    content()
                }
            }

            ScreenVariant.WEB_VIEW -> {
                val context = LocalContext.current
                val safeUrl = requireNotNull(url) {
                    "WEB_VIEW variant requires non-null url"
                }
                val webView = remember {
                    WebView(context).apply {
                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled = true
                    }
                }

                DisposableEffect(webView) {
                    onDispose {
                        webView.destroy()
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AndroidView(
                        modifier = Modifier.fillMaxSize(),
                        factory = { webView },
                        update = { view ->
                            if (view.url != safeUrl) {
                                view.loadUrl(safeUrl)
                            }
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
            variant = ScreenVariant.SCROLL_COLUMN
        ) {

        }
    }
}


