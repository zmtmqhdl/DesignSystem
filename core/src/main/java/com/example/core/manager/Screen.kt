package com.example.core.manager

import android.graphics.Color
import androidx.compose.runtime.Composable


//@Composable
//fun LoadingScreen(
//    containerColor: Color = DesignSystemTheme.color.background,
//    loading: Boolean,
//    loadingColor: Color = DesignSystemTheme.color.primary.background,
//    content: @Composable () -> Unit
//) {
//    Box(
//        modifier = Modifier.fillMaxSize().background(color = containerColor)
//    ) {
//        content()
//
//        if (loading) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(DesignSystemTheme.color.black.copy(alpha = 0.3f))
//                    .clickable(enabled = false) {},
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator(
//                    modifier = Modifier.size(DesignSystemTheme.space.space12),
//                    color = loadingColor,
//                    strokeWidth = DesignSystemTheme.space.space1
//                )
//            }
//        }
//    }
//}