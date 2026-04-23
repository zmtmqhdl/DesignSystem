package com.example.presentation.manager

import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

@Singleton
class LoadingManager @Inject constructor() {
    private val _count = MutableStateFlow(0)
    val loading : StateFlow<Boolean> = _count
        .map { it > 0 }
        .stateIn(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate),
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun show() {
        _count.update { it + 1 }
    }

    fun hide() {
        _count.update {
            (it - 1).coerceAtLeast(minimumValue = 0)
        }
    }
}