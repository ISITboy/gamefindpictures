package com.example.testingtask.presentation.endGameScene.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingtask.presentation.endGameScene.EndGameScreenViewModel
import com.example.testingtask.presentation.menuScene.components.FormOfGameCurrency
import com.example.testingtask.presentation.ui.theme.GrayColor
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun FormScore(modifier: Modifier = Modifier, score:String){
    Card(modifier = modifier.size(300.dp,100.dp),shape = RoundedCornerShape(15.dp),) {
        Box(
            modifier
                .fillMaxSize()
                .background(GrayColor),
            contentAlignment = Alignment.Center
        ){
            FormOfGameCurrency(count = score)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowFormScore() {
    TestingTaskTheme {
        FormScore(score="100")
    }
}