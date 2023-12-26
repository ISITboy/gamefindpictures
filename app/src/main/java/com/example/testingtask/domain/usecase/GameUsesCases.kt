package com.example.testingtask.domain.usecase

import com.example.testingtask.data.repository.GameRepositoryImpl
import com.example.testingtask.domain.models.Cell
import com.example.testingtask.domain.usecase.gameusescases.ChangeIsClickedUseCase
import com.example.testingtask.domain.usecase.gameusescases.ChangeOpenCardUseCase
import com.example.testingtask.domain.usecase.gameusescases.ClearCardsUseCase
import com.example.testingtask.domain.usecase.gameusescases.EqualsCardUseCase
import com.example.testingtask.domain.usecase.gameusescases.HideCardsUseCase
import com.example.testingtask.domain.usecase.gameusescases.PutCardsUseCase
import javax.inject.Inject

data class GameUsesCases @Inject constructor(
    private val changeIsClickedUseCase: ChangeIsClickedUseCase,
    private val changeOpenCardUseCase: ChangeOpenCardUseCase,
    private val clearCardsUseCase: ClearCardsUseCase,
    private val equalsCardUseCase: EqualsCardUseCase,
    private val hideCardsUseCase: HideCardsUseCase,
    private val putCardsUseCase: PutCardsUseCase
)