package com.example.testingtask.domain.usecase

import com.example.testingtask.data.BaseItem.ITEMS
import com.example.testingtask.data.repository.CardRepositoryImpl
import com.example.testingtask.domain.models.Cell
import javax.inject.Inject

class GenerateCard @Inject constructor(
    private val cardRepositoryImpl: CardRepositoryImpl
) {
    operator fun invoke() = cardRepositoryImpl.createCards()
}