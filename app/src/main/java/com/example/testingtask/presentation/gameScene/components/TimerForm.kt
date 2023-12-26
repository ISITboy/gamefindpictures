package com.example.testingtask.presentation.gameScene.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingtask.R
import com.example.testingtask.presentation.ui.theme.GrayColor
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun TimerForm(modifier: Modifier = Modifier, timer:String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Card(
            modifier = modifier.padding(start = 45.dp),
            colors = CardDefaults.cardColors(
                containerColor = GrayColor
            ),
            shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
        ) {
            Text(
                modifier = modifier.padding(15.dp, 5.dp),
                text = timer,
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Image(
            modifier = modifier.size(60.dp),
            painter = painterResource(id = R.drawable.ic_timer),
            contentDescription = "timer"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTimerForm() {
    TestingTaskTheme {
        TimerForm(timer = "00:21")
    }
}