package com.example.core.designSystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.core.designSystem.theme.DesignSystemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PrimaryTopBar(
    title: @Composable () -> Unit,
    centeredTitle: Boolean = false,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    height: Dp = DesignSystemTheme.space.space12,
    backgroundColor: Color = DesignSystemTheme.color.background,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val expandedHeightPx = with(LocalDensity.current) { height.toPx().coerceAtLeast(0f) }
    SideEffect {
        if (scrollBehavior?.state?.heightOffsetLimit != -expandedHeightPx) {
            scrollBehavior?.state?.heightOffsetLimit = -expandedHeightPx
        }
    }

    val colorTransitionFraction by
    remember(scrollBehavior) {
        derivedStateOf {
            val overlappingFraction = scrollBehavior?.state?.overlappedFraction ?: 0f
            if (overlappingFraction > 0.01f) 1f else 0f
        }
    }
    val appBarContainerColor by
    animateColorAsState(
        targetValue = lerp(
            start = backgroundColor,
            stop = backgroundColor,
            fraction = FastOutLinearInEasing.transform(colorTransitionFraction)
        ),
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height),
        color = appBarContainerColor
    ) {
        if (centeredTitle) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = DesignSystemTheme.space.space4),
                contentAlignment = Alignment.Center
            ) {
                title()

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    navigationIcon()
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesignSystemTheme.space.space2),
                        verticalAlignment = Alignment.CenterVertically,
                        content = actions
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = DesignSystemTheme.space.space4
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                navigationIcon()
                Spacer(modifier = Modifier.width(width = DesignSystemTheme.space.space3))
                title()
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = DesignSystemTheme.space.space1
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    content = actions
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
object DesignSystemTopBar {
    @Composable
    fun TextTopBar(
        text: String,
        centeredTitle: Boolean = false,
        navigationIcon: @Composable () -> Unit,
        actions: @Composable RowScope.() -> Unit,
        height: Dp = DesignSystemTheme.space.space12,
        backgroundColor: Color = DesignSystemTheme.color.background,
        scrollBehavior: TopAppBarScrollBehavior? = null
    ) {
        PrimaryTopBar(
            title = {
                Text(
                    text = text,
                    color = DesignSystemTheme.color.black,
                    style = DesignSystemTheme.typography.xl.bold
                )
            },
            centeredTitle = centeredTitle,
            navigationIcon = navigationIcon,
            actions = actions,
            height = height,
            backgroundColor = backgroundColor,
            scrollBehavior = scrollBehavior
        )
    }

    @Composable
    fun ContentTopBar(
        content: @Composable () -> Unit,
        centeredTitle: Boolean = false,
        navigationIcon: @Composable () -> Unit,
        actions: @Composable RowScope.() -> Unit,
        height: Dp = DesignSystemTheme.space.space12,
        backgroundColor: Color = DesignSystemTheme.color.background,
        scrollBehavior: TopAppBarScrollBehavior? = null
    ) {
        PrimaryTopBar(
            title = content,
            centeredTitle = centeredTitle,
            navigationIcon = navigationIcon,
            actions = actions,
            height = height,
            backgroundColor = backgroundColor,
            scrollBehavior = scrollBehavior
        )
    }
}


@DesignSystemPreview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DesignSystemTopBar_TextTopBar_Preview() {
    DesignSystemTheme {
        DesignSystemTopBar.TextTopBar(
            text = "preview",
            navigationIcon = {
                DesignSystemIcon(
                    icon = Back
                )
            },
            actions = {
                DesignSystemIcon(
                    icon = Password
                )

                DesignSystemIcon(
                    icon = Forward
                )
            },
        )
    }
}

@DesignSystemPreview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DesignSystemTopBar_ContentTopBar_Preview() {
    DesignSystemTheme {
        DesignSystemTopBar.ContentTopBar(
            content = {
                Text(
                    text = "preview"
                )
            },
            navigationIcon = {
                DesignSystemIcon(
                    icon = Back
                )
            },
            actions = {
                DesignSystemIcon(
                    icon = Password
                )

                DesignSystemIcon(
                    icon = Forward
                )
            },
        )
    }
}