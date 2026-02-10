package com.example.core.designSystem.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.core.BuildConfig.DEBUG

abstract class DesignSystemViewModel(
    private val tag: String,
) : ViewModel() {

    protected fun logD(message: String, tag: String = this@DesignSystemViewModel.tag) {
        if (DEBUG) {
            Log.d(tag, message)
        }
    }

    protected fun logE(message: String, tag: String = this@DesignSystemViewModel.tag) {
        if (DEBUG) {
            Log.e(tag, message)
        }
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(block = block)
    }

    protected fun launchIO(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = Dispatchers.IO, block = block)
    }
}