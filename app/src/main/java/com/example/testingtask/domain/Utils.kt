package com.example.testingtask.domain

object Utils {
    fun calculateScore(elapsedTime: Long): Int {
        val maxReward = 100
        val minReward = 10
        val maxTime = 20_000
        val timeThreshold = 1_000

        return if (elapsedTime <= maxTime) {
            maxReward
        } else {
            val extraTime = (elapsedTime - maxTime) / timeThreshold
            val reward = maxReward - (extraTime.toInt() * 5)
            maxOf(reward, minReward)
        }
    }
}