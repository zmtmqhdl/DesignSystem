package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PrimaryNavigationBar(
    navController: NavController,
    items: List<String>,
    selectedIcons: List<String>,
    unSelectedIcons: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    onItemSelected(index)
                    if (index == 1) {
                        navController.navigate("second")
                    } else {
                        navController.navigate("main")
                    }
                },
                icon = @Composable { DesignSystemIcon(name = if (selectedIndex == index) selectedIcons[index] else unSelectedIcons[index]) },
                label = { Text(title) },
            )
        }
    }
}
