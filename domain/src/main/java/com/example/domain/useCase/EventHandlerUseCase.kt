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

//1. viewModelScope를 넣은 경우
//
//job은 HandleEventUseCase 안에서 하나만 관리됩니다.
//
//새로운 invoke가 불릴 때마다 기존 job을 cancel하고, 새 job은 viewModelScope에서 실행됩니다.
//
//따라서 "최근 실행한 ViewModel" 안에서만 collect가 살아남습니다.
//
//화면이 파괴되면 viewModelScope 자체가 cancel 되므로, job도 자동으로 취소됩니다.
//
//👉 결과: "마지막으로 실행한 화면에서만 실행"이 되고, 화면이 없어지면 자동으로 정리됩니다.
//
//2. applicationScope를 넣은 경우
//
//job은 여전히 HandleEventUseCase 안에서 하나만 유지돼요 (job?.cancel() 때문에).
//
//하지만 이번엔 applicationScope에서 실행되므로, ViewModel/화면이 파괴돼도 job은 살아있습니다.
//
//새로운 invoke를 부르면 이전 job은 cancel되고, 새 job이 applicationScope에서 실행됩니다.
//
//즉, "최근에 실행한 것만 유지" 라는 성질은 그대로지만, ViewModel 라이프사이클에 상관없이 살아남습니다.
//
//👉 결과: 화면이 사라져도 job이 살아있음. 즉, 앱 전역에서 "최근 실행한 하나"가 동작.