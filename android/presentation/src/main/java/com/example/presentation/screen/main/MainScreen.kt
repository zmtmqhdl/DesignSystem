package com.example.presentation.screen.main

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSDialog
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSTextField
import com.example.core.designSystem.component.DialogVariant
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.core.designSystem.component.TextFieldVariant
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val snackBarHostState = remember { DSSnackBarState() }
    val viewModel: MainViewModel = hiltViewModel()

    var showDialog by remember { mutableStateOf(false) }

    // 2. 상태가 true일 때만 다이얼로그 컴포저블을 호출
    if (showDialog) {
        DSDialog(
            variant = DialogVariant.ALERT,
            title = "알림",
            description = "정말로 진행하시겠습니까?",
            confirmText = "확인",
            onConfirmClick = {
                showDialog = false
            },
            onDismissRequest = {
                showDialog = false
            }
        )
    }

    LaunchedEffect(Unit) {
        delay(3000)
        showDialog = true
    }

    DSScreen(
        variant = ScreenVariant.ScrollColumn(
            scrollVariant = ScrollVariant.ENTER_ALWAYS
        ),
        snackBarState = snackBarHostState,
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