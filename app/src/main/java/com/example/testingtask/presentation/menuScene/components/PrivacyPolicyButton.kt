package com.example.testingtask.presentation.menuScene.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
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
fun PrivacyPolicyButton(modifier: Modifier = Modifier, onEvent: (Route) -> Unit) {
    Card(modifier = modifier.size(70.dp)) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(GrayColor)
            .clickable {
                onEvent(Route.PrivacyPolicy)
            },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier= modifier.size(45.dp),
                painter = painterResource(id = R.drawable.ic_policy),
                contentDescription = "policy"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPrivacyPolicyButton() {
    TestingTaskTheme {
        PrivacyPolicyButton() {

        }
    }
}