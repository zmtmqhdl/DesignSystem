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
import androidx.compose.material3.TopAppBarScrollBehavior
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
import androidx.compose.ui.unit.IntOffset
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.BackgroundColorSet
import kotlin.math.roundToInt

enum class TopBarVariant {
    LEFT, CENTER
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTopBar(
    variant: TopBarVariant = TopBarVariant.CENTER,
    title: String? = null,
    titleContent: @Composable (() -> Unit)? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit)? = null,
    height: Dp = DSTheme.dimension.dimension48,
    backgroundColor: BackgroundColorSet = DSTheme.color.background,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    require(!(title != null && titleContent != null)) {
        "You cannot provide both 'title' and 'titleContent' at the same time."
    }

    val density = LocalDensity.current
    val heightPx = with(density) { height.toPx() }

    SideEffect {
        if (scrollBehavior?.state?.heightOffsetLimit != -heightPx) {
            scrollBehavior?.state?.heightOffsetLimit = -heightPx
        }
    }

    val heightOffsetPx = scrollBehavior?.state?.heightOffset ?: 0f

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

    val topBarModifier = Modifier
        .fillMaxWidth()
        .height(height = height)
        .offset { IntOffset(x = 0, y = heightOffsetPx.roundToInt()) }
        .background(color = appBarContainerColor)
        .padding(horizontal = DSTheme.dimension.dimension16)

    when (variant) {
        TopBarVariant.LEFT -> {
            Row(
                modifier = topBarModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                navigationIcon?.let {
                    it()
                }
                Spacer(modifier = Modifier.width(width = DSTheme.dimension.dimension12))

                title?.let {
                    DSText(
                        text = it,
                        style = DSTheme.typography.typography4.medium
                    )
                }

                titleContent?.let {
                    it()
                }

                Spacer(modifier = Modifier.weight(weight = 1f))

                actions?.let {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DSTheme.dimension.dimension8),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        it()
                    }
                }
            }
        }
        TopBarVariant.CENTER -> {
            Box(
                modifier = topBarModifier,
                contentAlignment = Alignment.Center
            ) {
                title?.let {
                    DSText(
                        text = it,
                        style = DSTheme.typography.typography4.medium
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
                            horizontalArrangement = Arrangement.spacedBy(space = DSTheme.dimension.dimension8),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            it()
                        }
                    }

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@DSPreview
@Composable
private fun TopBarPreview() {
    DSTheme {
        DSTopBar(
            title = "preview",
            navigationIcon = {
                DSIconButton(
                    icon = Back,
                    onClick = {},
                    ariaLabel = "뒤로가기"
                )
            },
            actions = {
                DSIconButton(
                    icon = Password,
                    onClick = {},
                    ariaLabel = "비밀번호"
                )

                DSIconButton(
                    icon = Forward,
                    onClick = {},
                    ariaLabel = "앞으로"
                )
            },
        )
    }
}