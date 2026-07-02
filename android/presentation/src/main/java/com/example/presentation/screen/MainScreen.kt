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
    val context = LocalContext.current
    val activity = remember(context) { context.findFragmentActivity() }
    val biometricAuthManager = remember { BiometricAuthManager() }

    val snackBarHostState = remember { DSSnackBarState() }

    var isBottomSheetOpen by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        delay(1000)
        isBottomSheetOpen = true
    }

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
                if (activity != null) {
                    biometricAuthManager.authenticate(
                        activity = activity,
                        title = "테스트 인증",
                        subtitle = "생체 인증을 테스트합니다.",
                        onResult = { result ->
                            // 💡 인증 결과 처리
                            when (result) {
                                is DeviceAuthResult.Success -> {
                                    Toast.makeText(context, "인증 성공! 🎉", Toast.LENGTH_SHORT).show()
                                }
                                is DeviceAuthResult.Failure.Canceled -> {
                                    Toast.makeText(context, "사용자가 취소함 ❌", Toast.LENGTH_SHORT).show()
                                }
                                is DeviceAuthResult.Failure.Locked -> {
                                    Toast.makeText(context, "인증 시도 초과로 잠김 🔒", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    Toast.makeText(context, "실패: ${result}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    )
                }
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

