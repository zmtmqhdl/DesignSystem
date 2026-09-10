package com.example.presentation.screen.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSNavigationBar
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTopBar
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.presentation.navigation.NavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val snackBarHostState = remember { DSSnackBarState() }
    val viewModel: MainViewModel = hiltViewModel()

    DSScreen(
        variant = ScreenVariant.ScrollColumn(
            scrollVariant = ScrollVariant.ENTER_ALWAYS
        ),
        topBar = { it ->
            DSTopBar(
                title = "test",
                scrollBehavior = it
            )
        },
        bottomBar = {
            DSNavigationBar(
                variant = NavigationBarVariant.ROUND,
                backStack = backStack,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.First
                ),
            )
        },
        snackBarState = snackBarHostState,
        padding = true
    ) {
        for (i in 0..999) {
            DSText(
                text = "ddd"

            )
        }
    }
}