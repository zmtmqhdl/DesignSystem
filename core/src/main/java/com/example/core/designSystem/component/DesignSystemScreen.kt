package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.core.designSystem.core.conditional
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.core.designSystem.theme.scheme.BackgroundColorSet

enum class ScreenVariant {
    COLUMN, LAZY_COLUMN, WEB_VIEW
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DesignSystemScreen(
    variant: ScreenVariant = ScreenVariant.LAZY_COLUMN,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackBarHost: @Composable () -> Unit = {},
    imePadding: Boolean = false,
    padding: Boolean = false,
    color: BackgroundColorSet = DesignSystemTheme.color.background,
    url: String? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackBarHost,
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
                            padding(horizontal = DesignSystemTheme.space.space4)
                        }

                ) {
                    content()
                }
            }

            ScreenVariant.LAZY_COLUMN -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .conditional(condition = imePadding) {
                            imePadding()
                        }
                        .conditional(condition = padding) {
                            padding(horizontal = DesignSystemTheme.space.space4)
                        }
                ) {
                    item {
                        content()
                    }
                }
            }

            ScreenVariant.WEB_VIEW -> {
                url?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        AndroidView(
                            modifier = Modifier.fillMaxSize(),
                            factory = { context ->
                                WebView(context).apply {
                                    settings.javaScriptEnabled = true
                                    settings.domStorageEnabled = true
                                    loadUrl(it)
                                }
                            }
                        )
                    }
                }
            }
        }

    }
}
