package com.example.testingtask.presentation.menuScene.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingtask.R
import com.example.testingtask.presentation.ui.theme.GrayColor
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun GameLogo(modifier: Modifier = Modifier){
    Card(
        modifier.size(200.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier
                .fillMaxSize()
                .background(color = GrayColor)
                .padding(40.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(id = R.string.menu_scene_label),
                color = Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowGameLogo() {
    TestingTaskTheme {
        GameLogo()
    }
}