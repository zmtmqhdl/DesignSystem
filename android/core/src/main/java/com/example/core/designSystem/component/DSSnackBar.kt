package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

data class SnackBarIcon(
    val icon: ImageVector,
    val contentDescription: String
)

data class SnackBarAction(
    val text: String,
    val onClick: () -> Unit
)

@Composable
fun DSSnackBar(
    snackBarHostState: SnackbarHostState,
    snackBarIcon: SnackBarIcon? = null,
    snackBarAction: SnackBarAction? = null
) {
    SnackbarHost(
        hostState = snackBarHostState
    ) { snackBarData ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DSTheme.space.space4)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                snackBarIcon?.let {
                    DSIcon(
                        icon = it.icon,
                        ariaLabel = it.contentDescription
                    )

                    Spacer(modifier = Modifier.width(width = 4.dp))
                }

                DSText(
                    text = snackBarData.visuals.message
                )

                snackBarAction?.let {
                    Box(
                        modifier = Modifier.weight(weight = 1f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        DSButton(
                            text = it.text,
                            onClick = it.onClick
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
        val snackBarHostState = remember { SnackbarHostState() }

        DSSnackBar(
            snackBarHostState = snackBarHostState,
        )
    }
}