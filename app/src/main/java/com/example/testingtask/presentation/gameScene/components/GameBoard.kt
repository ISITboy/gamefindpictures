package com.example.testingtask.presentation.gameScene.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingtask.domain.models.Cell
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme
import androidx.compose.material3.Card
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testingtask.R
import com.example.testingtask.presentation.gameScene.GameSceneViewModel
import com.example.testingtask.presentation.ui.theme.GrayColor
import kotlinx.coroutines.delay


@Composable
fun FindPairsGame(modifier: Modifier = Modifier, vm: GameSceneViewModel) {
    val generatedCards = vm.generateCard()

    val consideredCards = remember {
        mutableStateListOf<Cell>()
    }
    val cards = remember { generatedCards }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in 0 until vm.rows) {
            Row {
                for (column in 0 until vm.columns) {
                    val indexCurrentCard = vm.getCurrentCardIndex(row, column)
                    val card = cards[indexCurrentCard]
                    CellCard(
                        isClicked = card.isClicked,
                        alpha = card.alpha,
                        image = card.image,
                        open = card.open,
                        onClick = {
                            consideredCards.add(cards[indexCurrentCard])
                            onCardClicked(cards[indexCurrentCard], consideredCards, vm)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun CellCard(
    isClicked: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    alpha: MutableState<Float>,
    image: Int,
    open: MutableState<Boolean>,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable(enabled = isClicked.value) {
                onClick()
            }
            .size(80.dp)
            .alpha(alpha.value),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(GrayColor),
            contentAlignment = Alignment.Center
        ) {
            if (open.value) {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = image),
                    contentDescription = "img"
                )
            } else {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search"
                )
            }
        }
    }
}

fun onCardClicked(currentCard: Cell, consideredCards: MutableList<Cell>, vm: GameSceneViewModel) {
    currentCard.open.value = !currentCard.open.value
    currentCard.isClicked.value = false
    if (consideredCards.size == 2) {
        val copyOfConsideredCards = consideredCards.toMutableList()
        vm.cardOperation(copyOfConsideredCards)
        consideredCards.clear()
    }
}


@Preview(showBackground = true)
@Composable
fun ShowGameBoard() {
    val vm: GameSceneViewModel = hiltViewModel()
    TestingTaskTheme {
        FindPairsGame(vm = vm)
    }
}