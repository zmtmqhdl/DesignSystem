package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.screen.DesignSystemScreen
import com.example.presentation.screen.MainScreen
import com.example.presentation.screen.SecondScreen
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.viewModel.HomeViewModel
import com.example.presentation.viewModel.example.BottomSheetViewModel
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

                val snackBarHostState = remember { SnackbarHostState() }
                var selectedIndex by remember { mutableIntStateOf(0) }


                DesignSystemScreen.PrimaryScaffold(
                    topBar = {
                        PrimaryTopBar(
                            title = { Text("test") },
                            leftIcons = listOf("icon_back", "icon_close"),
                            rightIcons = listOf("icon_close", "icon_back"),
                        )
                    },
                    bottomBar = {
                        PrimaryNavigationBar(
                            navController = navController,
                            items = listOf("1번", "2번"),
                            selectedIcons = listOf("icon_close", "icon_back"),
                            unSelectedIcons = listOf("icon_back", "icon_close"),
                            selectedIndex = selectedIndex,
                            onItemSelected = { selectedIndex = it },
                        )
                    },
                    snackBarHost = snackBarHostState,
                    content = {
                        NavHost(
                            navController = navController,
                            startDestination = "main"
                        ) {
                            composable("main") { MainScreen() }
                            composable("second") { SecondScreen() }

                        }
                    }
                )
            }
        }
    }
}