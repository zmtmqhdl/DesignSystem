package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.core.designSystem.core.conditional
import com.example.core.designSystem.theme.BackgroundColorSet
import com.example.core.designSystem.theme.DesignSystemSpaces
import com.example.core.designSystem.theme.DesignSystemTheme

object DesignSystemScreen {
    @Composable
    fun ContentScreen(
        color: BackgroundColorSet = DesignSystemTheme.color.background,
        loading: Boolean,
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars)
                .background(color = color.background)
        ) {
            content()

            if (loading) {
                Dialog(
                    onDismissRequest = {},
                    properties = DialogProperties(
                        dismissOnClickOutside = false,
                        dismissOnBackPress = false,
                        usePlatformDefaultWidth = false
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = color.loadingBackground.copy(alpha = 0.3f)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(size = DesignSystemTheme.space.space12),
                            color = color.loadingBackground,
                            strokeWidth = DesignSystemTheme.space.space1
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Screen(
        imePadding: Boolean = false,
        padding: Boolean = false,
        color: BackgroundColorSet = DesignSystemTheme.color.background,
        content: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .conditional(condition = imePadding) {
                    imePadding()
                }
                .conditional(condition = padding) {
                    padding(horizontal = DesignSystemSpaces.Space4)
                }
                .background(color = color.background)
        ) {
            content()
        }
    }

    @Composable
    fun Scaffold(
        topBar: @Composable () -> Unit,
        bottomBar: @Composable () -> Unit,
        snackBarHost: @Composable () -> Unit,
        imePadding: Boolean = false,
        padding: Boolean = false,
        color: BackgroundColorSet = DesignSystemTheme.color.background,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackBarHost,
            containerColor = color.background,
        ) { paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .conditional(condition = imePadding) {
                        imePadding()
                    }
                    .conditional(condition = padding) {
                        padding(horizontal = DesignSystemSpaces.Space4)
                    }

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


}
