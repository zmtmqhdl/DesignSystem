package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.presentation.screen.FirstScreen
import com.example.presentation.screen.MainScreen

@Composable
fun MainEntry(
    backStack: NavBackStack<NavKey>
) {
    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Main> {
                MainScreen(
                    backStack = backStack
                )
            }
        }
    )
}

@Composable
fun FirstEntry(
    backStack: NavBackStack<NavKey>
) {
    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.First> {
                FirstScreen(
                    backStack = backStack
                )
            }
        }
    )
}

@Composable
fun SecondEntry(
    backStack: NavBackStack<NavKey>
) {
    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.Second> {
                SecondEntry(
                    backStack = backStack
                )
            }
        }
    )
}