package com.example.testingtask.presentation.endGameScene.componets

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingtask.R
import com.example.testingtask.presentation.navGraph.Route
import com.example.testingtask.presentation.ui.theme.PurpleColor
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun NewGameButton(modifier: Modifier = Modifier, onEvent: (Route) -> Unit) {
    Button(
        modifier = modifier.height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleColor
        ),
        onClick = {
        onEvent(Route.GameScene)
    }) {
        Text(text = stringResource(id = R.string.end_game_scene_button))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowNewGameButton() {
    TestingTaskTheme {
        NewGameButton(onEvent = {})
    }
}