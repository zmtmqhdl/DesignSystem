package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.icon.Close

sealed class Route(
    val route: String,
    val label: String? = null,
    val selectedIcon: ImageVector = Close,
    val unselectedIcon: ImageVector = Close
) {
    data object Splash : Route(
        route = "splash"
    )

    data object Main : Route(
        route = "main",
        label = "main",
        selectedIcon = Close,
        unselectedIcon = Close
    )

    data object First : Route(
        route = "first",
        label = "first",
        selectedIcon = Close,
        unselectedIcon = Close
    )

    data object Second : Route(
        route = "second",
        label = "second",
        selectedIcon = Close,
        unselectedIcon = Close
    )
}