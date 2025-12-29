package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
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
    val color = DesignSystemTheme.color.navigationBar
    val navBackStackEntry by navController
        .currentBackStackEntryFlow
        .collectAsStateWithLifecycle(
            initialValue = null
        )

    val currentRoute = navBackStackEntry?.destination
    val borderWidth = 1.dp

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
                        val shape = DesignSystemTheme.space.space5

                        Modifier
                            .clip(RoundedCornerShape(topStart = shape, topEnd = shape))
                            .background(
                                color = color.selectedIcon,
                                shape = RoundedCornerShape(
                                    topStart = shape,
                                    topEnd = shape,
                                )
                            )
                            .drawBehind {
                                val strokeWidth = 5.dp.toPx()
                                drawLine(
                                    color = Color.Red,
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
            val selected = currentRoute?.route == item.route
            Column(
                modifier = Modifier
                    .padding(
                        vertical = DesignSystemTheme.space.space2
                    )
                    .clip(shape = DesignSystemTheme.shape.iconButton)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        enabled = currentRoute?.route != item.route,
                        role = Role.Button,
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
                Column(
                    modifier = Modifier.padding(
                        horizontal = DesignSystemTheme.space.space3,
                        vertical = DesignSystemTheme.space.space1
                    ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DesignSystemIcon(
                        icon = item.icon,
                        ariaLabel = item.label,
                        color = if (selected) color.selectedIcon else color.unselectedIcon
                    )

                    Spacer(modifier = Modifier.height(DesignSystemTheme.space.space0))
                    
                    DesignSystemText(
                        text = item.label,
                        color = if (selected) color.selectedText else color.unselectedText,
                        style = DesignSystemTheme.typography.subTypography11.medium
                    )
                }
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
            variant = NavigationBarVariant.ROUND,
            navController = navController,
            navigationItems =
                listOf(
                    NavigationItemsForPreview.HomeRoute,
                    NavigationItemsForPreview.SearchRoute
                )

        )
    }
}