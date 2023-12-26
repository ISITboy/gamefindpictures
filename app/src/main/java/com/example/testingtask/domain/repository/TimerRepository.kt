package com.example.testingtask.domain.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface TimerRepository {
    fun stopTimer()
    suspend fun startTimer(coroutineScope: CoroutineScope)
    fun formatTime(milliseconds: Long):String
    fun getElapsedTime(): StateFlow<Long>
}