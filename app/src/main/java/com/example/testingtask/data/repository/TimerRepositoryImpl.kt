package com.example.testingtask.data.repository

import com.example.testingtask.domain.repository.TimerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimerRepositoryImpl @Inject constructor():TimerRepository {

    private var startTime = 0L
    private var isRunning = false
    private val _elapsedTime = MutableStateFlow(0L)
    override fun getElapsedTime() = _elapsedTime.asStateFlow()

    override fun stopTimer() {
        isRunning = false
    }

    override suspend fun startTimer(coroutineScope: CoroutineScope) {
        if (!isRunning) {
            isRunning = true
            startTime = System.currentTimeMillis()
            startUpdatingTime(coroutineScope)
        }
    }

    private suspend fun startUpdatingTime(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            while (isRunning) {
                val currentTime = System.currentTimeMillis()
                _elapsedTime.value = currentTime - startTime
                delay(1000) // Обновляем каждую секунду
            }
        }
    }

    override fun formatTime(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = (totalSeconds / 60).toInt()
        val seconds = (totalSeconds % 60).toInt()

        val formattedMinutes = if (minutes < 10) "0$minutes" else "$minutes"
        val formattedSeconds = if (seconds < 10) "0$seconds" else "$seconds"

        return "$formattedMinutes:$formattedSeconds"
    }

}