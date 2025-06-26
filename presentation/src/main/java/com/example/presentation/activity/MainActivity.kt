package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.MainScreen
import com.example.presentation.splash.SplashViewModel
import com.example.presentation.theme.DesignSystemTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val splashViewModel: SplashViewModel = hiltViewModel()
            val isLoading = splashViewModel.isLoading.collectAsState().value

            // isLoading
//            splashScreen.setKeepOnScreenCondition { !isLoading }



            DesignSystemTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController)
            }
        }
    }
}