package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.component.NavigationItem
import com.example.core.designSystem.icon.Close

sealed class NavigationItem(
    override val route: String,
    override val label: String? = null,
    override val selectedIcon: ImageVector = Close,
    override val unselectedIcon: ImageVector = Close
) : NavigationItem {
    data object Splash : com.example.presentation.navigation.NavigationItem("splash")
    data object Main : com.example.presentation.navigation.NavigationItem("main", "main")
    data object First : com.example.presentation.navigation.NavigationItem("first", "first")
    data object Second : com.example.presentation.navigation.NavigationItem("second", "second")
}