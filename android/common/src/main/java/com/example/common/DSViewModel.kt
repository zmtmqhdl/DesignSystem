package com.example.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.logger.Logger
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class DSViewModel() : ViewModel() {
    @Inject
    lateinit var logger: Logger

    protected open val tag: String by lazy { this::class.java.simpleName }

    protected fun logD(message: String) {
        if (::logger.isInitialized) {
            logger.d(tag, message)
        }
    }

    protected fun logE(message: String, throwable: Throwable? = null) {
        if (::logger.isInitialized) {
            logger.e(tag, message, throwable)
        }
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(block = block)
    }

    protected fun launchIO(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = Dispatchers.IO, block = block)
    }
}