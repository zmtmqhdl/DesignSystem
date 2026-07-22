package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.ColorSet
import com.example.core.util.extension.conditional

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
fun DSBadge(
    text: String,
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.FILL,
    size: BadgeSize = BadgeSize.MEDIUM,
    colorSet: ColorSet = DSTheme.color.blue,
    isLoading: Boolean = false
) {
    val badgeShape = when (size) {
        BadgeSize.XSMALL -> RoundedCornerShape(size = 9.dp)
        BadgeSize.SMALL -> RoundedCornerShape(size = 11.dp)
        BadgeSize.MEDIUM -> RoundedCornerShape(size = 12.dp)
        BadgeSize.LARGE -> RoundedCornerShape(size = 13.dp)
    }

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = when (size) {
                    BadgeSize.XSMALL -> 52.dp
                    BadgeSize.SMALL -> 64.dp
                    BadgeSize.MEDIUM -> 80.dp
                    BadgeSize.LARGE -> 96.dp
                },
                minHeight = when (size) {
                    BadgeSize.XSMALL -> 32.dp
                    BadgeSize.SMALL -> 38.dp
                    BadgeSize.MEDIUM -> 48.dp
                    BadgeSize.LARGE -> 56.dp
                }
            )
            .conditional(condition = !isLoading) {
                background(
                    color = when (variant) {
                        BadgeVariant.FILL -> colorSet.mainBackgroundColor
                        BadgeVariant.WEAK -> colorSet.subBackgroundColor
                    },
                    shape = badgeShape
                )
            }
            .clip(shape = badgeShape)
            .skeletonAnimation(isLoading = isLoading),
        contentAlignment = Alignment.Center
    ) {
        DSText(
            text = text,
            modifier = Modifier
                .conditional(condition = isLoading) { alpha(0f) }
                .padding(
                    horizontal = when (size) {
                        BadgeSize.XSMALL,
                        BadgeSize.SMALL,
                        BadgeSize.MEDIUM -> 3.dp
                        BadgeSize.LARGE -> 4.dp
                    },
                    vertical = when (size) {
                        BadgeSize.XSMALL,
                        BadgeSize.SMALL,
                        BadgeSize.MEDIUM -> 7.dp
                        BadgeSize.LARGE -> 8.dp
                    }
                ),
            color = when (variant) {
                BadgeVariant.FILL -> colorSet.mainColor
                BadgeVariant.WEAK -> colorSet.subColor
            },
            style = when (size) {
                BadgeSize.XSMALL -> DSTheme.typography.subTypography13.semiBold
                BadgeSize.SMALL -> DSTheme.typography.subTypography12.bold
                BadgeSize.MEDIUM -> DSTheme.typography.typography7.semiBold
                BadgeSize.LARGE -> DSTheme.typography.subTypography11.bold
            }
        )
    }
}

@DSPreview
@Composable
fun BadgePreview() {
    DSTheme {
        DSBadge(
            text = "Preview",
            colorSet = DSTheme.color.blue,
            isLoading = true
        )
    }
}
