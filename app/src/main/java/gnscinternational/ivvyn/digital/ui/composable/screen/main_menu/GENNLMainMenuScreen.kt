package gnscinternational.ivvyn.digital.ui.composable.screen.main_menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import gnscinternational.ivvyn.digital.data.model.Difficulty
import gnscinternational.ivvyn.digital.ui.composable.screen.main_menu.content.MainMenuContent
import gnscinternational.ivvyn.digital.ui.viewmodel.MenuViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GENNLMainMenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = koinViewModel(),
    onPlayClick: (Difficulty) -> Unit,
    onHighScoresScreenNavigation: () -> Unit,
    onAboutScreenNavigation: () -> Unit,
    onExit: () -> Unit,
) {
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()
    val bestScores by viewModel.bestScores.collectAsState()

    MainMenuContent(
        modifier = modifier,
        selectedDifficulty = selectedDifficulty,
        bestScores = bestScores,
        onDifficultySelected = viewModel::selectDifficulty,
        onPlayClick = { onPlayClick(selectedDifficulty) },
        onHighScoresScreenNavigation = onHighScoresScreenNavigation,
        onAboutScreenNavigation = onAboutScreenNavigation,
        onExit = onExit,
    )
}
