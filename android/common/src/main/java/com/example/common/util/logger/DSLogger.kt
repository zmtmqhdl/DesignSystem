package com.example.common.util.logger

import android.util.Log
import com.example.domain.model.AppConfig
import com.example.domain.model.Environment
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class DSLogger @Inject constructor(
    private val appConfig: AppConfig
) : Logger {

    override fun d(tag: String, message: String) {
        if (appConfig.environment == Environment.DEV) {
            Log.d(tag, message)
        }
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (appConfig.environment == Environment.DEV) {
            Log.e(tag, message, throwable)
        }
    }
}