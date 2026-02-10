package com.example.presentation.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
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
    backStack: NavBackStack<NavKey>
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
                backStack = backStack,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.First
                ),
            )
        },
    ) {

    }
}