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
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.screen.PrimaryScreen

@Composable
fun NavigationBarScreen(navController: NavController) {
    val items = listOf("1번", "2번")
    val icons = listOf("icon_back", "icon_close")
    var selectedIndex by remember { mutableIntStateOf(0) }

    Spacer(modifier = Modifier.height(200.dp))

    PrimaryScreen {
        PrimaryNavigationBar(
            navController = navController,
            items = items,
            icons = icons,
            selectedIndex = selectedIndex,
            onItemSelected = { selectedIndex = it }
        )
    }
}