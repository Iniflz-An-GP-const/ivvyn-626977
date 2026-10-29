package gnscinternational.ivvyn.digital.ui.composable.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import gnscinternational.ivvyn.digital.ui.composable.screen.about.GENNLAboutScreen
import gnscinternational.ivvyn.digital.ui.composable.screen.game.GENNLGameScreen
import gnscinternational.ivvyn.digital.ui.composable.screen.high_scores.GENNLHighScoresScreen
import gnscinternational.ivvyn.digital.ui.composable.screen.main_menu.GENNLMainMenuScreen
import gnscinternational.ivvyn.digital.ui.composable.screen.splash.GENNLSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val activity = LocalActivity.current

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            GENNLSplashScreen(
                onMainMenuScreenNavigation = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.MainMenu> {
            GENNLMainMenuScreen(
                onPlayClick = { difficulty ->
                    navController.navigate(
                        route = NavRoute.Game(
                            difficulty
                        )
                    )
                },
                onHighScoresScreenNavigation = { navController.navigate(route = NavRoute.HighScores) },
                onAboutScreenNavigation = { navController.navigate(route = NavRoute.About) },
                onExit = { activity?.finishAffinity() }
            )
        }

        composable<NavRoute.Game> { backStackEntry ->
            val route = backStackEntry.toRoute<NavRoute.Game>()
            GENNLGameScreen(
                difficulty = route.difficulty,
                onMainMenu = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(NavRoute.MainMenu) {
                            inclusive = true
                        }
                    }
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavRoute.About> {
            GENNLAboutScreen(onBackClick = { navController.popBackStack() })
        }

        composable<NavRoute.HighScores> {
            GENNLHighScoresScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
