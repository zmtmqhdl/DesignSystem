package com.example.core.designSystem.component

import android.util.Log
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
import androidx.compose.runtime.mutableStateListOf
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
    val icon: ImageVector?,
    val ariaLabel: String?,
    val buttonText: String?,
    val onActionClick: (() -> Unit)?,
    val duration: DSSnackBarDuration
)

class DSSnackBarState {
    private val queue = mutableStateListOf<DSSnackBarData>()

    private var _data by mutableStateOf<DSSnackBarData?>(null)
    internal val data: DSSnackBarData?
        get() = _data

    private var _visible by mutableStateOf(false)
    internal val visible: Boolean
        get() = _visible

    fun show(
        text: String,
        icon: ImageVector? = null,
        ariaLabel: String? = null,
        buttonText: String? = null,
        onActionClick: (() -> Unit)? = null,
        duration: DSSnackBarDuration = DSSnackBarDuration.SHORT
    ) {
        require((icon == null && ariaLabel.isNullOrBlank()) || (icon != null && !ariaLabel.isNullOrBlank())) {
            "icon and ariaLabel must both be provided together or both be null/blank"
        }

        require((buttonText == null && onActionClick == null) || (!buttonText.isNullOrBlank() && onActionClick != null)) {
            "buttonText and onActionClick must both be provided together or both be null"
        }

        val newData = DSSnackBarData(
            text = text,
            icon = icon,
            ariaLabel = ariaLabel,
            buttonText = buttonText,
            onActionClick = onActionClick,
            duration = duration
        )

        if (_data == newData) return

        if (_visible || _data != null) {
            queue.add(newData)
            hide()
        } else {
            _data = newData
            _visible = true
        }
    }

    fun hide() {
        _visible = false
    }

    fun clear() {
        queue.clear()
        _visible = false
        _data = null
    }

    internal fun onAnimationFinished() {
        if (!_visible) {
            if (queue.isNotEmpty()) {
                _data = queue.removeAt(0)
                _visible = true
            } else {
                _data = null
            }
        }
    }
}

@Composable
fun rememberDSSnackBarState(): DSSnackBarState {
    return remember { DSSnackBarState() }
}

@Composable
fun DSSnackBar(
    snackBarState: DSSnackBarState,
) {
    val currentData = snackBarState.data
    val accessibilityManager = LocalAccessibilityManager.current
    val shape = DSTheme.shape.snackBar

    LaunchedEffect(currentData, snackBarState.visible) {
        if (currentData != null && snackBarState.visible) {
            val duration = currentData.duration.toMillis(
                hasAction = currentData.buttonText != null && currentData.onActionClick != null,
                accessibilityManager = accessibilityManager
            )
            if (duration < Long.MAX_VALUE) {
                delay(duration.milliseconds)
                snackBarState.hide()
            }
        }
    }

    currentData?.let { data ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DSTheme.dimension.dimension40)
                .padding(bottom = DSTheme.dimension.dimension16)
                .clip(shape)
                .background(
                    color = DSTheme.color.background.background,
                    shape = shape
                )
                .snackBarAnimation(
                    visible = snackBarState.visible,
                    onFinished = {
                        snackBarState.onAnimationFinished()
                    }
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = DSTheme.dimension.dimension8),
                verticalAlignment = Alignment.CenterVertically

            ) {
                val icon = data.icon
                val ariaLabel = data.ariaLabel

                if (icon != null && ariaLabel != null) {
                    DSIcon(
                        icon = icon,
                        ariaLabel = ariaLabel
                    )

                    Spacer(modifier = Modifier.width(DSTheme.dimension.dimension4))
                }

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    DSText( text = data.text )
                }

                val buttonText = data.buttonText
                val onActionClick = data.onActionClick

                if (buttonText != null && onActionClick != null) {
                    Spacer(modifier = Modifier.width(DSTheme.dimension.dimension8))

                    DSButton(
                        text = buttonText,
                        onClick = {
                            onActionClick.invoke()
                            snackBarState.hide()
                        }
                    )
                }
            }
        }
    }
}

@DSPreview
@Composable
fun DSSnackBarPreview() {
    DSTheme {
        val snackBarState = rememberDSSnackBarState()

        LaunchedEffect(Unit) {
            snackBarState.show(
                text = "Preview",
                buttonText = "Action",
                onActionClick = {
                    snackBarState.hide()
                },
                duration = DSSnackBarDuration.INFINITE
            )
        }

        DSSnackBar(
            snackBarState = snackBarState,
        )
    }
}