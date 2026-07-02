package com.example.core.util.manager.biometricAuth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.core.util.extension.findFragmentActivity

@Composable
fun rememberBiometricAuthManager(): (title: String, subtitle: String, onResult: (DeviceAuthResult) -> Unit) -> Unit {
    val context = LocalContext.current
    val biometricAuthManager = remember { BiometricAuthManager() }

    return { title, subtitle, onResult ->
        context.findFragmentActivity()?.let { activity ->
            biometricAuthManager.authenticate(activity, title, subtitle, onResult)
        }
    }
}