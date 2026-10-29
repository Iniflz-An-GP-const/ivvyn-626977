package gnscinternational.ivvyn.digital.ui.composable.screen.difficulty

import gnscinternational.ivvyn.digital.R
import gnscinternational.ivvyn.digital.data.model.Difficulty

fun Difficulty.titleRes(): Int = when (this) {
    Difficulty.Easy -> R.string.difficulty_easy
    Difficulty.Medium -> R.string.difficulty_medium
    Difficulty.Hard -> R.string.difficulty_hard
}
