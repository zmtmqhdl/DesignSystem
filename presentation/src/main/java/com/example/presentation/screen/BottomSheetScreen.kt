package com.example.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.component.PrimaryModal
import com.example.presentation.viewModel.BottomSheetViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScreen(
    bottomSheetViewModel: BottomSheetViewModel,
) {
    val showModalBottomSheet by bottomSheetViewModel.sheetState.collectAsState()

    val scope = rememberCoroutineScope()
    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    PrimaryColumn {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "확대",
            onClick = {
                scope.launch {
                    kotlinx.coroutines.delay(1000)
                }
                bottomSheetViewModel.showSheet()
            },
            icon = "icon_forward",
            iconPosition = "right"
        )
    }

    PrimaryModal(
        title = "타이틀",
        text = "test",
        onDisMissRequest = { bottomSheetViewModel.hideSheet() },
        content = {
            DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    scope.launch { state.hide() }.invokeOnCompletion {
                        if (!state.isVisible) {
                            bottomSheetViewModel.hideSheet()
                        }
                    }
                },
                icon = "icon_forward",
                iconPosition = "right"
            )
        },
        show = showModalBottomSheet,
        state = state
    )
}