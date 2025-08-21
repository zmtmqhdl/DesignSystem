package com.example.presentation.splash

import androidx.lifecycle.viewModelScope
import com.example.core.designSystem.core.DesignSystemViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SplashViewModel @Inject constructor(
) : DesignSystemViewModel(
    viewModelTag = "SplashViewModel"
) {
}

data class State(
    val loading: Boolean = false,
)

sealed class Event {
    object Idle : Event()
    class ShowError(val message: String) : Event()
}