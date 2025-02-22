package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.BottomSheetScreen
import com.example.presentation.screen.HomeScreen
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.viewModel.BottomSheetViewModel
import com.example.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignSystemTheme {

                val navController = rememberNavController()
                val homeViewModel: HomeViewModel = hiltViewModel()
                val bottomViewModel: BottomSheetViewModel = hiltViewModel()

                NavHost(navController = navController, startDestination = "bottomSheet") {
                    composable("home") { HomeScreen(homeViewModel = homeViewModel, onNext = { navController.navigate("detail") }) }
                    composable("bottomSheet") { BottomSheetScreen(bottomSheetViewModel = bottomViewModel)}
                }
            }
        }
    }
}