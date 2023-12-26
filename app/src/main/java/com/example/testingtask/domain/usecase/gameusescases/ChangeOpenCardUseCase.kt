package com.example.testingtask.domain.usecase.gameusescases

import com.example.testingtask.data.repository.GameRepositoryImpl
import com.example.testingtask.domain.models.Cell
import javax.inject.Inject

class ChangeOpenCardUseCase @Inject constructor(
    private val gameRepositoryImpl: GameRepositoryImpl
) {
    operator fun invoke() = gameRepositoryImpl.changeOpenCards()
}