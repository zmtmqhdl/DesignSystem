package com.example.presentation.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.presentation.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun PrimaryScreen(
        color: Color = DesignSystemTheme.color.white,
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = DesignSystemTheme.space.space4,
                    end = DesignSystemTheme.space.space4
                )
                .padding(WindowInsets.systemBars.asPaddingValues())
                .background(color = color)
        ) {
            content()
        }
    }

    @Composable
    fun PrimaryScaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        color: Color,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.padding(WindowInsets.navigationBars.asPaddingValues()),
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackBarHost,
            containerColor = color
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

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun WebViewScreen(url: String) {
        if (url.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Invalid URL",
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
