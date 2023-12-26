package com.example.testingtask.domain.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Cell(
    val image : Int,
    var open: MutableState<Boolean> = mutableStateOf(false),
    val value : String,
    var alpha: MutableState<Float> = mutableStateOf(1.0f),
    var isClicked :MutableState<Boolean> = mutableStateOf(true)
)
