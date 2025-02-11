package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BottomSheetViewModel : ViewModel() {
    private val _show = MutableStateFlow(false)
    val show: StateFlow<Boolean> = _show

    fun showSheet() {
        _show.value = true
    }

    fun hideSheet() {
        _show.value = false
    }
}