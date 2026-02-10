package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.NavigationItem
import com.example.core.designSystem.icon.Close

sealed class NavigationItems (
    override val label: String,
    override val icon: ImageVector = Close,
) : NavigationItem {
    data object Main : NavigationItems(
        label = "main"
    ) {
        override val route: NavKey = Route.Main
    }

    data object First : NavigationItems(
        label = "first"
    ) {
        override val route: NavKey = Route.First
    }

    data class Test(val id: Int) : NavigationItems(
        label = "test"
    ) {
        override val route: NavKey = Route.Test(id)
    }
}