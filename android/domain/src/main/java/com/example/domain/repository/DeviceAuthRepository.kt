package com.example.domain.repository

interface DeviceAuthRepository {
    fun isLocked(): Boolean
    fun isSecure(): Boolean
}