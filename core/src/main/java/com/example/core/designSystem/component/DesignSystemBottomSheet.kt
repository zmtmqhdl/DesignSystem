package com.example.core.designSystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.core.designSystem.theme.BackgroundColorSet
import com.example.core.designSystem.theme.DesignSystemTheme
import kotlinx.coroutines.launch

enum class BottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignSystemBottomSheet(
    title: String,
    description: String? = null,
    onDismissRequest: () -> Unit,
    show: Boolean,
    colorSet: BackgroundColorSet = DesignSystemTheme.colorSet.background,
    content: @Composable () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == SheetValue.Expanded && !show) {
            onDismissRequest()
        }
    }

    LaunchedEffect(show) {
        if (show) {
            scope.launch { sheetState.expand() }
        } else {
            scope.launch { sheetState.hide() }
        }
    }

    if (show || sheetState.currentValue != SheetValue.Hidden) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
                .padding(bottom = DesignSystemTheme.space.space2)
                .padding(horizontal = DesignSystemTheme.space.space2),
            shape = DesignSystemTheme.shape.bottomSheet,
            containerColor = colorSet.background,
        ) {
            Column(
                modifier = Modifier.padding(
                    start = DesignSystemTheme.space.space4,
                    end = DesignSystemTheme.space.space4,
                    bottom = DesignSystemTheme.space.space4
                )
            ) {
                Spacer(modifier = Modifier.height(DesignSystemTheme.space.space10))
                title?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(bottom = DesignSystemTheme.space.space2),
                        color = DesignSystemTheme.colorSet.black,
                        style = DesignSystemTheme.typography.xl.bold
                    )
                }
                Text(
                    text = text,
                    modifier = Modifier.padding(bottom = DesignSystemTheme.space.space4),
                    color = DesignSystemTheme.colorSet.black,
                    style = DesignSystemTheme.typography.m.regular
                )
                Spacer(modifier = Modifier.height(DesignSystemTheme.space.space6))
                content()
            }
        }
    }
}