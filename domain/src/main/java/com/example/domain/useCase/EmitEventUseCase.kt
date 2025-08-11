package com.example.domain.useCase

import com.example.domain.Event
import com.example.domain.repository.LoadingRepository
import javax.inject.Inject

class EmitEventUseCase @Inject constructor(
    private val loadingRepository: LoadingRepository
) {
    suspend operator fun invoke(event: Event) {
        loadingRepository.emitEvent(event = event)
    }
}