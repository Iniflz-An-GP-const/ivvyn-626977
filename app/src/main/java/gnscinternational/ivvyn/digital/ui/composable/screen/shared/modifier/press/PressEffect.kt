package gnscinternational.ivvyn.digital.ui.composable.screen.shared.modifier.press

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import gnscinternational.ivvyn.digital.ui.composable.screen.shared.modifier.press.rememberPressProgress

private const val PRESSED_SCALE = 0.92f

@Composable
fun Modifier.pressEffect(interactionSource: InteractionSource): Modifier {
    val progress = rememberPressProgress(interactionSource)

    return graphicsLayer {
        val scale = 1f - progress.value * (1f - PRESSED_SCALE)
        scaleX = scale
        scaleY = scale
    }
}
