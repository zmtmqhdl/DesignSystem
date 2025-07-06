package com.example.core.designSystem.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Close

@Composable
fun PrimaryNavigationBar(
    route: List<NavigationItem>,
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
                        icon = if (currentTab == index) value.selectedIcon else value.unselectedIcon
                    )
                },
                label = { value.label?.let { Text(it) } },
            )
        }
    }
}

interface NavigationItem {
    val route: String
    val label: String?
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
}

@DesignSystemPreview
@Composable
private fun PrimaryNavigationBarPreview() {
    PrimaryNavigationBar(
        route = listOf(
            NavigationItem(
                route = "first"
            ),
            NavigationItem(
                route = "second"
            )
        ),
        currentTab = 0,
        onSelectedTab = { index -> index }
    )
}