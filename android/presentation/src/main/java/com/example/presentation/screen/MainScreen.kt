package com.example.presentation.screen

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.core.designSystem.component.BottomSheetVariant
import com.example.core.designSystem.component.DSBottomSheet
import com.example.core.designSystem.component.DSButton
import com.example.core.designSystem.component.DSIconButton
import com.example.core.designSystem.component.DSNavigationBar
import com.example.core.designSystem.component.DSScreen
import com.example.core.designSystem.component.DSSnackBarState
import com.example.core.designSystem.component.DSText
import com.example.core.designSystem.component.NavigationBarVariant
import com.example.core.designSystem.icon.Close
import com.example.core.util.extension.findFragmentActivity
import com.example.core.util.manager.biometricAuth.BiometricAuthManager
import com.example.core.util.manager.biometricAuth.DeviceAuthResult
import com.example.presentation.navigation.NavigationItems
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    backStack: NavBackStack<NavKey>
) {
    val snackBarHostState = remember { DSSnackBarState() }

    var isBottomSheetOpen by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(3000)
        isBottomSheetOpen = true
    }

    DSBottomSheet(
        variant = BottomSheetVariant.CTA,
        title = "안내 타이틀",
        description = "상세 설명 내용이 들어가는 영역입니다.",
        confirmText = "확인",
        cancelText = "취소",
        onDismissRequest = {},
        isOpen = isBottomSheetOpen
    )

    DSScreen(
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
            onClick = {

            },
            loading = true
        )

        DSIconButton(
            icon = Close,
            onClick = {},
            ariaLabel = ""
        )

    }

}

