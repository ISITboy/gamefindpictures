package com.example.testingtask.domain.usecase.gameusescases

import com.example.testingtask.data.repository.CardRepositoryImpl
import com.example.testingtask.data.repository.GameRepositoryImpl
import com.example.testingtask.domain.models.Cell
import javax.inject.Inject

class PutCardsUseCase @Inject constructor(
    private val gameRepositoryImpl: GameRepositoryImpl
) {
    operator fun invoke(cells: MutableList<Cell>) = gameRepositoryImpl.putCards(cells=cells)
}