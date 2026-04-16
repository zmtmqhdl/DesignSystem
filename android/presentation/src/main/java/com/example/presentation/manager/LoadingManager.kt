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
    val loading : StateFlow<Boolean> = _count.map { it > 0 }
        .stateIn(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate),
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun show() {
        _count.update { it + 1 }
    }

    fun hide() {
        _count.update { it - 1 }
    }









//    private val loadingCount = AtomicInteger(0)
//
//    private val _loading = MutableStateFlow(false)
//    override val loading: StateFlow<Boolean> = _loading.asStateFlow()
//
//    private val _event = MutableSharedFlow<Event>(
//        replay = 0,
//        extraBufferCapacity = 64,
//        onBufferOverflow = BufferOverflow.SUSPEND
//    )
//    override val event: SharedFlow<Event> = _event.asSharedFlow()
//
//    private var showTime: Long = 0L
//    private val minDurationMillis = 1500L
//    private val handler = Handler(Looper.getMainLooper())
//
//    override fun show() {
//        if (loadingCount.incrementAndGet() == 1) {
//            showTime = System.currentTimeMillis()
//            _loading.value = true
//        }
//    }
//
//    override suspend fun hide() {
//        if (loadingCount.decrementAndGet() == 0) {
//            val elapsed = System.currentTimeMillis() - showTime
//            if (elapsed >= minDurationMillis) {
//                _loading.value = false
//            } else {
//                val delayMillis = minDurationMillis - elapsed
//                delay(delayMillis)
//                if (loadingCount.get() == 0) {
//                    _loading.value = false
//                }
//            }
//        }
//    }
//
//    override fun superHide() {
//        loadingCount.set(0)
//        handler.removeCallbacksAndMessages(null)
//        _loading.value = false
//    }
//
//    override suspend fun emitEvent(event: Event) {
//        _event.emit(value = event)
//    }
}