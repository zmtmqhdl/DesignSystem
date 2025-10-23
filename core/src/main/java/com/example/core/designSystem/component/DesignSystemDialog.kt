package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.core.designSystem.core.DesignSystemPreview
import com.example.core.designSystem.theme.DesignSystemTheme

enum class DialogVariant {
    ALERT,
    CONFIRM
}

@Composable
fun DesignSystemDialog(
    variant: DialogVariant = DialogVariant.ALERT,
    title: String,
    description: String? = null,
    onDismissRequest: (() -> Unit) = {},
    confirmText: String,
    onConfirmClick: () -> Unit = {},
    cancelText: String = "",
    onCancelClick: () -> Unit = {},
    dismissOnBackPress: Boolean = false,
    dismissOnClickOutside: Boolean = false
) {
//    (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0.4f)
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside
        ),
        content = {
            Column(
                modifier = Modifier
                    .padding(all = DesignSystemTheme.space.space4)
            ) {
                when (variant) {
                    DialogVariant.ALERT ->  {
                        DesignSystemText(
                            text = title,
                            style = DesignSystemTheme.typography.typography4.bold,
                        )

                        Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space2))

                        description?.let {
                            DesignSystemText(
                                text = it,
                                style = DesignSystemTheme.typography.typography6.medium
                            )
                        }

                        Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space4))

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            DesignSystemButton(
                                text = confirmText,
                                onClick = onConfirmClick,
                                colorSet = DesignSystemTheme.color.blue
                            )
                        }
                    }

                    DialogVariant.CONFIRM -> {
                        DesignSystemText(
                            text = title,
                            style = DesignSystemTheme.typography.typography4.bold,
                        )

                        Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space2))

                        description?.let {
                            DesignSystemText(
                                text = it,
                                style = DesignSystemTheme.typography.typography6.medium
                            )
                        }

                        Spacer(modifier = Modifier.height(height = DesignSystemTheme.space.space4))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            DesignSystemButton(
                                text = cancelText,
                                onClick = onCancelClick,
                                colorSet = DesignSystemTheme.color.blue,
                                modifier = Modifier.weight(weight = 1f)
                            )

                            Spacer(modifier = Modifier.width(width = DesignSystemTheme.space.space2))

                            DesignSystemButton(
                                text = confirmText,
                                onClick = onConfirmClick,
                                colorSet = DesignSystemTheme.color.blue,
                                modifier = Modifier.weight(weight = 1f)
                            )
                        }
                    }
                }
            }
        }
    )
}

@DesignSystemPreview
@Composable
fun DesignSystemDialogPreview() {
    DesignSystemTheme {
        DesignSystemDialog(
            variant = DialogVariant.CONFIRM,
            title = "title",
            description = "description",
            confirmText = "confirm",
            cancelText = "cancel"
        )
    }
}