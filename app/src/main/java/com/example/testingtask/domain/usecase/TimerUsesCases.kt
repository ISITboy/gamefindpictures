package com.example.testingtask.domain.usecase

import com.example.testingtask.domain.repository.TimerRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class TimerUsesCases @Inject constructor(
    private val timerRepository: TimerRepository
){
    suspend fun startTimer(coroutineScope: CoroutineScope) =
        timerRepository.startTimer(coroutineScope = coroutineScope)

    fun stopTimer() = timerRepository.stopTimer()

    fun getTime()= timerRepository.getElapsedTime()

    fun formatTimer(milliseconds:Long)=timerRepository.formatTime(milliseconds=milliseconds)
}
