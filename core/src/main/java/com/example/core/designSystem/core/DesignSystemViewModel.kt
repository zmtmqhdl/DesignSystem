package com.example.core.designSystem.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class DesignSystemViewModel(
    private val tag: String,
) : ViewModel() {

    protected fun logD(message: String, tag: String = this@DesignSystemViewModel.tag) {
        Log.d(tag, message)
    }

    protected fun launchIO(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = Dispatchers.IO, block = block)
    }
}