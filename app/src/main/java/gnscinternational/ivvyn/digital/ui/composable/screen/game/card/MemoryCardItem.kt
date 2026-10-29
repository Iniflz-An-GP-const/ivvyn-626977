package gnscinternational.ivvyn.digital.ui.composable.screen.game.card

import androidx.compose.ui.graphics.vector.ImageVector
import gnscinternational.ivvyn.digital.data.model.CardState

data class MemoryCardItem(
    val symbol: ImageVector,
    val state: CardState,
)
