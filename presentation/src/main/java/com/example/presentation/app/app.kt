package com.example.presentation.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.DetailScreen
import com.example.presentation.screen.HomeScreen

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(onNext = { navController.navigate("detail") })}
        composable("detail") {}
    }
}