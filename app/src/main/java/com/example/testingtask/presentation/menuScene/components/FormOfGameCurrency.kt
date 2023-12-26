package com.example.testingtask.presentation.menuScene.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingtask.R
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme

@Composable
fun FormOfGameCurrency(modifier: Modifier = Modifier,count:String){
    Row(
        modifier = modifier.width(85.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_currency), contentDescription = "currency"
        )
        Spacer(modifier.width(5.dp))
        Text(
            text = count.toString(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowFormOfGameCurrency() {
    TestingTaskTheme {
        FormOfGameCurrency(count = "10000")
    }
}