package com.example.core.util.manager.biometricAuth

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.core.util.extension.findFragmentActivity

sealed class DeviceAuthResult {
    object Success : DeviceAuthResult()
    sealed class Failure : DeviceAuthResult() {
        object Canceled : Failure()
        object Locked : Failure()
        object HardwareUnavailable : Failure()
        data class Unknown(val message: String) : Failure()
    }
}


class BiometricAuthManager {
    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        onResult: (DeviceAuthResult) -> Unit
    ) {
        val executor = ContextCompat.getMainExecutor(activity)

        val prompt = BiometricPrompt(
            activity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    onResult(DeviceAuthResult.Success)
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    onResult(mapDeviceAuthResult(errorCode = errorCode, errString = errString))
                }

                override fun onAuthenticationFailed() {
                    onResult(DeviceAuthResult.Failure.Unknown(message = "fail"))
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
    ): DeviceAuthResult.Failure {
        return when (errorCode) {
            // 취소
            BiometricPrompt.ERROR_NEGATIVE_BUTTON,
            BiometricPrompt.ERROR_USER_CANCELED,
            BiometricPrompt.ERROR_CANCELED -> DeviceAuthResult.Failure.Canceled

            // 잠김
            BiometricPrompt.ERROR_LOCKOUT,
            BiometricPrompt.ERROR_LOCKOUT_PERMANENT -> DeviceAuthResult.Failure.Locked

            // 기기 문제
            BiometricPrompt.ERROR_HW_UNAVAILABLE,
            BiometricPrompt.ERROR_NO_BIOMETRICS,
            BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL -> DeviceAuthResult.Failure.HardwareUnavailable

            else -> DeviceAuthResult.Failure.Unknown(errString.toString())
        }
    }
}