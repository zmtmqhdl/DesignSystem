package com.example.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.component.DesignSystemNavigationBar
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.presentation.navigation.NavigationItems

@Composable
fun MainScreen(
    navController: NavHostController
) {

    DesignSystemScreen.Scaffold(
        bottomBar = {
            DesignSystemNavigationBar(
                navController = navController,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.Test
                )
            )
        },
    ) { }
}