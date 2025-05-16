package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.presentation.Icon.Close

sealed class NavGraphItem(
    val route: String,
    val label: String? = null,
    val selectedIcon: ImageVector = Close,
    val unselectedIcon: ImageVector = Close
) {
    data object Splash : NavGraphItem(
        route = "splash"
    )

    data object Main : NavGraphItem(
        route = "main",
        label = "main",
        selectedIcon = Close,
        unselectedIcon = Close
    )

    data object First : NavGraphItem(
        route = "first",
        label = "first",
        selectedIcon = Close,
        unselectedIcon = Close
    )

    data object Second : NavGraphItem(
        route = "second",
        label = "second",
        selectedIcon = Close,
        unselectedIcon = Close
    )
}