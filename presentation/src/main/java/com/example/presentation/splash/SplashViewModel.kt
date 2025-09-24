package com.example.presentation.splash

import com.example.core.designSystem.core.DesignSystemViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : DesignSystemViewModel(
    tag = "SplashViewModel"
) {
}
