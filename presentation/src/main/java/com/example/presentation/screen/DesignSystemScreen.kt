package com.example.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.example.presentation.component.PrimaryNavigationBar
import com.example.presentation.theme.DesignSystemSpace

@Composable
fun PrimaryScreen(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = DesignSystemSpace.Space4,
                top = DesignSystemSpace.Space4,
                end = DesignSystemSpace.Space4
            ),
    ) {
        content()
    }
}