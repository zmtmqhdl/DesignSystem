package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.component.NavigationItem
import com.example.core.designSystem.icon.Close

sealed class NavigationItems(
    override val route: String,
    override val label: String,
    override val icon: ImageVector = Close,
) : NavigationItem {
    data object Main : NavigationItems(
        route = "main",
        label = "main"
    )
}