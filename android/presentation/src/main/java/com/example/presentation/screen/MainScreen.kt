package com.example.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.DSIconButton
import com.example.core.designSystem.component.DSNavigationBar
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTopBar
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.core.designSystem.modifier.entranceAnimation
import com.example.core.designSystem.theme.DSTheme
import com.example.presentation.navigation.NavigationItems
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var visible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay (1000)
        while (true) {
            visible = true
            delay(800)

            visible = false
            delay(800)
        }
    }


    DSScreen(
        topBar = {
            DSTopBar(
                title = "preview",
                centeredTitle = false,
                navigationIcon = {
                    DSIconButton(
                        icon = Back,
                        onClick = {},
                        ariaLabel = "뒤로가기"
                    )
                },
                actions = {
                    DSIconButton(
                        icon = Password,
                        onClick = {},
                        ariaLabel = "비밀번호"
                    )

                    DSIconButton(
                        icon = Forward,
                        onClick = {},
                        ariaLabel = "앞으로"
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            DSNavigationBar(
                variant = NavigationBarVariant.ROUND,
                backStack = backStack,
                navigationItems = listOf(
                    NavigationItems.Main,
                    NavigationItems.First
                ),
            )
        },
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DSText(
                text = "대출은 역시 토스뱅크",
                style = DSTheme.typography.typography1.bold,
                modifier = Modifier.entranceAnimation(
                    visible = visible
                )
            )

            DSText(
                text = "복잡한 서류 없이 간편하게",
                style = DSTheme.typography.typography4.regular,
                modifier = Modifier.entranceAnimation(
                    visible = visible,
                    delayMillis = 80
                )
            )

            DSText(
                text = "최대 3억원까지 조회 가능",
                style = DSTheme.typography.typography5.regular,
                modifier = Modifier.entranceAnimation(
                    visible = visible,
                    delayMillis = 160
                )
            )
        }
    }
}