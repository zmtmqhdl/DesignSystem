package com.example.domain.model

sealed class DeviceAuthResultDomain {
    object Success : DeviceAuthResultDomain()

    sealed class Failure : DeviceAuthResultDomain() {
        object Canceled : Failure()
        object Locked : Failure()
        object HardwareUnavailable : Failure()
        data class Unknown(val message: String) : Failure()
    }
}