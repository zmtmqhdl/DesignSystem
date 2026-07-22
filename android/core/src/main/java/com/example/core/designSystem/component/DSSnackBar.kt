package com.example.core.designSystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AccessibilityManager
import androidx.compose.ui.platform.LocalAccessibilityManager
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.animation.snackBarAnimation
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

data class DSSnackBarIcon(
    val icon: ImageVector,
    val ariaLabel: String
)

data class DSSnackBarAction(
    val buttonText: String,
    val onClick: () -> Unit
)

enum class DSSnackBarDuration {
    INFINITE,
    LONG,
    SHORT,
}

internal fun DSSnackBarDuration.toMillis(
    hasAction: Boolean,
    accessibilityManager: AccessibilityManager?,
): Long {
    val original =
        when (this) {
            DSSnackBarDuration.INFINITE -> Long.MAX_VALUE
            DSSnackBarDuration.LONG -> 10000L
            DSSnackBarDuration.SHORT -> 4000L
        }
    if (accessibilityManager == null) {
        return original
    }
    return accessibilityManager.calculateRecommendedTimeoutMillis(
        originalTimeoutMillis = original,
        containsIcons = true,
        containsText = true,
        containsControls = hasAction
    )
}

data class DSSnackBarData(
    val text: String,
    val icon: DSSnackBarIcon?,
    val action: DSSnackBarAction?,
    val duration: DSSnackBarDuration
)

class DSSnackBarState {
    private var _data by mutableStateOf<DSSnackBarData?>(null)
    internal val data: DSSnackBarData?
        get() = _data

    private var _visible by mutableStateOf(false)
    internal val visible: Boolean
        get() = _visible

    fun show(
        text: String,
        icon: DSSnackBarIcon? = null,
        action: DSSnackBarAction? = null,
        duration: DSSnackBarDuration = DSSnackBarDuration.SHORT
    ) {
        _data = DSSnackBarData(
            text = text,
            icon = icon,
            action = action,
            duration = duration
        )
        _visible = true
    }

    fun hide() {
        _visible = false
    }

    internal fun remove() {
        _data = null
    }
}


@Composable
fun DSSnackBar(
    snackBarState: DSSnackBarState,
) {
    val currentData = snackBarState.data
    val accessibilityManager = LocalAccessibilityManager.current
    val shape = DSTheme.shape.snackBar

    LaunchedEffect(currentData) {
        currentData?.let {
            val duration = it.duration.toMillis(
                hasAction = it.action != null,
                accessibilityManager = accessibilityManager
            )
            delay(duration = duration.milliseconds)
            snackBarState.hide()
        }
    }

    currentData?.let { data ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DSTheme.space.dimension10)
                .padding(bottom = DSTheme.space.dimension4)
                .background(
                    color = DSTheme.color.background.background,
                    shape = shape
                )
                .clip(shape = shape)
                .snackBarAnimation(
                    visible = snackBarState.visible,
                    onFinished = {
                        if (!snackBarState.visible) {
                            snackBarState.remove()
                        }
                    }
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = DSTheme.space.dimension2),
                verticalAlignment = Alignment.CenterVertically

            ) {
                data.icon?.let {
                    DSIcon(
                        icon = it.icon,
                        ariaLabel = it.ariaLabel
                    )

                    Spacer(modifier = Modifier.width(width = 4.dp))
                }

                DSText(
                    text = data.text
                )

                data.action?.let {
                    Box(
                        modifier = Modifier.weight(weight = 1f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        DSButton(
                            text = it.buttonText,
                            onClick = {
                                it.onClick()
                                snackBarState.hide()
                            }
                        )
                    }
                }
            }
        }
    }
}

@DSPreview
@Composable
fun DSSnackBarPreview() {
    DSTheme {
        val snackBarState = remember { DSSnackBarState() }

        LaunchedEffect(Unit) {
            snackBarState.show(
                text = "Preview",
                action = DSSnackBarAction(
                    buttonText = "Action",
                    onClick = {
                        snackBarState.hide()
                    }
                ),
                duration = DSSnackBarDuration.INFINITE
            )
        }

        DSSnackBar(
            snackBarState = snackBarState,
        )
    }
}