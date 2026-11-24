package com.example.presentation.screen.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.ButtonSize
import com.example.core.designSystem.component.ButtonVariant
import com.example.core.designSystem.component.DSButton
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.core.designSystem.component.rememberDSSnackBarState

@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val viewModel: MainViewModel = hiltViewModel()

    val snackBarState = rememberDSSnackBarState()

    DSScreen(
        variant = ScreenVariant.ScrollColumn(
            scrollVariant = ScrollVariant.NONE
        ),
        snackBarState = snackBarState,
        padding = true,
        scrollContent = {
            ButtonVariant.entries.forEach { variant ->
                ButtonSize.entries.forEach { size ->
                    item {
                        DSButton(
                            text = "${variant.name} ${size.name}",
                            onClick = {},
                            variant = variant,
                            size = size
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }

            ButtonVariant.entries.forEach { variant ->
                ButtonSize.entries.forEach { size ->
                    item {
                        DSButton(
                            text = "${variant.name} ${size.name}",
                            onClick = {},
                            variant = variant,
                            size = size,
                            showLoader = true
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }
    )
}