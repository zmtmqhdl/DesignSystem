package com.example.data.repositoryImpl

import android.app.KeyguardManager
import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.domain.model.DeviceAuthResultDomain
import com.example.domain.repository.DeviceAuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class DeviceAuthRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : DeviceAuthRepository {

    private val km by lazy {
        context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
    }

    override fun isLocked(): Boolean = km.isKeyguardLocked

    override fun isSecure(): Boolean = km.isKeyguardSecure

    override fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        onResult: (DeviceAuthResultDomain) -> Unit
    ) {
        val executor = ContextCompat.getMainExecutor(activity)

        val prompt = BiometricPrompt(
            activity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    onResult(DeviceAuthResultDomain.Success)
                }

                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    onResult(mapDeviceAuthResult(errorCode, errString))
                }

                override fun onAuthenticationFailed() {
                    onResult(DeviceAuthResultDomain.Failure.Unknown("생체 인증 실패"))
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

    private fun mapDeviceAuthResult(errorCode: Int, errString: CharSequence): DeviceAuthResultDomain.Failure {
        return when (errorCode) {

            // 취소
            BiometricPrompt.ERROR_NEGATIVE_BUTTON,
            BiometricPrompt.ERROR_USER_CANCELED,
            BiometricPrompt.ERROR_CANCELED -> DeviceAuthResultDomain.Failure.Canceled

            // 잠김
            BiometricPrompt.ERROR_LOCKOUT,
            BiometricPrompt.ERROR_LOCKOUT_PERMANENT -> DeviceAuthResultDomain.Failure.Locked

            // 기기 문제
            BiometricPrompt.ERROR_HW_UNAVAILABLE,
            BiometricPrompt.ERROR_NO_BIOMETRICS,
            BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL -> DeviceAuthResultDomain.Failure.HardwareUnavailable

            else -> DeviceAuthResultDomain.Failure.Unknown(errString.toString())
        }
    }
}