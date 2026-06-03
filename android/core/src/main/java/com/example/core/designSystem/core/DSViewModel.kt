package com.example.core.designSystem.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// todo - 인터페이스가 맞을까?> 아니면 이게 맞을까?
abstract class DSViewModel : ViewModel() {

    protected open val tag: String by lazy { this::class.java.simpleName }

    protected fun logD(message: String) {
        Log.d(tag, message)

    }

    protected fun logE(message: String) {
        Log.e(tag, message)

    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(block = block)
    }

    protected fun launchIO(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = Dispatchers.IO, block = block)
    }
}