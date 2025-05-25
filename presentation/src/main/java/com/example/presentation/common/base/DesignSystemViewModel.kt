package com.example.presentation.common.base

import android.util.Log
import androidx.lifecycle.ViewModel

open class DesignSystemViewModel(private val tag: String) : ViewModel() {
    protected fun logD(message: String) {
        Log.d(tag, message)
    }
}