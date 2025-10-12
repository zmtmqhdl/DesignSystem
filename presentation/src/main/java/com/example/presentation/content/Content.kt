package com.example.presentation.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.presentation.screen.MainScreen

@Composable
fun Content() {
    // view model
    val contentViewModel: ContentViewModel = hiltViewModel()

    // view model state value
    val loading by contentViewModel.loading.collectAsState()

    // local state
    val navController = rememberNavController()

    // screen
    DesignSystemScreen.ContentScreen(
        loading = loading,
        content = {
            MainScreen(navController = navController)
        }
    )
}