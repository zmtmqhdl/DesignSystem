package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
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

private data class BadgeStyle(
    val height: Dp,
    val cornerRadius: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val textStyle: TextStyle,
)

@Composable
private fun badgeStyle(badgeSize: BadgeSize): BadgeStyle {
    return when (badgeSize) {
        BadgeSize.XSMALL -> BadgeStyle(
            height = DSTheme.dimension.dimension21,
            cornerRadius = DSTheme.dimension.dimension9,
            horizontalPadding = DSTheme.dimension.dimension7,
            verticalPadding = DSTheme.dimension.dimension3,
            textStyle = DSTheme.typography.subTypography13.semiBold,
        )
        BadgeSize.SMALL -> BadgeStyle(
            height = DSTheme.dimension.dimension24,
            cornerRadius = DSTheme.dimension.dimension11,
            horizontalPadding = DSTheme.dimension.dimension7,
            verticalPadding = DSTheme.dimension.dimension3,
            textStyle = DSTheme.typography.subTypography12.bold,
        )
        BadgeSize.MEDIUM -> BadgeStyle(
            height = DSTheme.dimension.dimension25,
            cornerRadius = DSTheme.dimension.dimension12,
            horizontalPadding = DSTheme.dimension.dimension7,
            verticalPadding = DSTheme.dimension.dimension3,
            textStyle = DSTheme.typography.typography7.semiBold,
        )
        BadgeSize.LARGE -> BadgeStyle(
            height = DSTheme.dimension.dimension29,
            cornerRadius = DSTheme.dimension.dimension13,
            horizontalPadding = DSTheme.dimension.dimension8,
            verticalPadding = DSTheme.dimension.dimension4,
            textStyle = DSTheme.typography.subTypography11.bold,
        )
    }
}

/**
 *
 * Use [DSBadge] to highlight an item's status for quick visual recognition.
 *
 * Always use the predefined [BadgeSize] values to determine the badge size.
 *
 * Do not specify custom height values.
 */
@Composable
fun DSBadge(
    text: String,
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.FILL,
    size: BadgeSize = BadgeSize.MEDIUM,
    colorSet: ColorSet = DSTheme.color.blue,
    isLoading: Boolean = false
) {
    val badgeStyle = badgeStyle(size)
    val badgeShape = RoundedCornerShape(badgeStyle.cornerRadius)

    Box(
        modifier = modifier
            .height(badgeStyle.height)
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
                    horizontal = badgeStyle.horizontalPadding,
                    vertical = badgeStyle.verticalPadding
                ),
            color = when (variant) {
                BadgeVariant.FILL -> colorSet.mainColor
                BadgeVariant.WEAK -> colorSet.subColor
            },
            style = badgeStyle.textStyle
        )
    }
}

@DSPreview
@Composable
fun DSBadgePreview() {
    DSTheme {
        DSBadge(
            text = "DSBadgePreview",
            colorSet = DSTheme.color.blue,
        )
    }
}
