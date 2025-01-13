package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.HomeScreen
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignSystemTheme {

                val navController = rememberNavController()
                val homeViewModel: HomeViewModel = hiltViewModel()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(homeViewModel = homeViewModel, onNext = { navController.navigate("detail") }) }
                    composable("detail") {}
                }
            }
        }
    }
}