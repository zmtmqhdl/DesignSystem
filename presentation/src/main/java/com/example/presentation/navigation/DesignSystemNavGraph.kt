package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.presentation.Icon.close
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.NavScreen
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
        startDestination = Screen.Nav.route
    ) {
        composable(Screen.Nav.route) { NavScreen(navController = navController) }
    }
}

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) { MainScreen(navController) }
        composable(Screen.Second.route) { SecondScreen(navController) }
    }
}

//fun NavGraphBuilder.mainNavGraph(navController: NavController) {
//    navigation(
//        startDestination = Screen.Main.route,
//        route = "n"
//    ) {
//        composable(Screen.Main.route) { MainScreen(navController) }
//        composable(Screen.Second.route) { SecondScreen(navController) }
//    }
//}