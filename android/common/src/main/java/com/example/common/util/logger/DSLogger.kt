package com.example.common.util.logger

import android.util.Log
import com.example.domain.model.AppConfig
import com.example.domain.model.Environment

object DSLogger {

    private lateinit var appConfig: AppConfig

    fun initialize(appConfig: AppConfig) {
        this.appConfig = appConfig
    }

    fun d(tag: String, message: String) {
        if (::appConfig.isInitialized && appConfig.environment == Environment.DEV) {
            log(Log.DEBUG, tag, message)
        }
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        if (::appConfig.isInitialized && appConfig.environment == Environment.DEV) {
            log(Log.ERROR, tag, message, throwable)
        }
    }

    private fun log(
        level: Int,
        tag: String,
        message: String,
        throwable: Throwable? = null
    ) {
        val caller = getCallerStackTraceElement()
        val callerInfo = caller?.let {
            "[${it.fileName}:${it.lineNumber}-${it.methodName}]"
        } ?: "[Unknown]"
        val finalMessage = "$callerInfo $message"

        when (level) {
            Log.DEBUG -> Log.d(tag, finalMessage)
            Log.ERROR -> Log.e(tag, finalMessage, throwable)
        }
    }

    private fun getCallerStackTraceElement(): StackTraceElement? {
        return Thread.currentThread().stackTrace
            .firstOrNull { element ->
                !element.className.startsWith(DSLogger::class.java.name) &&
                        element.className != Thread::class.java.name
            }
    }
}