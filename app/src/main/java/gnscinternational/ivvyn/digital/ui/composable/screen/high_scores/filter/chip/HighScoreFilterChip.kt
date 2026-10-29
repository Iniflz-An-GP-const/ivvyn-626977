package gnscinternational.ivvyn.digital.ui.composable.screen.high_scores.filter.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gnscinternational.ivvyn.digital.ui.composable.screen.high_scores.filter.HighScoreFilterItem
import gnscinternational.ivvyn.digital.ui.theme.LocalDimens

private val DotSize = 8.dp
private val DotBorderWidth = 1.dp

@Composable
fun HighScoreFilterChip(
    item: HighScoreFilterItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    FilterChip(
        selected = item.selected,
        onClick = onClick,
        label = { Text(item.label) },
        leadingIcon = { SelectionDot(selected = item.selected) },
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        modifier = modifier,
    )
}

@Composable
private fun SelectionDot(selected: Boolean) {
    if (selected) {
        Box(
            modifier = Modifier
                .size(DotSize)
                .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
        )
    } else {
        Box(
            modifier = Modifier
                .size(DotSize)
                .border(
                    width = DotBorderWidth,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                ),
        )
    }
}
