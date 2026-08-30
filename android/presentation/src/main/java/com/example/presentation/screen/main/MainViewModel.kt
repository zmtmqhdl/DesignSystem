package com.example.presentation.screen.main

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.common.DSViewModel
import com.example.domain.model.domain.ProductDomain
import com.example.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository
): DSViewModel() {
    fun test() {
        logD("logger test")
    }

}