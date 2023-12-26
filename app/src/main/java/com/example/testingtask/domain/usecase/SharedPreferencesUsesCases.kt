package com.example.testingtask.domain.usecase

import com.example.testingtask.domain.usecase.sharedpreferencesusescases.GetScoreUseCase
import com.example.testingtask.domain.usecase.sharedpreferencesusescases.SaveScoreUseCase
import javax.inject.Inject

data class SharedPreferencesUsesCases @Inject constructor(
    val getScoreUseCase: GetScoreUseCase,
    val saveScoreUseCase: SaveScoreUseCase
)