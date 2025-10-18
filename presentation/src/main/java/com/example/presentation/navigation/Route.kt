package com.example.presentation.navigation

import NavigationItem
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.icon.Close

sealed class MainRoute(
    override val route: String,
    override val label: String? = null,
    override val selectedIcon: ImageVector = Close,
    override val unselectedIcon: ImageVector = Close
) : NavigationItem {
    data object Splash : MainRoute(
        route = "splash"
    )
    data object Main : MainRoute(
        route = "main",
        label = "main"
    )
}