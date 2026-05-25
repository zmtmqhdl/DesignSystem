package com.example.core.designSystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.designSystem.DS
import com.example.core.designSystem.core.DSPreview
import com.example.core.designSystem.theme.DSTheme

object DSSnackBar {
    @Composable
    operator fun invoke(
        snackBarHostState: SnackbarHostState,
        icon: ImageVector,
        ariaLabel: String
    ) {
        SnackbarHost(
            hostState = snackBarHostState
        ) { snackBarData ->
            Box(
                modifier = Modifier

            ) {
                Row(
                    modifier = Modifier
                ) {
                    DS.Icon(
                        icon = icon,
                        ariaLabel = ariaLabel
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
        val snackBarHostState = remember { SnackbarHostState() }
    }
}

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .border(
//                        width = DesignSystemTheme.space.space0,
//                        color = color.outline,
//                        shape = DesignSystemTheme.shape.snackBar
//                    )
//                    .background(color = containerColor, shape = DesignSystemTheme.shape.snackBar)
//            ) {
//                Row(
//                    modifier = Modifier.padding(DesignSystemTheme.space.space4),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    icon?.let {
//                        DesignSystemIcon(
//                            icon = icon,
//                            color = iconColor,
//                        )
//                    }
//                    Text(
//                        text = snackBarData.visuals.message,
//                        color = color.fontColor,
//                        textAlign = TextAlign.Center,
//                        style = DesignSystemTheme.typography.s.medium
//                    )
//                }
//            }
//        }
//    )
//}
//
//@DesignSystemPreview
//@Composable
//fun DesignSystemSnackBarPreview() {
//
//    val snackBarHostState = remember { SnackbarHostState() }
//
//    LaunchedEffect(Unit) {
//        snackBarHostState.showSnackbar("message")
//    }
//
//    DesignSystemTheme {
//        DesignSystemSnackBar(
//            snackBarHostState = snackBarHostState,
//            icon = Person,
//            iconColor = DesignSystemTheme.color.primary.fontColor
//        )
//    }
//}