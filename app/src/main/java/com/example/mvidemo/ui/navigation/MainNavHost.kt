package com.example.mvidemo.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvidemo.ui.common.LocalActivity
import com.example.mvidemo.ui.screen.DetailScreen
import com.example.mvidemo.ui.screen.main.MainScreen
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navViewModel: TopNavigationBarViewModel
) {
    val activity = LocalActivity.current
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Main.route,
    ) {
        composable(Destination.Main.route) {
            navViewModel.collectSideEffect {
                navController.navigateSideEffect(it) {
                    onBack { activity.finish() }
                    onNext { navigate(Destination.Detail.route) }
                }
            }

            MainScreen(modifier = Modifier.fillMaxSize())
        }
        composable(Destination.Detail.route) {
            navViewModel.collectSideEffect {
                navController.navigateSideEffect(it) {
                    onBack { popBackStack() }
                    onNext { navigate(Destination.Main.route) }
                }
            }

            DetailScreen(modifier = Modifier.fillMaxSize())
        }
    }
}
