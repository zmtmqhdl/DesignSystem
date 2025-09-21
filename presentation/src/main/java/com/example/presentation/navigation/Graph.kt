package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.Splash.route
    ) {
        mainGraph(navController)
    }
}

@Composable
fun FirstGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.First.route
    ) {
        firstGraph(navController)
    }
}

@Composable
fun SecondGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.Second.route
    ) {
        secondGraph(navController)
    }
}

fun NavController.popNavigate(route: String) {
    val currentRoute = this.currentDestination?.route
    this.navigate(route = route) {
        currentRoute?.let {
            popUpTo(
                route = it
            ) {
                inclusive = true
            }
        }
    }
}