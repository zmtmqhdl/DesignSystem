package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.presentation.navigation.Screen

@Composable
fun PrimaryNavigationBar(
    route: List<Screen>,
    currentTab: Int,
    onSelectedTab: (Int) -> Unit
) {
    NavigationBar {
        route.forEachIndexed { index, value ->
            NavigationBarItem(
                selected = currentTab == index,
                onClick = {
                    onSelectedTab(index)
                },
                icon = {
                    DesignSystemIcon(
                        name = if (currentTab == index) value.selectedIcon else value.unselectedIcon
                    )
                },
                label = { value.label?.let { Text(it) } },
            )
        }
    }
}