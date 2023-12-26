package com.example.testingtask.presentation.menuScene.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
fun PlayButton(modifier: Modifier=Modifier,onEvent: (Route) -> Unit) {
    Button(
        modifier = modifier.width(120.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleColor
        ),
        onClick = {
        onEvent(Route.GameScene)
    }) {
        Text(text = stringResource(id = R.string.menu_scene_button_label))
    }
}
@Preview(showBackground = true)
@Composable
fun ShowPlayButton() {
    TestingTaskTheme {
        PlayButton(){

        }
    }
}