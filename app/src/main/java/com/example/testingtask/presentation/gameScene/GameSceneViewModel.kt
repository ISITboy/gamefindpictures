package com.example.testingtask.presentation.gameScene

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingtask.data.BaseItem.resultedScore
import com.example.testingtask.data.repository.GameRepositoryImpl
import com.example.testingtask.data.repository.SharedPreferencesRepositoryImpl
import com.example.testingtask.domain.Utils.calculateScore
import com.example.testingtask.domain.models.Cell
import com.example.testingtask.domain.usecase.GenerateCard
import com.example.testingtask.domain.usecase.SharedPreferencesUsesCases
import com.example.testingtask.domain.usecase.TimerUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class GameSceneViewModel @Inject constructor(
    private val generateCard: GenerateCard,
    private val gameRepositoryProvider: Provider<GameRepositoryImpl>,
    private val sharedPreferencesUsesCases: SharedPreferencesUsesCases,
    private val timerUsesCases: TimerUsesCases
) : ViewModel() {

    private var _rows = 5
    val rows: Int
        get() = _rows

    private var _columns = 4
    val columns: Int
        get() = _columns

    val getElapsedTime: StateFlow<Long> = timerUsesCases.getTime()
    fun startTimer() = viewModelScope.launch {
        timerUsesCases.startTimer(coroutineScope = viewModelScope)
    }

    val finished :MutableState<Boolean> = mutableStateOf(false)

    private fun stopTimer() {
        timerUsesCases.stopTimer()
        resultedScore = getResultedScore()
        saveScore(getResultScore(getScore().toInt(),getResultedScore()))
        finished.value=true
    }
    fun getResultedScore()=calculateScore(getElapsedTime.value)
    fun formatTime(milliseconds: Long) = timerUsesCases.formatTimer(milliseconds)


    fun getCurrentCardIndex(row: Int, column: Int) = row * _columns + column
    fun generateCard() = generateCard.invoke()

    fun cardOperation(cells: MutableList<Cell>) {
        val gameRepositoryImpl = gameRepositoryProvider.get()
        if (gameRepositoryImpl.putCards(cells = cells)) {
            viewModelScope.launch {
                when (gameRepositoryImpl.equalsCard()) {
                    true -> {
                        delay(1000)
                        eventsWhenCardsEquals(gameRepositoryImpl)
                    }
                    false -> {
                        delay(1000)
                        eventsWhenCardsNotEquals(gameRepositoryImpl)
                    }
                }
            }
        }
    }

    private var _searchedPair : MutableState<Int> = mutableStateOf(0)

    private fun eventsWhenCardsEquals(gameRepositoryImpl: GameRepositoryImpl) {
        gameRepositoryImpl.hideCards()
        gameRepositoryImpl.changeOpenCards()
        gameRepositoryImpl.clearCards()
        addSearchedAndCheckPair()
    }

    private fun eventsWhenCardsNotEquals(gameRepositoryImpl: GameRepositoryImpl) {
        gameRepositoryImpl.changeIsClicked()
        gameRepositoryImpl.changeOpenCards()
        gameRepositoryImpl.clearCards()
    }

    private fun addSearchedAndCheckPair() {
        _searchedPair.value++
        if(_searchedPair.value==10) stopTimer()
    }

    private fun saveScore(score:Int) = sharedPreferencesUsesCases.saveScoreUseCase(score = score)
    fun getScore() = sharedPreferencesUsesCases.getScoreUseCase()

    private fun getResultScore(score:Int,currentScore:Int)= score+currentScore
}