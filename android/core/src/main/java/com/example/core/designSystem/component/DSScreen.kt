package com.example.core.designSystem.component

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.BackgroundColorSet
import com.example.core.util.extension.conditional

sealed interface ScreenVariant {
    data object Column : ScreenVariant
    data class ScrollColumn(
        val lazyListState: LazyListState? = null,
        val scrollVariant: ScrollVariant = ScrollVariant.ENTER_ALWAYS
    ) : ScreenVariant
    data class WebView(
        val url: String
    ) : ScreenVariant
}

enum class ScrollVariant {
    NONE, ENTER_ALWAYS, EXIT_UNTIL_COLLAPSED, PINNED
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberTopBarScrollBehavior(
    variant: ScreenVariant
): TopAppBarScrollBehavior? {
    val scrollVariant = when (variant) {
        is ScreenVariant.ScrollColumn -> variant.scrollVariant
        else -> ScrollVariant.NONE
    }
    val state = rememberTopAppBarState()
    return when (scrollVariant) {
        ScrollVariant.NONE -> null
        ScrollVariant.ENTER_ALWAYS -> TopAppBarDefaults.enterAlwaysScrollBehavior(state)
        ScrollVariant.EXIT_UNTIL_COLLAPSED -> TopAppBarDefaults.exitUntilCollapsedScrollBehavior(state)
        ScrollVariant.PINNED -> TopAppBarDefaults.pinnedScrollBehavior(state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DSScreen(
    variant: ScreenVariant = ScreenVariant.Column,
    topBar: @Composable (scrollBehavior: TopAppBarScrollBehavior?) -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackBarState: DSSnackBarState? = null,
    imePadding: Boolean = false,
    padding: Boolean = false,
    color: BackgroundColorSet = DSTheme.color.background,
    content: @Composable () -> Unit,
) {
    val topBarScrollBehavior = rememberTopBarScrollBehavior(variant)

    Scaffold(
        modifier = Modifier
            .conditional(topBarScrollBehavior != null) {
                nestedScroll(topBarScrollBehavior!!.nestedScrollConnection)
        },
        topBar = { topBar(topBarScrollBehavior) },
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
        val horizontalPadding = if (padding) DSTheme.dimension.dimension16 else 0.dp

        val combinedPadding = PaddingValues(
            start = horizontalPadding,
            top = paddingValues.calculateTopPadding(),
            end = horizontalPadding,
            bottom = paddingValues.calculateBottomPadding()
        )

        val modifier = Modifier
            .fillMaxSize()
            .padding(combinedPadding)
            .conditional(imePadding) {
                imePadding()
            }

        when (variant) {
            ScreenVariant.Column -> {
                Column(
                    modifier = modifier
                ) {
                    content()
                }
            }

            is ScreenVariant.ScrollColumn -> {
                val lazyListState = variant.lazyListState ?: rememberLazyListState()

                LazyColumn(
                    modifier = modifier,
                    state = lazyListState
                ) {
                    item {
                        content()
                    }
                }
            }

            is ScreenVariant.WebView -> {
                val context = LocalContext.current

                var loadedUrl by remember { mutableStateOf("") }

                val webView = remember(context) {
                    WebView(context).apply {
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
                        update = { view ->
                            if (variant.url.isNotEmpty() && loadedUrl != variant.url) {
                                view.loadUrl(variant.url)
                                loadedUrl = variant.url
                            }
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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


