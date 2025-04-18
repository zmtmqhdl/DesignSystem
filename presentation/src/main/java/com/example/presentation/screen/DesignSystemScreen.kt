package com.example.presentation.screen

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.presentation.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun PrimaryScreen(
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier.padding(
                start = DesignSystemTheme.space.space4,
                end = DesignSystemTheme.space.space4
            )
        ) {
            content()
        }
    }

    @Composable
    fun PrimaryScaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.padding(WindowInsets.navigationBars.asPaddingValues()),
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackBarHost
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
    }

    @Composable
    fun WebViewScreen(url: String) {
        if (url.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Invalid URL",
                    style = XPhoneTheme.typography.detailSmall,
                    color = XPhoneTheme.colors.accent100
                )
            }
        } else {
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
        }
    }
}
