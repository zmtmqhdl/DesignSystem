package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import com.example.core.designSystem.animation.skeletonAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.ColorSet
import com.example.core.util.extension.conditional
import com.example.core.util.extension.onlyLayoutModifier

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
        BadgeSize.XSMALL -> RoundedCornerShape(DSTheme.dimension.dimension9)
        BadgeSize.SMALL -> RoundedCornerShape(DSTheme.dimension.dimension11)
        BadgeSize.MEDIUM -> RoundedCornerShape(DSTheme.dimension.dimension12)
        BadgeSize.LARGE -> RoundedCornerShape(DSTheme.dimension.dimension13)
    }

    Box(
        modifier = modifier
            .onlyLayoutModifier()
            .width(
                width = when (size) {
                    BadgeSize.XSMALL -> DSTheme.dimension.dimension52
                    BadgeSize.SMALL -> DSTheme.dimension.dimension64
                    BadgeSize.MEDIUM -> DSTheme.dimension.dimension80
                    BadgeSize.LARGE -> DSTheme.dimension.dimension96
                }
            )
            .height(
                height = when (size) {
                    BadgeSize.XSMALL -> DSTheme.dimension.dimension32
                    BadgeSize.SMALL -> DSTheme.dimension.dimension38
                    BadgeSize.MEDIUM -> DSTheme.dimension.dimension48
                    BadgeSize.LARGE -> DSTheme.dimension.dimension56
                }
            )
            .conditional(!isLoading) {
                background(
                    color = when (variant) {
                        BadgeVariant.FILL -> colorSet.mainBackgroundColor
                        BadgeVariant.WEAK -> colorSet.subBackgroundColor
                    },
                    shape = badgeShape
                )
            }
            .clip(badgeShape)
            .skeletonAnimation(isLoading),
        contentAlignment = Alignment.Center
    ) {
        DSText(
            text = text,
            modifier = Modifier
                .conditional(isLoading) { alpha(0f) }
                .padding(
                    horizontal = when (size) {
                        BadgeSize.XSMALL,
                        BadgeSize.SMALL,
                        BadgeSize.MEDIUM -> DSTheme.dimension.dimension3
                        BadgeSize.LARGE -> DSTheme.dimension.dimension4
                    },
                    vertical = when (size) {
                        BadgeSize.XSMALL,
                        BadgeSize.SMALL,
                        BadgeSize.MEDIUM -> DSTheme.dimension.dimension7
                        BadgeSize.LARGE -> DSTheme.dimension.dimension8
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
