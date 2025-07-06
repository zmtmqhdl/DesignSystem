package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.component.NavigationItem
import com.example.core.designSystem.icon.Close

sealed class MyNavigationItem(
    override val route: String,
    override val label: String? = null,
    override val selectedIcon: ImageVector = Close,
    override val unselectedIcon: ImageVector = Close
) : NavigationItem {
    data object Splash : MyNavigationItem("splash")
    data object Main : MyNavigationItem("main", "main")
    data object First : MyNavigationItem("first", "first")
    data object Second : MyNavigationItem("second", "second")
}