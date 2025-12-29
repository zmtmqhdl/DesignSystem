package com.example.presentation.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.core.designSystem.component.DesignSystemIconButton
import com.example.core.designSystem.component.DesignSystemNavigationBar
import com.example.core.designSystem.component.DesignSystemScreen
import com.example.core.designSystem.component.DesignSystemTopBar
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.presentation.navigation.NavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    DesignSystemScreen(
        topBar = {
            DesignSystemTopBar(
                title = "preview",
                centeredTitle = false,
                navigationIcon = {
                    DesignSystemIconButton(
                        icon = Back,
                        onClick = {},
                        ariaLabel = "뒤로가기"
                    )
                },
                actions = {
                    DesignSystemIconButton(
                        icon = Password,
                        onClick = {},
                        ariaLabel = "비밀번호"
                    )

                    DesignSystemIconButton(
                        icon = Forward,
                        onClick = {},
                        ariaLabel = "앞으로"
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            DesignSystemNavigationBar(
                variant = NavigationBarVariant.ROUND,
                navController = navController,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.Test
                )
            )
        },
    ) {
    }
}