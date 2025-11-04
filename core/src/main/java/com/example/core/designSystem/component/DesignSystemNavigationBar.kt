package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.core.designSystem.theme.DesignSystemTheme

enum class NavigationBarVariant {
    ROUND
}

interface NavigationItem {
    val route: String
    val label: String
    val icon: ImageVector
}

@Composable
fun DesignSystemNavigationBar(
    variant: NavigationBarVariant = NavigationBarVariant.ROUND,
    navController: NavHostController,
    navigationItems: List<NavigationItem>,
) {

    val color = DesignSystemTheme.colorSet.navigationBar

    val navBackStackEntry by navController
        .currentBackStackEntryFlow
        .collectAsStateWithLifecycle(
            initialValue = null
        )

    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = color.outline,
                shape = RoundedCornerShape(
                    topStart = DesignSystemTheme.space.space2,
                    topEnd = DesignSystemTheme.space.space2,
                )
            )
            .then(
                when (variant) {
                    NavigationBarVariant.ROUND -> {
                        Modifier
                            .border(
                                width = DesignSystemTheme.space.space1,
                                color = color.outline,
                                shape = RoundedCornerShape(
                                    topStart = DesignSystemTheme.space.space2,
                                    topEnd = DesignSystemTheme.space.space2,
                                )
                            )
                    }
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navigationItems.forEach { item ->
            Column(
                modifier = Modifier
                    .clickable(
                        enabled = true,
                        onClick = {
                            navController.navigate(route = item.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(route = it) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DesignSystemIconButton(
                    icon = item.icon,
                    onClick = {},
                    ariaLabel = item.label
                )

                Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space1))

                Text(
                    text = item.label
                )

            }
        }
    }
}

//@DesignSystemPreview
//@Composable
//fun NavigationBarPreview() {
//    var current = ""
//
//    DesignSystemTheme {
//        DesignSystemNavigationBar(
//            variant = NavigationBarVariant.ROUND,
//            routeList =  List<NavigationItem>,
//            currentRoute = current,
//            onClick = { current = it}
//        )
//    }
//}