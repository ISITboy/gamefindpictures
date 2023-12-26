package com.example.testingtask.data.repository

import com.example.testingtask.domain.models.Cell
import com.example.testingtask.domain.repository.GameRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GameRepositoryImpl @Inject constructor():GameRepository {
    private val selectedCards = mutableListOf<Cell>()

    override fun putCards(cells: MutableList<Cell>) = selectedCards.addAll(cells)


    override fun clearCards(){
        selectedCards.clear()
    }
    override fun hideCards(){
        selectedCards.forEach {
            it.alpha.value = 0.0f
            it.isClicked.value = false
        }
    }
    override fun changeOpenCards(){
        selectedCards.forEach {
            it.open.value = false
        }
    }
    override fun changeIsClicked(){
        selectedCards.forEach {
            it.isClicked.value = true
        }
    }
    override fun equalsCard()  = selectedCards.first().value == selectedCards.last().value

}