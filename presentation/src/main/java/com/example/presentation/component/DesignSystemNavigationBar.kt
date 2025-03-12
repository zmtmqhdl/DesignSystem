package com.example.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.navigation.SealedScreen

@Composable
fun PrimaryNavigationBar(
    route: List<SealedScreen>,
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

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryNavigationBar() {
    PrimaryNavigationBar(
        route = listOf(SealedScreen.Main, SealedScreen.Second),
        currentTab = 0,
        onSelectedTab = { index -> index }
    )
}