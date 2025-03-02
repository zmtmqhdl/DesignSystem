package com.example.presentation.screen

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Icon.close
import com.example.presentation.Icon.person
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.viewModel.HomeViewModel
import com.example.presentation.viewModel.example.BottomSheetViewModel

@Composable
fun NavScreen() {
    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = hiltViewModel()
    val bottomViewModel: BottomSheetViewModel = hiltViewModel()

    val snackBarHostState = remember { SnackbarHostState() }
    var selectedIndex by remember { mutableIntStateOf(0) }

    DesignSystemScreen.PrimaryScaffold(
        topBar = {
            PrimaryTopBar(
                title = { Text("test") },
                leftIcons = listOf(close, person),
                rightIcons = listOf(close, person),
                onRightIconClick = { icon -> Log.d("test", icon) },
                onLeftIconClick = { icon -> Log.d("test", icon) }
            )
        },
        bottomBar = {
            PrimaryNavigationBar(
                navController = navController,
                items = listOf("1번", "2번"),
                selectedIcons = listOf(close, person),
                unSelectedIcons = listOf(close, person),
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