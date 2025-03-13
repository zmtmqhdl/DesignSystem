package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Icon.close
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.navigation.FirstGraph
import com.example.presentation.navigation.Screen
import com.example.presentation.navigation.SecondGraph

@Composable
fun MainScreen(navController: NavController) {
    var selectedTab by remember { mutableIntStateOf(0) }

    val navController = rememberNavController()

    DesignSystemScreen.PrimaryScaffold(
        topBar = {
            PrimaryTopBar(
                title = { Text("test") },
                leftIcons = listOf(close),
                rightIcons = listOf(close),
                onLeftIconClick = { },
                onRightIconClick = listOf(),
            )
        },
        bottomBar = {
            PrimaryNavigationBar(
                route = listOf(Screen.Main, Screen.Second),
                currentTab = selectedTab,
                onSelectedTab = { index -> selectedTab = index }
            )
        },
        content = {
            when (selectedTab) {
                0 -> {
                    FirstGraph(
                        navController = navController
                    )
                }
                1 -> {
                    SecondGraph(
                        navController = navController
                    )
                }
            }
        }
    )
}