package com.example.testingtask.domain.usecase.sharedpreferencesusescases

import com.example.testingtask.domain.repository.SharedPreferencesRepository
import javax.inject.Inject

class SaveScoreUseCase @Inject constructor(
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {
    operator fun invoke(score:Int) = sharedPreferencesRepository.save(score=score.toString())
}