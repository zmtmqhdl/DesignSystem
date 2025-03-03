package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.presentation.navigation.Screen

@Composable
fun PrimaryNavigationBar(
    navController: NavController,
    route: List<Screen>,
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        route.forEach { value ->
            NavigationBarItem(
                selected = currentRoute == value.route,
                onClick = {
                    if (currentRoute != value.route) {
                        navController.navigate(value.route)
                    }
                },
                icon = {
                    DesignSystemIcon(
                        name = if (currentRoute == value.route) value.selectedIcon else value.unselectedIcon
                    )
                },
                label = { value.label?.let { Text(it) } },
            )
        }
    }
}