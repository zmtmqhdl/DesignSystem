package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        snackBarHost: SnackbarHostState? = null,
        content: @Composable () -> Unit
    ) {
        Scaffold(
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = { snackBarHost?.let { SnackbarHost(hostState = it) } },
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
}
