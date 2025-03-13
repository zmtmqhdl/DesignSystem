package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.presentation.navigation.Screen
import com.example.presentation.util.DesignSystemPreview

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

@DesignSystemPreview
@Composable
fun PreviewPrimaryNavigationBar() {
    PrimaryNavigationBar(
        route = listOf(Screen.First, Screen.Second),
        currentTab = 0,
        onSelectedTab = { index -> index }
    )
}