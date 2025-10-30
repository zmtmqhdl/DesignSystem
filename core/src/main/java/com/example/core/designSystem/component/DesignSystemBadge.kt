package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.ColorSet
import com.example.core.designSystem.theme.DesignSystemTheme

enum class BadgeVariant {
    FILL,
    WEAK
}

enum class BadgeSize {
    XSMALL,
    SMALL,
    MEDIUM,
    LARGE
}

@Composable
fun DesignSystemBadge(
    text: String,
    variant: BadgeVariant = BadgeVariant.FILL,
    size: BadgeSize = BadgeSize.MEDIUM,
    colorSet: ColorSet = DesignSystemTheme.colorSet.blue
) {
    Box(
        modifier = Modifier
            .defaultMinSize( // 설정 필요
                minWidth = when (size) {
                    BadgeSize.XSMALL -> 96.dp
                    BadgeSize.SMALL -> 52.dp
                    BadgeSize.MEDIUM -> 64.dp
                    BadgeSize.LARGE -> 80.dp
                },
                minHeight = when (size) {
                    BadgeSize.XSMALL -> 56.dp
                    BadgeSize.SMALL -> 32.dp
                    BadgeSize.MEDIUM -> 38.dp
                    BadgeSize.LARGE -> 48.dp
                }
            )
            .background(
                color = when(variant) {
                    BadgeVariant.FILL -> colorSet.mainBackgroundColor
                    BadgeVariant.WEAK -> colorSet.subBackgroundColor
                },
                shape = when(size) {
                    BadgeSize.XSMALL -> RoundedCornerShape(size = 9.dp)
                    BadgeSize.SMALL -> RoundedCornerShape(size = 11.dp)
                    BadgeSize.MEDIUM -> RoundedCornerShape(size = 12.dp)
                    BadgeSize.LARGE -> RoundedCornerShape(size = 13.dp)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        DesignSystemText(
            text = text,
            modifier = Modifier
                .padding(
                    horizontal = when (size) {
                        BadgeSize.XSMALL -> 3.dp
                        BadgeSize.SMALL -> 3.dp
                        BadgeSize.MEDIUM -> 3.dp
                        BadgeSize.LARGE -> 4.dp

                    },
                    vertical = when (size) {
                        BadgeSize.XSMALL -> 7.dp
                        BadgeSize.SMALL -> 7.dp
                        BadgeSize.MEDIUM -> 7.dp
                        BadgeSize.LARGE -> 8.dp
                    }
                ),
            color = when(variant) {
                BadgeVariant.FILL -> colorSet.mainFontColor
                BadgeVariant.WEAK -> colorSet.subFontColor
            },
            style = when(size) {
                BadgeSize.XSMALL -> DesignSystemTheme.typography.subTypography13.semiBold
                BadgeSize.SMALL -> DesignSystemTheme.typography.subTypography12.bold
                BadgeSize.MEDIUM -> DesignSystemTheme.typography.typography7.semiBold
                BadgeSize.LARGE -> DesignSystemTheme.typography.subTypography11.bold
            }
        )
    }
}

@DesignSystemPreview
@Composable
fun DesignSystemBadgePreview() {
    DesignSystemTheme {
        DesignSystemBadge(
            text = "Preview",

            colorSet = DesignSystemTheme.colorSet.blue
        )
    }
}