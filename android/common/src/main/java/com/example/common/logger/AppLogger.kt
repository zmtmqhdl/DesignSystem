package com.example.common.logger

import android.util.Log
import com.example.domain.model.AppConfig
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class AppLogger @Inject constructor(
    private val appConfig: AppConfig
) : Logger {

    override fun d(tag: String, message: String) {
        if (appConfig.enableLogging) {
            Log.d(tag, message)
        }
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (appConfig.enableLogging) {
            Log.e(tag, message, throwable)
        }
    }
}