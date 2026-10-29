package gnscinternational.ivvyn.digital.ui.composable.screen.game.card

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import gnscinternational.ivvyn.digital.data.model.CardState
import gnscinternational.ivvyn.digital.ui.composable.screen.game.card.MemoryCardBack
import gnscinternational.ivvyn.digital.ui.composable.screen.game.card.MemoryCardDefaults
import gnscinternational.ivvyn.digital.ui.composable.screen.game.card.MemoryCardFace
import gnscinternational.ivvyn.digital.ui.composable.screen.game.card.MemoryCardItem
import gnscinternational.ivvyn.digital.ui.composable.screen.shared.modifier.press.pressFeedback

private const val FADE_STEP_MS = 150

@Composable
fun MemoryCard(
    item: MemoryCardItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    AnimatedContent(
        targetState = item.state != CardState.Hidden,
        modifier = modifier
            .pressFeedback(interactionSource)
            .clip(MemoryCardDefaults.shape)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                enabled = item.state == CardState.Hidden,
                onClick = onClick,
            ),
        transitionSpec = {
            fadeIn(tween(durationMillis = FADE_STEP_MS, delayMillis = FADE_STEP_MS)) togetherWith
                    fadeOut(tween(durationMillis = FADE_STEP_MS))
        },
        label = "cardFadeThrough",
    ) { isFaceUp ->
        if (isFaceUp) {
            MemoryCardFace(symbol = item.symbol, state = item.state)
        } else {
            MemoryCardBack()
        }
    }
}
