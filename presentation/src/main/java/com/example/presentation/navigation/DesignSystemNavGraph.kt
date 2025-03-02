package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.example.presentation.screen.DesignSystemScreen

sealed class Screen(
    val route: String
) {
    data object Main: Screen("main")
    data object Second: Screen("second")
    data object BottomSheet: Screen("bottomSheet")
}

//@Composable
//fun DesignSystemNavGraph(
//    navController: NavController
//) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Main.route
//    )
//}