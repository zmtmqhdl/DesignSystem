package com.example.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.common.IconPosition
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.component.PrimaryModal
import com.example.presentation.viewModel.HomeViewModel
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onNext: () -> Unit
) {
    val userText by homeViewModel.userText.collectAsState()
    val post by homeViewModel.post.collectAsState()


    val showModalBottomSheet by homeViewModel.sheetState.collectAsState()
    val scope = rememberCoroutineScope()
    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    PrimaryScreen {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "확대",
            onClick = {
                homeViewModel.insertUser("zz", 20)
                scope.launch {
                    kotlinx.coroutines.delay(1000)
                    homeViewModel.loadUserById(1)
                }
                homeViewModel.showSheet()
                homeViewModel.fetchPost((1))
            },
            icon = "icon_forward",
            iconPosition = IconPosition.RIGHT
        )
        Spacer(modifier = Modifier.height(16.dp))
        post?.let {
            Text(it.title)
        }
    }

    PrimaryModal(
        title = "타이틀",
        text = userText,
        onDismissRequest = { homeViewModel.hideSheet() },
        content = {
            DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    scope.launch { state.hide() }.invokeOnCompletion {
                        if (!state.isVisible) {
                            homeViewModel.hideSheet()
                        }
                    }
                },
                icon = "icon_forward",
                iconPosition = IconPosition.RIGHT
            )
        },
        show = showModalBottomSheet,
    )
}