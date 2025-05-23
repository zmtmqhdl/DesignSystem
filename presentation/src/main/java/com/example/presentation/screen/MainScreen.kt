package com.example.presentation.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.component.DesignSystemScreen
import com.example.presentation.component.Icon.Back
import com.example.presentation.component.Icon.Close
import com.example.presentation.component.Icon.Forward
import com.example.presentation.component.DesignSystemSnackBar
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.component.PrimaryTopBar
import com.example.presentation.component.PrimaryTopBarIcon
import com.example.presentation.navigation.FirstGraph
import com.example.presentation.navigation.Route
import com.example.presentation.navigation.SecondGraph
import com.example.presentation.theme.DesignSystemTheme

@Composable
fun MainScreen(navController: NavHostController) {

    val snackBarHostState = remember { SnackbarHostState() }
    var selectedTab by remember { mutableIntStateOf(0) }

    DesignSystemScreen.PrimaryScaffold(
        topBar = {
            PrimaryTopBar(
                title = { Text("title") },
                leftIcons = listOf(
                    PrimaryTopBarIcon(
                        icon = Back,
                        size = 16.dp,
                        onClick = {}
                    )
                ),
                rightIcons = listOf(
                    PrimaryTopBarIcon(
                        icon = Close,
                        size = 16.dp,
                        onClick = {}
                    ),
                    PrimaryTopBarIcon(
                        icon = Forward,
                        size = 16.dp,
                        onClick = {}
                    )
                ),
            )
        },
        bottomBar = {
            PrimaryNavigationBar(
                route = listOf(Route.Main, Route.Second),
                currentTab = selectedTab,
                onSelectedTab = { index -> selectedTab = index }
            )
        },
        snackBarHost = {
            DesignSystemSnackBar(
                snackBarHostState = snackBarHostState
            )
        },
        containerColor = DesignSystemTheme.color.white,
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