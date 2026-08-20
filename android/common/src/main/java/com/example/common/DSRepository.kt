package com.example.common

import com.example.common.util.logger.DSLogger

abstract class DSRepository {
    protected val tag: String by lazy { this::class.java.simpleName }

    protected fun logD(message: String) {
        DSLogger.d(
            tag = tag,
            message = message
        )
    }

    protected fun logE(message: String, throwable: Throwable? = null) {
        DSLogger.e(
            tag = tag,
            message = message,
            throwable = throwable
        )
    }
}