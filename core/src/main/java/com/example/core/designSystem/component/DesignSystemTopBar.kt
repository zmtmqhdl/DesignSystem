package com.example.core.designSystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.theme.DesignSystemTheme
import com.example.core.designSystem.type.TopBarIconType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Custom(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    titleTextStyle: TextStyle,
    centeredTitle: Boolean,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    height: Dp = DesignSystemTheme.space.space12,
    backgroundColor: Color = DesignSystemTheme.color.background,
    scrollBehavior: TopAppBarScrollBehavior?
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
            )
        ,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
    )

    val actionsRow =
        @Composable {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        }

    val appBarDragModifier =
        if (scrollBehavior != null && !scrollBehavior.isPinned) {
            Modifier.draggable(
                orientation = Orientation.Vertical,
                state =
                    rememberDraggableState { delta -> scrollBehavior.state.heightOffset += delta },
                onDragStopped = { velocity ->
                    settleAppBar(
                        scrollBehavior.state,
                        velocity,
                        scrollBehavior.flingAnimationSpec,
                        scrollBehavior.snapAnimationSpec
                    )
                }
            )
        } else {
            Modifier
        }

    Surface(
        modifier = modifier.then(appBarDragModifier),
        color = appBarContainerColor
    ) {
        TopAppBarLayout(
            modifier =
                Modifier
                    .clipToBounds()
                    .heightIn(max = height),
            scrolledOffset = { scrollBehavior?.state?.heightOffset ?: 0f },
            navigationIconContentColor = backgroundColor.navigationIconContentColor,
            titleContentColor = backgroundColor.titleContentColor,
            actionIconContentColor = backgroundColor.actionIconContentColor,
            title = title,
            titleTextStyle = titleTextStyle,
            titleAlpha = 1f,
            titleVerticalArrangement = Arrangement.Center,
            titleHorizontalArrangement =
                if (centeredTitle) Arrangement.Center else Arrangement.Start,
            titleBottomPadding = 0,
            hideTitleSemantics = false,
            navigationIcon = navigationIcon,
            actions = actionsRow,
        )
    }
}


@Composable
fun PrimaryTopBar(
    title: (@Composable () -> Unit)? = null,
    height: Dp = DesignSystemTheme.space.space12,
    navigationIcon: List<PrimaryTopBarIcon>? = null,
    actions: List<PrimaryTopBarIcon>? = null,
) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = height),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationIcon?.forEachIndexed { index, value ->
                if (value.type == TopBarIconType.Icon) {
                    DesignSystemIcon(
                        icon = value.icon,
                        color = value.iconColor,
                        boxWidth = value.iconBoxWidth,
                        boxHeight = value.iconBoxHeight,
                        iconWidth = value.iconWidth,
                        iconHeight = value.iconHeight,
                        onClick = value.onClick
                    )
                } else {
                    Text(
                        text = value.text,
                        color = value.textColor,
                        style = value.textStyle
                    )
                }
                if (index != navigationIcon.lastIndex) {
                    Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))

                }
            }

            Spacer(modifier = Modifier.weight(1f))

            title?.let {
                Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                    it()
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            actions?.forEachIndexed { index, value ->
                if (index != 0) {
                    Spacer(modifier = Modifier.width(DesignSystemTheme.space.space1))
                }
                if (value.type == TopBarIconType.Icon) {
                    DesignSystemIcon(
                        icon = value.icon,
                        color = value.iconColor,
                        boxWidth = value.iconBoxWidth,
                        boxHeight = value.iconBoxHeight,
                        iconWidth = value.iconWidth,
                        iconHeight = value.iconHeight,
                        onClick = value.onClick
                    )
                } else {
                    Text(
                        text = value.text,
                        color = value.textColor,
                        style = value.textStyle
                    )
                }
            }
    }
}

data class PrimaryTopBarIcon(
    val type: TopBarIconType,
    val icon: ImageVector = Close,
    val iconColor: Color = Color.Unspecified,
    val iconBoxWidth: Dp = Dp.Unspecified,
    val iconBoxHeight: Dp = Dp.Unspecified,
    val iconWidth: Dp = Dp.Unspecified,
    val iconHeight: Dp = Dp.Unspecified,
    val text: String = "",
    val textColor: Color = Color.Unspecified,
    val textStyle: TextStyle = TextStyle.Default,
    val onClick: () -> Unit = {}
)


@DesignSystemPreview
@Composable
private fun PrimaryTopBarPreview() {
    PrimaryTopBar(
        title = { Text("title") },
        navigationIcon = listOf(
            PrimaryTopBarIcon(
                icon = Back,
                type = TopBarIconType.Icon,
            )
        ),
        actions = listOf(
            PrimaryTopBarIcon(
                icon = Back,
                type = TopBarIconType.Icon,
            ),
            PrimaryTopBarIcon(
                text = "example",
                textColor = DesignSystemTheme.color.primary.fontColor,
                textStyle = DesignSystemTheme.typography.m.medium,
                type = TopBarIconType.Text,
            )
        ),
    )
}