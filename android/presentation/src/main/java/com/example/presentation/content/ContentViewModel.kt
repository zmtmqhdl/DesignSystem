package com.example.presentation.content

import com.example.core.designSystem.core.DesignSystemViewModel
import com.example.presentation.manager.LoadingManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val loadingManager: LoadingManager
): DesignSystemViewModel(
    tag = "ContentViewModel"
) {
   val loading = loadingManager.loading


}