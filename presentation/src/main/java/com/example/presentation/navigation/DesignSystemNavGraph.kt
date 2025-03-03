package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.Icon.close
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.SecondScreen

sealed class Screen(
    val route: String,
    val label: String? = null,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Nav : Screen(
        route = "nav",
        label = "nav",
        selectedIcon = close,
        unselectedIcon = close
    )

    data object Main : Screen(
        route = "main",
        label = "main",
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

@Composable
fun DesignSystemNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) { MainScreen() }
        composable(Screen.Second.route) { SecondScreen() }
    }
}