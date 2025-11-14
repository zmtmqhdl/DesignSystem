package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.icon.Home
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.theme.DesignSystemTheme

enum class NavigationBarVariant {
    DEFAULT, ROUND
}

interface NavigationItem {
    val route: String
    val label: String
    val icon: ImageVector
}

@Composable
fun DesignSystemNavigationBar(
    variant: NavigationBarVariant = NavigationBarVariant.DEFAULT,
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
    val borderWidth = DesignSystemTheme.space.space1

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                when (variant) {
                    NavigationBarVariant.DEFAULT -> {
                        Modifier
                            .background(
                                color = color.background,
                            )
                            .drawBehind {
                                val strokeWidth = borderWidth.toPx()
                                drawLine(
                                    color = color.outline,
                                    start = Offset(0f, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = strokeWidth
                                )
                            }
                    }

                    NavigationBarVariant.ROUND -> {
                        val shape = DesignSystemTheme.space.space2

                        Modifier
                            .background(
                                color = color.background,
                                shape = RoundedCornerShape(
                                    topStart = shape,
                                    topEnd = shape,
                                )
                            )
                            .drawBehind {
                                val strokeWidth = borderWidth.toPx()
                                drawLine(
                                    color = color.outline,
                                    start = Offset(0f, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = strokeWidth
                                )
                            }
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
                        enabled = currentDestination?.route != item.route,
                        onClick = {
                            navController.navigate(route = item.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(route = it) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        role = Role.Button,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DesignSystemIcon(
                    icon = item.icon,
                    ariaLabel = item.label,
                    color = DesignSystemTheme.colorSet.blue.mainBackgroundColor
                )

                Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space0))

                Text(
                    text = item.label
                )

            }
        }
    }
}

sealed class NavigationItemsForPreview(
    override val route: String,
    override val label: String,
    override val icon: ImageVector = Close,
) : NavigationItem {
    data object HomeRoute : NavigationItemsForPreview(
        route = "home",
        label = "home",
        icon = Home
    )
    data object SearchRoute : NavigationItemsForPreview(
        route = "search",
        label = "search",
        icon = Search
    )
}

@DesignSystemPreview
@Composable
fun NavigationBarPreview() {
    val navController = rememberNavController()
    DesignSystemTheme {
        DesignSystemNavigationBar(
            variant = NavigationBarVariant.DEFAULT,
            navController = navController,
            navigationItems =
                listOf(
                    NavigationItemsForPreview.HomeRoute,
                    NavigationItemsForPreview.SearchRoute
                )

        )
    }
}