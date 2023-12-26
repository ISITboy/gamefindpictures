package com.example.testingtask.domain.repository

import com.example.testingtask.domain.models.Cell

interface GameRepository {

    fun equalsCard(): Boolean
    fun putCards(cells: MutableList<Cell>): Boolean
    fun clearCards()
    fun hideCards()
    fun changeOpenCards()
    fun changeIsClicked()
}