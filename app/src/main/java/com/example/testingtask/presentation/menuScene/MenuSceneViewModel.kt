package com.example.testingtask.presentation.menuScene

import androidx.lifecycle.ViewModel
import com.example.testingtask.data.repository.SharedPreferencesRepositoryImpl
import com.example.testingtask.domain.usecase.SharedPreferencesUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuSceneViewModel @Inject constructor(
    private val sharedPreferencesUsesCases: SharedPreferencesUsesCases
):ViewModel() {
    fun getScore()= sharedPreferencesUsesCases.getScoreUseCase()
}