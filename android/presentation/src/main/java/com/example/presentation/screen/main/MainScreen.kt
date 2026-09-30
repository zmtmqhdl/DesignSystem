package com.example.presentation.screen.main

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarDuration
import com.example.core.designSystem.component.DSTextField
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.core.designSystem.component.TextFieldVariant
import com.example.core.designSystem.component.rememberDSSnackBarState
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val viewModel: MainViewModel = hiltViewModel()

    val snackBarState = rememberDSSnackBarState()

    LaunchedEffect(Unit) {
        delay(1000)
        snackBarState.show(
            text = "aaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbcccccccccccccccc",
            buttonText = "Action",
            onActionClick = {
                snackBarState.hide()
            },
            duration = DSSnackBarDuration.SHORT
        )
    }



    DSScreen(
        variant = ScreenVariant.ScrollColumn(
            scrollVariant = ScrollVariant.ENTER_ALWAYS
        ),
        snackBarState = snackBarState,
        padding = true
    ) {

        val state = rememberTextFieldState()

        DSTextField(
            state = state,
            placeholder = "placeholder",
            onKeyboardActionClick = {},
            variant = TextFieldVariant.PASSWORD
        )

    }
}