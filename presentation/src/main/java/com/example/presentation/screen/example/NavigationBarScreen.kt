package com.example.presentation.screen.example

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.presentation.Icon.invisibility
import com.example.presentation.component.PrimaryNavigationBar

@Composable
fun NavigationBarScreen(navController: NavController) {
    val items = listOf("1번", "2번")
    val selectedIcons = listOf(invisibility, invisibility)
    val unSelectedIcons = listOf(invisibility, invisibility)
    var selectedIndex by remember { mutableIntStateOf(0) }

    Spacer(modifier = Modifier.height(500.dp))

    PrimaryNavigationBar(
        navController = navController,
        items = items,
        selectedIcons = selectedIcons,
        unSelectedIcons = unSelectedIcons,
        selectedIndex = selectedIndex,
        onItemSelected = { selectedIndex = it }
    )
}