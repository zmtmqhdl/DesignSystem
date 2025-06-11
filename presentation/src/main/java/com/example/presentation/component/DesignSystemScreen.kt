package com.example.presentation.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.presentation.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun PrimaryScreen(
        containerColor: Color = DesignSystemTheme.color.background,
        loading: Boolean = false,
        loadingColor: Color = DesignSystemTheme.color.primary.background,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = DesignSystemTheme.space.space4,
                        end = DesignSystemTheme.space.space4
                    )
                    .padding(WindowInsets.systemBars.asPaddingValues())
                    .background(color = containerColor)
            ) {
                content()
            }

            if (loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DesignSystemTheme.color.black.copy(alpha = 0.3f))
                        .clickable(enabled = false) {},
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(DesignSystemTheme.space.space12),
                        color = loadingColor,
                        strokeWidth = DesignSystemTheme.space.space1
                    )
                }
            }
        }
    }

    @Composable
    fun PrimaryScaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        containerColor: Color = DesignSystemTheme.color.background,
        loading: Boolean = false,
        loadingColor: Color = DesignSystemTheme.color.primary.background,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(
                topBar = topBar,
                bottomBar = bottomBar,
                snackbarHost = snackBarHost,
                containerColor = containerColor
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(
                            start = DesignSystemTheme.space.space4,
                            end = DesignSystemTheme.space.space4
                        )
                ) {
                    content()
                }
            }

            if (loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DesignSystemTheme.color.black.copy(alpha = 0.3f))
                        .clickable(enabled = false) {},
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(DesignSystemTheme.space.space12),
                        color = loadingColor,
                        strokeWidth = DesignSystemTheme.space.space1
                    )
                }
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun WebViewScreen(
        url: String,
        loading: Boolean = false,
        loadingColor: Color = DesignSystemTheme.color.primary.background,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    WebView(context).apply {
                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled = true
                        loadUrl(url)
                    }
                }
            )

            if (url.isEmpty() || loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DesignSystemTheme.color.black.copy(alpha = 0.3f))
                        .clickable(enabled = false) {},
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(DesignSystemTheme.space.space12),
                        color = loadingColor,
                        strokeWidth = DesignSystemTheme.space.space1
                    )

                }
            }
        }
    }
}
