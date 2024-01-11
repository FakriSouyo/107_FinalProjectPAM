package com.example.aplikasijogging.ui.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplikasijogging.ui.screen.currentrun.CurrentRunScreen
import com.example.aplikasijogging.ui.screen.onboard.OnBoardScreen
import com.example.aplikasijogging.ui.screen.profile.ProfileScreen


@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues()
) {
    SetupNavGraph(
        navController = navController,
        paddingValues = paddingValues
    )
}

@Composable
private fun SetupNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues()
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavDestination.Home.route
    ) {
        homeNavigation(navController, paddingValues)

        composable(
            route = BottomNavDestination.Profile.route
        ) {
            ProfileScreen(paddingValues.calculateBottomPadding())
        }

        composable(
            route = Destination.CurrentRun.route,
            deepLinks = Destination.CurrentRun.deepLinks
        ) {
            CurrentRunScreen(navController)
        }

        composable(
            route = Destination.OnBoardingDestination.route
        ) {
            OnBoardScreen(navController = navController)
        }
    }

}

