package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Icon.close
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.navigation.BottomNavGraph
import com.example.presentation.navigation.DesignSystemNavGraph
import com.example.presentation.navigation.Screen

@Composable
fun NavScreen(
    navController: NavHostController
) {
    val test = rememberNavController()

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
                navController = test,
                route = listOf(Screen.Main, Screen.Second),
            )
        },
        content = {
            BottomNavGraph(navController = test)
        }
    )
}