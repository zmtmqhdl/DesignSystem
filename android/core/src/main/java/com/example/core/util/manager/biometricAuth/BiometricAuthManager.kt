package com.example.core.util.manager.biometricAuth

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.core.util.extension.findFragmentActivity

@Composable
fun rememberBiometricAuthManager(): (title: String, subtitle: String, onResult: (BiometricAuthResult) -> Unit) -> Unit {
    val context = LocalContext.current
    val biometricAuthManager = remember { BiometricAuthManager() }

    return { title, subtitle, onResult ->
        context.findFragmentActivity()?.let { activity ->
            biometricAuthManager.authenticate(activity, title, subtitle, onResult)
        }
    }
}

class BiometricAuthManager {
    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        onResult: (BiometricAuthResult) -> Unit
    ) {
        val executor = ContextCompat.getMainExecutor(activity)

        val prompt = BiometricPrompt(
            activity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    onResult(BiometricAuthResult.Success)
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    onResult(mapDeviceAuthResult(errorCode = errorCode, errString = errString))
                }

                override fun onAuthenticationFailed() {
                    onResult(BiometricAuthResult.Failure.Unknown(message = "fail"))
                }
            }
        )

        val info = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subtitle)
            .setAllowedAuthenticators(
                BiometricManager.Authenticators.BIOMETRIC_STRONG or
                        BiometricManager.Authenticators.DEVICE_CREDENTIAL
            )
            .build()

        prompt.authenticate(info)
    }

    private fun mapDeviceAuthResult(
        errorCode: Int,
        errString: CharSequence
    ): BiometricAuthResult.Failure {
        return when (errorCode) {
            BiometricPrompt.ERROR_NEGATIVE_BUTTON,
            BiometricPrompt.ERROR_USER_CANCELED,
            BiometricPrompt.ERROR_CANCELED -> BiometricAuthResult.Failure.Canceled

            BiometricPrompt.ERROR_LOCKOUT,
            BiometricPrompt.ERROR_LOCKOUT_PERMANENT -> BiometricAuthResult.Failure.Locked

            BiometricPrompt.ERROR_HW_UNAVAILABLE,
            BiometricPrompt.ERROR_NO_BIOMETRICS,
            BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL -> BiometricAuthResult.Failure.HardwareUnavailable

            else -> BiometricAuthResult.Failure.Unknown(errString.toString())
        }
    }
}