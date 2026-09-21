package com.example.presentation.screen.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.ScreenVariant
import com.example.core.designSystem.component.ScrollVariant

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

        DSText(
            text = "tefdsaafsafsafsafsafsdasdasdfadsafsttestestestest",
            marquee = true
        )

    }
}