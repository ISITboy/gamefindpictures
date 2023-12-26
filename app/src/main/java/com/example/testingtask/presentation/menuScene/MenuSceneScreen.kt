package com.example.testingtask.presentation.menuScene

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testingtask.presentation.menuScene.components.FormOfGameCurrency
import com.example.testingtask.presentation.menuScene.components.GameLogo
import com.example.testingtask.presentation.menuScene.components.PlayButton
import com.example.testingtask.presentation.menuScene.components.PrivacyPolicyButton
import com.example.testingtask.presentation.navGraph.Route
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun MenuSceneScreen(modifier: Modifier = Modifier, onEvent: (Route) -> Unit) {
    val vm : MenuSceneViewModel = hiltViewModel()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
            FormOfGameCurrency(count = vm.getScore())
        }
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GameLogo()
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PlayButton() {
                onEvent(it)
            }
        }
        Row(
            modifier = modifier.fillMaxWidth().padding(end = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
            PrivacyPolicyButton() {
                onEvent(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMenuSceneScreen() {
    TestingTaskTheme {

    }
}
