package com.example.testingtask.presentation.navGraph

sealed class Route(val route:String){
    object MenuScene :Route(route = "menuScene")
    object PrivacyPolicy :Route(route = "privacyPolicy")
    object GameScene :Route(route = "gameScene")
    object EndGameScene :Route(route = "endGameScene/{score}")
}
