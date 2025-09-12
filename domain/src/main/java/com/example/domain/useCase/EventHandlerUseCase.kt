package com.example.domain.useCase

import com.example.domain.repository.UiFlowRepository
import javax.inject.Inject

class HandleEventUseCase @Inject constructor(
    private val uiFlowRepository: UiFlowRepository
) {
    suspend operator fun invoke(
        createWaitingRoomFailure: () -> Unit = {},
    ) {
        uiFlowRepository.event.collect {
            when (it) {
                else -> {}
            }
        }
    }
}