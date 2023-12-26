package com.example.testingtask.data.repository

import com.example.testingtask.data.BaseItem
import com.example.testingtask.domain.models.Cell
import com.example.testingtask.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor():CardRepository {

    private val items = BaseItem.ITEMS.toMutableList()

    override fun takeItem(index: Int) = items[index]

    override fun createCards(): MutableList<Cell> {
        val cards = mutableListOf<Cell>()
        repeat(20){index->
            val item = takeItem(index)
            cards.add(Cell(
                image = item.image,
                value = item.value
            ))
        }
        return cards.shuffled().toMutableList()
    }

}