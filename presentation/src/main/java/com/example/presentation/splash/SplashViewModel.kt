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
) : DesignSystemViewModel<State, Event>(
    initialState = State(),
    viewModelTag = "SplashViewModel"
) {

//    private val _isLoading = MutableStateFlow<Boolean>(false)
//    val isLoading: StateFlow<Boolean> = _isLoading

    val isLoading: StateFlow<Boolean> = state
        .map { it.loading }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = false
        )
}

data class State(
    val loading: Boolean = false,
)

sealed class Event {
    object Idle : Event()
    class ShowError(val message: String) : Event()
}