package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.example.core.designSystem.theme.DesignSystemSpaces
import com.example.core.designSystem.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun Screen(
        containerColor: Color = DesignSystemTheme.color.background,
        imePadding: Boolean = false,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(if (imePadding) Modifier.imePadding() else Modifier)
                .padding(horizontal = DesignSystemSpaces.Space4)
                .background(color = containerColor)
        ) {
            content()
        }
    }

    @Composable
    fun Scaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        containerColor: Color = DesignSystemTheme.color.background,
        imePadding: Boolean = false,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .then(if (imePadding) Modifier.imePadding() else Modifier)
                .padding(horizontal = DesignSystemSpaces.Space4)
            ,
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackBarHost,
            containerColor = containerColor
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)

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
            modifier = Modifier
                .fillMaxSize()
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

    @Composable
    fun LoadingScreen(
        containerColor: Color = DesignSystemTheme.color.background,
        loading: Boolean,
        loadingColor: Color = DesignSystemTheme.color.primary.background,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = containerColor)
        ) {
            content()

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
}
