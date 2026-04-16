package com.example.domain.useCase

import com.example.domain.Event
import javax.inject.Inject

class EmitEventUseCase @Inject constructor(
    private val uiFlowRepository: UiFlowRepository
) {
    suspend operator fun invoke(event: Event) {
        uiFlowRepository.emitEvent(event = event)
    }
}