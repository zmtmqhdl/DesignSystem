package com.example.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.presentation.common.TopBarIconType
import com.example.presentation.component.Icon.Back
import com.example.presentation.component.Icon.Close
import com.example.presentation.component.Icon.Forward
import com.example.presentation.theme.DesignSystemTheme
import com.example.presentation.core.DesignSystemPreview

@Composable
fun PrimaryTopBar(
    title: (@Composable () -> Unit)? = null,
    leftIcons: List<NewPrimaryTopBarIcon>? = null,
    rightIcons: List<NewPrimaryTopBarIcon>? = null,
) {
    Column(
        modifier = Modifier.padding(horizontal = DesignSystemTheme.space.space4)
    ) {
        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space5))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(DesignSystemTheme.space.space8),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftIcons?.forEachIndexed { index, value ->
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
                if (index != leftIcons.lastIndex) {
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

            rightIcons?.forEachIndexed { index, value ->
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
        Spacer(modifier = Modifier.height(DesignSystemTheme.space.space1))
    }
}

data class PrimaryTopBarIcon(
    val icon: ImageVector,
    val size: Dp,
    val onClick: () -> Unit
)

data class NewPrimaryTopBarIcon(
    val type: TopBarIconType,
    val icon: ImageVector = Close,
    val iconColor: Color = Color.Unspecified,
    val iconBoxWidth: Dp = Dp.Unspecified,
    val iconBoxHeight: Dp = Dp.Unspecified,
    val iconWidth: Dp = Dp.Unspecified ,
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
        leftIcons = listOf(
            NewPrimaryTopBarIcon(
                icon = Back,
                type = TopBarIconType.Icon,
            )
        ),
        rightIcons = listOf(
            NewPrimaryTopBarIcon(
                icon = Back,
                type = TopBarIconType.Icon,
            ),
            NewPrimaryTopBarIcon(
                text = "example",
                textColor = DesignSystemTheme.color.primary.fontColor,
                textStyle = DesignSystemTheme.typography.m.medium,
                type = TopBarIconType.Text,
            )
        ),
    )
}