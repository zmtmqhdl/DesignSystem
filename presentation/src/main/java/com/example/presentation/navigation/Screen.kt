package com.example.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.presentation.Icon.close

sealed class Screen(
    val route: String,
    val label: String? = null,
    val selectedIcon: ImageVector = close,
    val unselectedIcon: ImageVector = close
) {
    data object Splash : Screen(
        route = "splash"
    )

    data object Main : Screen(
        route = "main",
        label = "main",
        selectedIcon = close,
        unselectedIcon = close
    )

    data object First : Screen(
        route = "first",
        label = "first",
        selectedIcon = close,
        unselectedIcon = close
    )

    data object Second : Screen(
        route = "second",
        label = "second",
        selectedIcon = close,
        unselectedIcon = close
    )
}