package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.component.NavigationItem
import com.example.core.designSystem.icon.Close

sealed class MainRoute(
    override val route: String,
    override val label: String? = null,
    override val selectedIcon: ImageVector = Close,
    override val unselectedIcon: ImageVector = Close
) : NavigationItem {
    data object Splash : MainRoute("splash")
    data object Main : MainRoute("main", "main")
    data object First : MainRoute("first", "first")
    data object Second : MainRoute("second", "second")
}