package com.example.domain.useCase

import com.example.domain.repository.UiFlowRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HandleEventUseCase @Inject constructor(
    private val uiFlowRepository: UiFlowRepository
) {
    private var job: Job? = null
    operator fun invoke(
        viewModelScope: CoroutineScope,
        createWaitingRoomFailure: () -> Unit = {},
    ) {
        job?.cancel()
        job = viewModelScope.launch {
            uiFlowRepository.event.collect {
                when (it) {
                    else -> {}
                }
            }
        }
    }
}