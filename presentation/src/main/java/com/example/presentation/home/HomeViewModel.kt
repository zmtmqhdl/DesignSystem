package com.example.presentation.home

import androidx.lifecycle.ViewModel
import com.example.domain.repository.RetrofitRepository
import com.example.domain.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val roomRepository: RoomRepository,
    private val retrofitRepository: RetrofitRepository
) : ViewModel() {



}