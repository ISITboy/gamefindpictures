package com.example.testingtask.presentation.endGameScene.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingtask.R
import com.example.testingtask.presentation.menuScene.components.FormOfGameCurrency
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun TrophyImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier.size(150.dp),
            painter = painterResource(id = R.drawable.ic_trophy),
            contentDescription = "trophy"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTrophyImage() {
    TestingTaskTheme {
        TrophyImage()
    }
}