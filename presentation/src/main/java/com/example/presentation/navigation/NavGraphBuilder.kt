package com.example.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screen.FirstScreen
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.SecondScreen

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    composable(MainRoute.Main.route) { MainScreen(navController = navController) }
}

fun NavGraphBuilder.firstGraph(navController: NavController) {
    composable(MainRoute.First.route) { FirstScreen() }
}

fun NavGraphBuilder.secondGraph(navController: NavController) {
    composable(MainRoute.Second.route) { SecondScreen() }
}