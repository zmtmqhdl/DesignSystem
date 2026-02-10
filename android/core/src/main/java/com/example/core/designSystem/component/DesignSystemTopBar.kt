package com.example.core.designSystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.core.designSystem.theme.scheme.BackgroundColorSet
import com.example.core.designSystem.theme.DesignSystemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignSystemTopBar(
    title: String? = null,
    titleContent: @Composable (() -> Unit)? = null,
    centeredTitle: Boolean = false,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit)? = null,
    height: Dp = DesignSystemTheme.space.space12,
    backgroundColor: BackgroundColorSet = DesignSystemTheme.color.background,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {

    require(!(title != null && titleContent != null)) {
        "You cannot provide both 'title' and 'titleContent' at the same time."
    }

    val expandedHeightPx = with(LocalDensity.current) { height.toPx().coerceAtLeast(minimumValue = 0f) }
    SideEffect {
        if (scrollBehavior?.state?.heightOffsetLimit != -expandedHeightPx) {
            scrollBehavior?.state?.heightOffsetLimit = -expandedHeightPx
        }
    }

    val colorTransitionFraction by remember(scrollBehavior) {
        derivedStateOf {
            val overlappingFraction = scrollBehavior?.state?.overlappedFraction ?: 0f
            if (overlappingFraction > 0.01f) 1f else 0f
        }
    }

    val appBarContainerColor by animateColorAsState(
        targetValue = lerp(
            start = backgroundColor.background,
            stop = backgroundColor.background,
            fraction = FastOutLinearInEasing.transform(fraction = colorTransitionFraction)
        ),
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
    )

    val offset by remember(scrollBehavior) {
        derivedStateOf {
            scrollBehavior?.state?.heightOffset ?: 0f
        }
    }

    val heightOffsetDp = with(LocalDensity.current) { offset.toDp() }

    if (centeredTitle) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = height + heightOffsetDp)
                .background(color = appBarContainerColor)
                .padding(horizontal = DesignSystemTheme.space.space4)
                .offset(y = heightOffsetDp),
            contentAlignment = Alignment.Center
        ) {
            title?.let {
                DesignSystemText(
                    text = it,
                    style = DesignSystemTheme.typography.typography4.medium
                )
            }

            titleContent?.let {
                it()
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                navigationIcon?.let {
                    it()
                }

                Spacer(modifier = Modifier.weight(weight = 1f))

                actions?.let {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(space = DesignSystemTheme.space.space2),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        it()
                    }
                }

            }
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = height + heightOffsetDp)
                .background(color = appBarContainerColor)
                .padding(horizontal = DesignSystemTheme.space.space4)
                .offset(y = heightOffsetDp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationIcon?.let {
                it()
            }
            Spacer(modifier = Modifier.width(width = DesignSystemTheme.space.space3))

            title?.let {
                DesignSystemText(
                    text = it,
                    style = DesignSystemTheme.typography.typography4.medium
                )
            }

            titleContent?.let {
                it()
            }

            Spacer(modifier = Modifier.weight(weight = 1f))

            actions?.let {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystemTheme.space.space2),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    it()
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@DesignSystemPreview
@Composable
private fun TopBarPreview() {
    DesignSystemTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

        // .nestedScroll(scrollBehavior.nestedScrollConnection)를 LazyColumn의 modifier에 넣기

        DesignSystemTopBar(
            title = "preview",
            centeredTitle = false,
            navigationIcon = {
                DesignSystemIconButton(
                    icon = Back,
                    onClick = {},
                    ariaLabel = "뒤로가기"
                )
            },
            actions = {
                DesignSystemIconButton(
                    icon = Password,
                    onClick = {},
                    ariaLabel = "비밀번호"
                )

                DesignSystemIconButton(
                    icon = Forward,
                    onClick = {},
                    ariaLabel = "앞으로"
                )
            },
        )
    }
}