package com.example.presentation.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.core.designSystem.component.DesignSystemContentLayout
import com.example.presentation.navigation.FirstEntry
import com.example.presentation.navigation.Route
import com.example.presentation.navigation.SecondEntry
import com.example.presentation.screen.MainScreen

@Composable
fun Content() {
    // view model
    val viewModel: ContentViewModel = hiltViewModel()

    // view model state value
    val loading by viewModel.loading.collectAsStateWithLifecycle()

    // local state
    val mainBackStack = rememberNavBackStack(Route.Main)

    // screen
    DesignSystemContentLayout(
        loading = loading,
        content = {
            NavDisplay(
                backStack = mainBackStack,
                onBack = {
                    if (mainBackStack.size > 1) {
                        mainBackStack.removeAt(
                            index = mainBackStack.size - 1
                        )
                    }
                },
                entryProvider = entryProvider {
                    entry<Route.Main> {
                        val backStack = rememberNavBackStack(Route.Main)

                        MainScreen(backStack = backStack
                        )
                    }

                    entry<Route.First> {
                        val backStack = rememberNavBackStack(Route.First)

                        FirstEntry(
                            backStack = backStack
                        )
                    }

                    entry<Route.Second> {
                        val backStack = rememberNavBackStack(Route.Second)

                        SecondEntry(
                            backStack = backStack
                        )
                    }
                }
            )
        }
    )
}