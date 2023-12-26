package com.example.testingtask.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testingtask.presentation.endGameScene.EndGameScreen
import com.example.testingtask.presentation.gameScene.GameSceneScreen
import com.example.testingtask.presentation.menuScene.MenuSceneScreen
import com.example.testingtask.presentation.menuScene.components.PlayButton
import com.example.testingtask.presentation.navGraph.Route
import com.example.testingtask.presentation.privacyPolicy.PrivacyPolicyScreen
import com.example.testingtask.presentation.ui.theme.TestingTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            TestingTaskTheme {
                NavHost(
                    navController = navController,
                    startDestination = Route.MenuScene.route,
                ) {
                    composable(route = Route.MenuScene.route) {
                        MenuSceneScreen { route ->
                            navController.navigate(route.route)
                        }
                    }
                    composable(route = Route.PrivacyPolicy.route) {
                        PrivacyPolicyScreen()
                    }
                    composable(route = Route.GameScene.route) {
                        GameSceneScreen() { route ->
                            stackProcessing(navController, route = route.route)
                        }
                    }
                    composable(route = Route.EndGameScene.route) {
                        EndGameScreen { route ->
                            when (route) {
                                Route.GameScene -> stackProcessing(
                                    navController,
                                    route = route.route
                                )

                                else -> stackProcessing(
                                    navController,
                                    route = route.route,
                                    _inclusive = true
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


private fun stackProcessing(
    navController: NavHostController,
    route: String,
    _inclusive: Boolean = false
) {
    navController.navigate(route) {
        popUpTo(Route.MenuScene.route) {
            inclusive = _inclusive
        }
    }
}
