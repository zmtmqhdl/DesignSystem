package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Icon.close
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.navigation.DesignSystemNavGraph
import com.example.presentation.navigation.Screen

@Composable
fun NavScreen() {

    val navController = rememberNavController()

    DesignSystemScreen.PrimaryScaffold(
        topBar = {
            PrimaryTopBar(
                title = { Text("test") },
                leftIcons = listOf(close),
                rightIcons = listOf(close),
                onLeftIconClick = { },
                onRightIconClick = listOf({}),
            )
        },
        bottomBar = {
            PrimaryNavigationBar(
                navController = navController,
                route = listOf(Screen.Main, Screen.Second),
            )
        },
        content = {
            DesignSystemNavGraph(
                navController = navController
            )
        }
    )
}