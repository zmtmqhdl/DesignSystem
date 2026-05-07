package com.example.core.designSystem.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.scheme.ColorSet
import kotlinx.coroutines.launch

enum class DialogVariant {
    ALERT,
    CONFIRM
}

@Composable
fun DSDialog(
    variant: DialogVariant = DialogVariant.ALERT,
    title: String,
    description: String? = null,
    onDismissRequest: (() -> Unit) = {},
    confirmText: String,
    onConfirmClick: () -> Unit = {},
    cancelText: String = "",
    onCancelClick: () -> Unit = {},
    cancelButtonColorSet: ColorSet = DSTheme.color.red,
    dismissOnBackPress: Boolean = false,
    dismissOnClickOutside: Boolean = false,
    animation: Boolean = true
) {
    val coroutineScope = rememberCoroutineScope()
    val shakeOffset = remember { Animatable(0f) }

    val handleDismiss: () -> Unit = {
        if (animation) {
            coroutineScope.launch {
                val duration = 1000
                val keyframes = keyframes {
                    durationMillis = duration
                    0f at 0
                    10f at 100
                    (-8f) at 200
                    6f at 300
                    (-4f) at 400
                    3f at 500
                    (-2f) at 600
                    1f at 700
                    (-0.5f) at 800
                    0f at 1000
                }
                shakeOffset.animateTo(
                    targetValue = 0f,
                    animationSpec = keyframes
                )
            }
        } else {
            onDismissRequest()
        }
    }

    Dialog(
        onDismissRequest = handleDismiss,
        properties = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside
        ),
        content = {
            Column(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = shakeOffset.value.dp.roundToPx(),
                            y = 0
                        )
                    }
                    .background(
                        color = DSTheme.color.background.background,
                        shape = DSTheme.shape.dialog
                    )
                    .padding(all = 16.dp)
            ) {
                DSText(
                    text = title,
                    style = DSTheme.typography.typography4.bold,
                )

                description?.let {
                    Spacer(modifier = Modifier.height(DSTheme.space.space2))

                    DSText(
                        text = it,
                        style = DSTheme.typography.typography6.medium
                    )
                }

                Spacer(modifier = Modifier.height(DSTheme.space.space8))

                when (variant) {
                    DialogVariant.ALERT -> {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            DSButton(
                                text = confirmText,
                                onClick = onConfirmClick,
                                colorSet = DSTheme.color.blue
                            )
                        }
                    }

                    DialogVariant.CONFIRM -> {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            DSButton(
                                text = cancelText,
                                onClick = onCancelClick,
                                colorSet = cancelButtonColorSet,
                                variant = ButtonVariant.WEAK,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(1f)
                            )

                            Spacer(modifier = Modifier.width(DSTheme.space.space2))

                            DSButton(
                                text = confirmText,
                                onClick = onConfirmClick,
                                colorSet = DSTheme.color.blue,
                                size = ButtonSize.LARGE,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    )
}

@DSPreview
@Composable
fun DialogPreview() {
    DSTheme {
        DSDialog(
            variant = DialogVariant.ALERT,
            title = "title",
            description = "description",
            confirmText = "confirm",
            cancelText = "cancel",
            dismissOnClickOutside = true
        )
    }
}