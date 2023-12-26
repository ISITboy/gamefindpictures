package com.example.testingtask.domain.usecase.sharedpreferencesusescases

import com.example.testingtask.domain.repository.SharedPreferencesRepository
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {
    operator fun invoke() = sharedPreferencesRepository.get()
}