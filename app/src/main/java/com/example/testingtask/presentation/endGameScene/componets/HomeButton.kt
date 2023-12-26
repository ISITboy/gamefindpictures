package com.example.testingtask.presentation.endGameScene.componets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingtask.R
import com.example.testingtask.presentation.navGraph.Route
import com.example.testingtask.presentation.ui.theme.GrayColor
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun HomeButton(modifier: Modifier = Modifier, onEvent: (Route) -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .size(60.dp).clickable {
                onEvent(Route.MenuScene)
            }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(GrayColor),
            contentAlignment = Alignment.Center
        ) {
            Image(modifier = modifier.size(50.dp),painter = painterResource(id = R.drawable.ic_home), contentDescription = "home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeButton() {
    TestingTaskTheme {
        HomeButton(onEvent = {})
    }
}