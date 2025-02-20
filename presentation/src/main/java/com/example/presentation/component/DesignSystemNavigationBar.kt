package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PrimaryNavigationBar (
    navController: NavController,
    items: List<String>,
    icons: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
){
    NavigationBar {
        items.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { onItemSelected(index) },
                icon = @Composable { DesignSystemIcon(name = icons[index]) },
                label = { Text(title) }
            )
        }
    }
}