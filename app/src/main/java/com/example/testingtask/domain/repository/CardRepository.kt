package com.example.testingtask.domain.repository

import com.example.testingtask.domain.models.Cell
import com.example.testingtask.domain.models.Item

interface CardRepository {
    fun takeItem(index : Int): Item
    fun createCards(): MutableList<Cell>
}