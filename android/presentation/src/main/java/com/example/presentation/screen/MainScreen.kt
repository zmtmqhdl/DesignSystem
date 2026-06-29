package com.example.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.BottomSheetVariant
import com.example.core.designSystem.component.DSBottomSheet
import com.example.core.designSystem.component.DSButton
import com.example.core.designSystem.component.DSIconButton
import com.example.core.designSystem.component.DSNavigationBar
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarAction
import com.example.core.designSystem.component.DSSnackBarDuration
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.DSTopBar
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.icon.Back
import com.example.core.designSystem.icon.Close
import com.example.core.designSystem.icon.Forward
import com.example.core.designSystem.icon.Password
import com.example.presentation.navigation.NavigationItems
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            rememberTopAppBarState()
        )

    val snackBarHostState = remember { DSSnackBarState() }

    var isBottomSheetOpen by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        delay(1000)
        isBottomSheetOpen = true
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
        snackBarState = snackBarHostState
    ) {


            DSText(
                text = "sldakfldjs;kffdljsk;alfsdj;kadfgdsfggdsfdgsafsadfsafdasdfgdfgasdsafddgfsadfdafgssadfsdafjlksdfa",
                maxLines = 1,
                marquee = true
            )

            DSButton(
                text = "이것은 버튼",
                onClick = {},
                loading = true
            )

            DSIconButton(
                icon = Close,
                onClick = {},
                ariaLabel = ""
            )

    }

}