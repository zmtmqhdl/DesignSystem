package com.example.core.designSystem.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
    cancelText: String? = null,
    onCancelClick: () -> Unit = {},
    cancelButtonColorSet: ColorSet = DSTheme.color.red,
    dismissOnBackPress: Boolean = false,
    dismissOnClickOutside: Boolean = false,
) {
    val shape = DSTheme.shape.dialog
    val coroutineScope = rememberCoroutineScope()
    val shakeOffset = remember { Animatable(0f) }
    val shakeAnimation = keyframes {
        durationMillis = 350
        0f at 0
        (-3f) at 70
        3f at 140
        (-2f) at 210
        1f at 280
        0f at 350
    }

    val triggerShake = {
        coroutineScope.launch {
            shakeOffset.animateTo(
                targetValue = 0f,
                animationSpec = shakeAnimation
            )
        }
    }

    Dialog(
        onDismissRequest = {
            if (dismissOnBackPress) {
                onDismissRequest()
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = false,
        ),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        if (dismissOnClickOutside) {
                            onDismissRequest()
                        } else {
                            triggerShake()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                x = shakeOffset.value.dp.roundToPx(),
                                y = 0
                            )
                        }
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {}
                        .background(
                            color = DSTheme.color.background.background,
                            shape = shape
                        )
                        .padding(all = 16.dp)
                ) {
                    DSText(
                        text = title,
                        style = DSTheme.typography.typography4.bold,
                    )

                    description?.let {
                        Spacer(modifier = Modifier.height(DSTheme.dimension.dimension8))

                        DSText(
                            text = it,
                            style = DSTheme.typography.typography6.medium
                        )
                    }

                    Spacer(modifier = Modifier.height(DSTheme.dimension.dimension32))

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
                            require(value = !cancelText.isNullOrBlank()) {
                                "cancelText must be provided when variant is CONFIRM."
                            }

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

                                Spacer(modifier = Modifier.width(DSTheme.dimension.dimension8))

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