package com.example.presentation.content

import com.example.core.designSystem.core.DSViewModel
import com.example.presentation.manager.LoadingManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val loadingManager: LoadingManager
): DSViewModel() {
   val loading = loadingManager.loading


}