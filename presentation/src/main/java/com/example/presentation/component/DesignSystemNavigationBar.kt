package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun PrimaryNavigationBar(
    navController: NavController,
    items: List<String>,
    selectedIcons: List<ImageVector>,
    unSelectedIcons: List<ImageVector>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    onItemSelected(index)
                    if (selectedIndex != index) {
                        if (index == 0) {
                            navController.navigate("main")
                        } else {
                            navController.navigate("second")
                        }
                    }
                },
                icon = @Composable { DesignSystemIcon(name = if (selectedIndex == index) selectedIcons[index] else unSelectedIcons[index]) },
                label = { Text(title) },
            )
        }
    }
}
