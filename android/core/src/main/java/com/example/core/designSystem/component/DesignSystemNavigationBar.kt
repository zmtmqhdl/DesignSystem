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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme

enum class NavigationBarVariant {
    DEFAULT, ROUND
}

interface NavigationItem {
    val route: NavKey
    val label: String
    val icon: ImageVector
}

@Composable
fun DesignSystemNavigationBar(
    variant: NavigationBarVariant = NavigationBarVariant.DEFAULT,
    navigationItems: List<NavigationItem>,
    backStack: NavBackStack<NavKey>,
) {
    val color = DesignSystemTheme.color.navigationBar
    val currentKey = backStack.lastOrNull()

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
                        val shapeSize = DesignSystemTheme.space.space5

                        Modifier
                            .clip(RoundedCornerShape(topStart = shapeSize, topEnd = shapeSize))
                            .background(color = color.background)
                            .drawWithContent {
                                drawContent()

                                val strokeWidth = borderWidth.toPx()
                                val cornerRadius = shapeSize.toPx()

                                val topBorderPath = Path().apply {
                                    moveTo(
                                        x = 0f,
                                        y = cornerRadius
                                    )

                                    arcTo(
                                        rect = Rect(
                                            left = 0f,
                                            top = 0f,
                                            right = cornerRadius * 2,
                                            bottom = cornerRadius * 2
                                        ),
                                        startAngleDegrees = 180f,
                                        sweepAngleDegrees = 90f,
                                        forceMoveTo = false
                                    )

                                    lineTo(
                                        x = size.width - cornerRadius,
                                        y = 0f
                                    )

                                    arcTo(
                                        rect = Rect(
                                            left = size.width - cornerRadius * 2,
                                            top = 0f,
                                            right = size.width,
                                            bottom = cornerRadius * 2
                                        ),
                                        startAngleDegrees = 270f,
                                        sweepAngleDegrees = 90f,
                                        forceMoveTo = false
                                    )
                                }

                                drawPath(
                                    path = topBorderPath,
                                    color = color.outline,
                                    style = Stroke(
                                        width = strokeWidth,
                                        cap = StrokeCap.Round
                                    )
                                )
                            }
                    }
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navigationItems.forEach { item ->
            val selected = currentKey == item.route
            Column(
                modifier = Modifier
                    .padding(
                        vertical = DesignSystemTheme.space.space2
                    )
                    .clip(shape = DesignSystemTheme.shape.iconButton)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        enabled = currentKey != item.route,
                        role = Role.Button,
                        onClick = {
                            backStack.add(
                                element = item.route
                            )
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

sealed interface PreviewRoute : NavKey {
    data object First : PreviewRoute
    data object Second : PreviewRoute
    data object Third : PreviewRoute
    data object Fourth : PreviewRoute
}

sealed class PreviewNavigationItems (
    override val label: String,
    override val icon: ImageVector = Close,
) : NavigationItem {
    data object First : PreviewNavigationItems(
        label = "first"
    ) {
        override val route: NavKey = PreviewRoute.First
    }

    data object Second : PreviewNavigationItems(

        label = "second"
    ) {
        override val route: NavKey = PreviewRoute.Second
    }

    data object Third : PreviewNavigationItems(
        label = "third"
    ) {
        override val route: NavKey = PreviewRoute.Third
    }

    data object Fourth : PreviewNavigationItems(
        label = "fourth"
    ) {
        override val route: NavKey = PreviewRoute.Fourth
    }
}



@DesignSystemPreview
@Composable
fun NavigationBarPreview() {
    DesignSystemTheme {
        val backStack = rememberNavBackStack()

        DesignSystemNavigationBar(
            variant = NavigationBarVariant.ROUND,
            navigationItems = listOf(
                PreviewNavigationItems.First,
                PreviewNavigationItems.Second,
                PreviewNavigationItems.Third,
                PreviewNavigationItems.Fourth
            ),
            backStack = backStack,
        )
    }
}