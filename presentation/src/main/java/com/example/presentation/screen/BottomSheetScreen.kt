package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.component.DesignSystemButton
import com.example.presentation.component.PrimaryModal
import com.example.presentation.viewModel.BottomSheetViewModel

@Composable
fun BottomSheetScreen(
    bottomSheetViewModel: BottomSheetViewModel,
) {
    val show by bottomSheetViewModel.show.collectAsState()

    PrimaryColumn {
        Spacer(modifier = Modifier.height(50.dp))
        DesignSystemButton.CTA.Large(
            text = "확대",
            onClick = {
                bottomSheetViewModel.showSheet()
            },
            icon = "icon_forward",
            iconPosition = "right",
        )
    }

    PrimaryModal(
        title = "타이틀",
        text = "test",
        onDismissRequest = {
            Log.e("BottomSheetScreen", "onDisMissRequest 호출됨")
            bottomSheetViewModel.hideSheet()
        },
        show = show,
        content = {
            DesignSystemButton.CTA.Large(
                text = "축소",
                onClick = {
                    Log.e("BottomSheetScreen", "축소 버튼 클릭됨")
                    bottomSheetViewModel.hideSheet()
                },
                icon = "icon_forward",
                iconPosition = "right",
            )
        },
    )
}