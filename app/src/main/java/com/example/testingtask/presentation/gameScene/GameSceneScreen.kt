package com.example.testingtask.presentation.gameScene

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testingtask.presentation.gameScene.components.FindPairsGame
import com.example.testingtask.presentation.gameScene.components.TimerForm
import com.example.testingtask.presentation.menuScene.components.FormOfGameCurrency
import com.example.testingtask.presentation.navGraph.Route
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme
import java.util.Random

@Composable
fun GameSceneScreen(modifier: Modifier = Modifier, onEvent:(Route)->Unit){
    val vm : GameSceneViewModel = hiltViewModel()
    var elapsedTime by remember { mutableStateOf(0L) }


    LaunchedEffect(Unit) {
        vm.startTimer()
        vm.getElapsedTime.collect { time ->
            Log.d("MyLog","elapsedTime = $elapsedTime")
            elapsedTime = time
        }
    }


    Column(modifier= modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp, 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimerForm(timer = vm.formatTime(elapsedTime))
            FormOfGameCurrency(count = vm.getScore())
        }

        FindPairsGame(vm=vm)
    }


    val finished by vm.finished
    var prevFinished by remember { mutableStateOf(finished) }

    LaunchedEffect(finished) {
        if (prevFinished != finished && finished) {
            onEvent(Route.EndGameScene)
        }
        prevFinished = finished
    }

}


@Preview(showBackground = true)
@Composable
fun ShowGameSceneScreen() {
    TestingTaskTheme {
        GameSceneScreen(){

        }
    }
}