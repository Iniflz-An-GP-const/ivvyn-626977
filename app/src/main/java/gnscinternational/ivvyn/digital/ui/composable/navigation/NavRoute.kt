package gnscinternational.ivvyn.digital.ui.composable.navigation

import gnscinternational.ivvyn.digital.data.model.Difficulty
import kotlinx.serialization.Serializable

sealed class NavRoute {
    @Serializable
    object Splash : NavRoute()

    @Serializable
    object MainMenu : NavRoute()

    @Serializable
    object About : NavRoute()

    @Serializable
    object HighScores : NavRoute()

    @Serializable
    data class Game(val difficulty: Difficulty) : NavRoute()
}