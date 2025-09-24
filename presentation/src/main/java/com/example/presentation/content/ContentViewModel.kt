package com.example.presentation.content

import com.example.core.designSystem.core.DesignSystemViewModel
import com.example.domain.repository.UiFlowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    uiFlowRepository: UiFlowRepository
): DesignSystemViewModel(
    tag = "ContentViewModel"
){
    val loading = uiFlowRepository.loading
}