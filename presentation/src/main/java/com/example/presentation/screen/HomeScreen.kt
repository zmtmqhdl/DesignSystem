package com.example.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onNext: () -> Unit
) {

    val text by homeViewModel.text.collectAsState()

    PrimaryColumn {
        DesignSystemButton.CTA.Large(
            text = "안녕?",
            onClick = {},
            icon = "icon_forward",
            iconPosition = "right"
        )
    }
}