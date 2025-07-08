package com.example.core.manager

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.atomic.AtomicInteger

object LoadingManager {
    private val loadingCount = AtomicInteger(0)
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private var showTime: Long = 0L
    private val minDurationMillis = 1000L  // 최소 로딩 시간

    private val handler = Handler(Looper.getMainLooper())

    fun show() {
        if (loadingCount.incrementAndGet() == 1) {
            showTime = System.currentTimeMillis()
            _loading.value = true
        }
    }

    fun hide() {
        if (loadingCount.decrementAndGet() == 0) {
            val elapsed = System.currentTimeMillis() - showTime
            if (elapsed >= minDurationMillis) {
                _loading.value = false
            } else {
                val delay = minDurationMillis - elapsed
                handler.postDelayed({
                    if (loadingCount.get() == 0) {
                        _loading.value = false
                    }
                }, delay)
            }
        }
    }

    fun superHide() {
        loadingCount.set(0)
        handler.removeCallbacksAndMessages(null)
        _loading.value = false
    }
}