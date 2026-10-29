package gnscinternational.ivvyn.digital.ui.composable.screen.main_menu.content.block.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gnscinternational.ivvyn.digital.ui.composable.screen.main_menu.content.block.MenuBlockDefaults
import gnscinternational.ivvyn.digital.ui.composable.screen.main_menu.content.block.MenuBlockItem
import gnscinternational.ivvyn.digital.ui.theme.LocalDimens

private val BadgeSize = 48.dp
private const val BadgeFillAlpha = 0.14f

@Composable
fun MenuBlockContent(
    item: MenuBlockItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val contentColor = LocalContentColor.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.itemSpacing, Alignment.CenterVertically),
    ) {
        Box(
            modifier = Modifier
                .size(BadgeSize)
                .background(color = contentColor.copy(alpha = BadgeFillAlpha), shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                modifier = Modifier.size(MenuBlockDefaults.IconSize),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
            )
            item.subtitle?.let { subtitle ->
                Text(
                    text = subtitle,
                    color = contentColor.copy(alpha = MenuBlockDefaults.SecondaryAlpha),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
