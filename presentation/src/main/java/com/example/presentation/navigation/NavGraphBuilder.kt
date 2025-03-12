package com.example.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.presentation.screen.FirstScreen
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.SecondScreen
import com.example.presentation.screen.SplashScreen

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(Screen.Splash.route) { SplashScreen() }
    composable(Screen.Main.route) { MainScreen(navController = navController) }
}

fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(Screen.Main.route) { MainScreen(navController = navController) }
}

fun NavGraphBuilder.firstGraph(navController: NavController) {
    composable(Screen.First.route) { FirstScreen() }
}

fun NavGraphBuilder.secondGraph(navController: NavController) {
    composable(Screen.Second.route) { SecondScreen() }
}