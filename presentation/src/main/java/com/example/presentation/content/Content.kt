package com.example.presentation.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemContentLayout
import com.example.presentation.navigation.MainGraph

@Composable
fun Content() {
    // view model
    val viewModel: ContentViewModel = hiltViewModel()

    // view model state value
    val loading by viewModel.loading.collectAsStateWithLifecycle()

    // local state
    val navController = rememberNavController()

    // screen
    DesignSystemContentLayout(
        loading = loading,
        content = {
            MainGraph(
                navController = navController
            )
        }
    )
}