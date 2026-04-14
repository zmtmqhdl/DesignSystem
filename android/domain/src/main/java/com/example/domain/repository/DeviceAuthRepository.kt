package com.example.domain.repository

import androidx.fragment.app.FragmentActivity
import com.example.domain.model.DeviceAuthResultDomain

interface DeviceAuthRepository {

    fun isLocked(): Boolean

    fun isSecure(): Boolean

    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        onResult: (DeviceAuthResultDomain) -> Unit
    )
}