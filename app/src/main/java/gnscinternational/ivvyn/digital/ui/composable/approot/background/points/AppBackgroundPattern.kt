package gnscinternational.ivvyn.digital.ui.composable.approot.background.points

import androidx.compose.ui.unit.dp
import gnscinternational.ivvyn.digital.ui.composable.approot.background.BackgroundPattern
import gnscinternational.ivvyn.digital.ui.composable.approot.background.gridAnchors

/** Rows of five and four icons alternate, every second row shifted by half a cell, like bricks. */
val AppBackgroundPattern = BackgroundPattern(
    anchors = gridAnchors(columns = 5, rows = 9, staggered = true),
    iconSize = 28.dp,
)
