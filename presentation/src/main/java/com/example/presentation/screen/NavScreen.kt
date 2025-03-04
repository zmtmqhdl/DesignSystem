package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.presentation.Icon.close
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.navigation.MainGraph
import com.example.presentation.navigation.Screen

@Composable
fun NavScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    val navController = rememberNavController()
    // val secondNavController = rememberNavController()

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
                route = listOf(Screen.Main, Screen.Second),
                currentTab = selectedTab,
                onSelectedTab = { index -> selectedTab = index }
            )
        },
        content = {
            when (selectedTab) {
                0 -> {
                    MainGraph(
                        navController = navController
                    )
                }
//                1 -> {
//                    DesignSystemSecondNavGraph(
//                        navController = secondNavController
//                    )
//                }
            }
        }
    )
}