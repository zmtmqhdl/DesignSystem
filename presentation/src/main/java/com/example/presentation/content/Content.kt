package com.example.presentation.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.presentation.navigation.MainGraph
import com.example.presentation.screen.MainScreen

@Composable
fun Content() {
    // view model
    val viewModel: ContentViewModel = hiltViewModel()

    // view model state value
    val loading by viewModel.loading.collectAsState()

    // local state
    val navController = rememberNavController()

    // screen
    DesignSystemScreen.ContentScreen(
        loading = loading,
        content = {
            MainGraph(
                navController = navController
            )
        }
    )
}