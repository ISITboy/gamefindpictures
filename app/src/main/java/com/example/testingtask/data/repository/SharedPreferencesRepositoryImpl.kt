package com.example.testingtask.data.repository

import com.example.testingtask.data.storage.sharedPref.SharedPreferences
import com.example.testingtask.domain.repository.SharedPreferencesRepository
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
):SharedPreferencesRepository {

    override fun save(score: String): Boolean {
        sharedPreferences().edit().putString(KEY_SCORE,score).apply()
        return true
    }

    override fun get(): String {
        return sharedPreferences().getString(KEY_SCORE,"0") ?: "0"
    }

    companion object{
        private const val KEY_SCORE = "score"
    }
}