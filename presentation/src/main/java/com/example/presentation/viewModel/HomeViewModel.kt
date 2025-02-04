package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.data.repository.UserRepository
import com.example.data.room.UserEntity

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _text = MutableStateFlow("abcdefg")
    val text: StateFlow<String> = _text

    private val _sheetState = MutableStateFlow(false)
    val sheetState: StateFlow<Boolean> = _sheetState

    fun showSheet() {
        _sheetState.value = true
    }

    fun hideSheet() {
        _sheetState.value = false
    }

    private val _userText = MutableStateFlow("Loading...")
    val userText: StateFlow<String> = _userText

    fun loadUserById(id: Int) {
        viewModelScope.launch {
            val user = userRepository.getUserById(id)
            _userText.value = user?.let { "${it.name} ${it.age}살" } ?: "User not found"
        }
    }

    fun insertUser(name: String, age: Int) {
        viewModelScope.launch {
            val user = UserEntity(name = name, age = age)
            userRepository.insertUser(user)
        }
    }
}