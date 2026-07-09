package com.example.core.util.manager.biometricAuth

sealed class BiometricAuthResult {
    object Success : BiometricAuthResult()
    sealed class Failure : BiometricAuthResult() {
        object Canceled : Failure()
        object Locked : Failure()
        object HardwareUnavailable : Failure()
        data class Unknown(val message: String) : Failure()
    }
}