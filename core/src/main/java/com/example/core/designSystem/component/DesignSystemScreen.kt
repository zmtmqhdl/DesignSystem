package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.core.designSystem.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun PrimaryScreen(
        containerColor: Color = DesignSystemTheme.color.background,
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = DesignSystemTheme.space.space4,
                    end = DesignSystemTheme.space.space4
                )
                .padding(WindowInsets.systemBars.asPaddingValues())
                .background(color = containerColor)
        ) {
            content()
        }
    }

    @Composable
    fun PrimaryScaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        containerColor: Color = DesignSystemTheme.color.background,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
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
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun WebViewScreen(
        url: String,
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
        }
    }
}
