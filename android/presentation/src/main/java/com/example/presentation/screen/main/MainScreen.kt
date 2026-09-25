package com.example.presentation.screen.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.BadgeSize
import com.example.core.designSystem.component.DSBadge
import com.example.core.designSystem.component.DSIconButton
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTextField
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant
import com.example.core.designSystem.component.TextFieldVariant
import com.example.core.designSystem.icon.Search
import com.example.core.designSystem.theme.DSTheme
import com.example.core.designSystem.theme.DSTheme.invoke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val snackBarHostState = remember { DSSnackBarState() }
    val viewModel: MainViewModel = hiltViewModel()

//    DSBottomSheet(
//        variant = BottomSheetVariant.CTA,
//        title = "title",
//        description = "description",
//        confirmText = "confirm",
//        cancelText = "cancel",
//        onDismissRequest = {},
//        isOpen = true
//    )

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