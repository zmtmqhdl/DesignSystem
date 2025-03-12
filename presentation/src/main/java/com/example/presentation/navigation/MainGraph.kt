package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.SecondScreen
import com.example.presentation.screen.SplashScreen

@Composable
fun SplashGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        splashGraph(navController)
    }
}

@Composable
fun MainGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
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
        startDestination = Screen.First.route
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
        startDestination = Screen.Second.route
    ) {
        secondGraph(navController)
    }
}