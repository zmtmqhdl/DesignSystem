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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.component.PrimaryNudging
import com.example.presentation.viewModel.HomeViewModel
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onNext: () -> Unit
) {

    val text by homeViewModel.text.collectAsState()

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    PrimaryColumn {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "안녕dd?",
            onClick = {
                showBottomSheet = true
                scope.launch { sheetState.show() }
            },
            icon = "icon_forward",
            iconPosition = "right"
        )
    }

    if (showBottomSheet) {
        PrimaryNudging(
            title = "타이틀",
            text = "테스트",
            content = { DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                },
                icon = "icon_forward",
                iconPosition = "right"
            ) }
        )
    }
}