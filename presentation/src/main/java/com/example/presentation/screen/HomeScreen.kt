package com.example.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
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

    val showModalBottomSheet =remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    PrimaryColumn {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "확대",
            onClick = {
                homeViewModel.insertUser("zz", 20)
                scope.launch {
                    kotlinx.coroutines.delay(1000)
                    homeViewModel.loadUserById(1)
                }
                showModalBottomSheet.value = !showModalBottomSheet.value
                homeViewModel.fetchPost((1))
            },
            icon = "icon_forward",
            iconPosition = "right"
        )
        Spacer(modifier = Modifier.height(16.dp))
        post?.let {
            Text(it.title)
        }
    }

    PrimaryModal(
        title = "타이틀",
        text = userText,
        onDisMissRequest = { showModalBottomSheet.value = false },
        content = {
            DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    scope.launch { state.hide() }.invokeOnCompletion {
                        if (!state.isVisible) {
                            showModalBottomSheet.value = false
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