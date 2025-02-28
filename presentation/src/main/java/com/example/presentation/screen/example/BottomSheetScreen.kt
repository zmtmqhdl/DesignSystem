package com.example.presentation.screen.example

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.common.IconPosition
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.component.PrimaryModal
import com.example.presentation.screen.PrimaryScreen
import com.example.presentation.viewModel.example.BottomSheetViewModel

@Composable
fun BottomSheetScreen(
    bottomSheetViewModel: BottomSheetViewModel,
) {
    val show by bottomSheetViewModel.show.collectAsState()

    PrimaryScreen {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "확대",
            onClick = {
                bottomSheetViewModel.showSheet()
            },
            icon = "icon_forward",
            iconPosition = IconPosition.RIGHT,
        )
    }

    PrimaryModal(
        title = "타이틀",
        text = "test",
        onDismissRequest = {
            bottomSheetViewModel.hideSheet()
        },
        show = show,
        content = {
            DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    bottomSheetViewModel.hideSheet()
                    Log.e("test", "${show}")
                },
                icon = "icon_forward",
                iconPosition = IconPosition.RIGHT,
            )
        },
    )
}