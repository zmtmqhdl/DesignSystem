package com.example.presentation.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.presentation.screen.MainScreen

@Composable
fun Content() {
    // view model
    val contentViewModel: ContentViewModel = hiltViewModel()

    // view model state value
    val loading by contentViewModel.loading.collectAsState()

    // local state
    val navController = rememberNavController()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        DesignSystemScreen.LoadingScreen(
            loading = loading,
            content = {
                MainScreen(navController = navController)
            }
        )
    }
}