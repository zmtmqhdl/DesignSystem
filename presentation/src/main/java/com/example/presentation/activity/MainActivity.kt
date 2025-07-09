package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.presentation.screen.MainScreen
import com.example.presentation.splash.SplashViewModel
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.domain.repository.LoadingRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loadingRepository: LoadingRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val splashViewModel: SplashViewModel = hiltViewModel()
            val isLoading = splashViewModel.isLoading.collectAsState().value

            // isLoading
//            splashScreen.setKeepOnScreenCondition { !isLoading }

            val loading by loadingRepository.loading.collectAsState()
            val navController = rememberNavController()

            DesignSystemTheme {
                DesignSystemScreen.LoadingScreen(
                    loading = loading,
                    content = {
                        MainScreen(navController = navController)
                    }
                )
            }
        }
    }
}