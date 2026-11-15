package com.example.presentation.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarDuration
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTextField
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.core.designSystem.component.TextFieldVariant
import com.example.core.designSystem.component.rememberDSSnackBarState
import com.example.core.designSystem.theme.DSTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
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
        padding = true
    ) {
        repeat(1) {
            item {
                Box(
                    modifier = Modifier.width(240.dp)
                ) {
                    DSText(
                        text = "This is DSText marquee component",
                        marquee = true,
                        style = DSTheme.typography.typography5.bold
                    )
                }
            }
        }

    }
}