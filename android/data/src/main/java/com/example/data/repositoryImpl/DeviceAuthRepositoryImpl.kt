package com.example.data.repositoryImpl

import android.app.KeyguardManager
import android.content.Context
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
}