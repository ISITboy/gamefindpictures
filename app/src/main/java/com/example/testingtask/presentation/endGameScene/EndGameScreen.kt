package com.example.testingtask.presentation.endGameScene

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testingtask.R
import com.example.testingtask.data.BaseItem.resultedScore
import com.example.testingtask.presentation.endGameScene.componets.FormScore
import com.example.testingtask.presentation.endGameScene.componets.HomeButton
import com.example.testingtask.presentation.endGameScene.componets.NewGameButton
import com.example.testingtask.presentation.endGameScene.componets.TrophyImage
import com.example.testingtask.presentation.navGraph.Route

@Composable
fun EndGameScreen(modifier: Modifier = Modifier, onEvent: (Route) -> Unit) {
    val vm: EndGameScreenViewModel = hiltViewModel()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            contentAlignment = Alignment.BottomCenter
        ) {
            TrophyImage()
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.end_game_scene_label1),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.end_game_scene_label2),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
        FormScore(score = resultedScore.toString())
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NewGameButton() { gameScene ->
                onEvent(gameScene)
            }
            HomeButton() { menuScene ->
                onEvent(menuScene)
            }
        }
    }

}

