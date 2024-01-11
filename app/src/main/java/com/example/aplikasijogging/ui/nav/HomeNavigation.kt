package com.example.aplikasijogging.ui.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.aplikasijogging.ui.screen.home.HomeScreen


fun NavGraphBuilder.homeNavigation(
    navController: NavController,
    paddingValues: PaddingValues
) {
    navigation(
        startDestination = BottomNavDestination.Home.RecentRun.route,
        route = BottomNavDestination.Home.route
    ) {
        composable(
            route = BottomNavDestination.Home.RecentRun.route
        ) {
            HomeScreen(
                navController = navController,
                bottomPadding = paddingValues.calculateBottomPadding()
            )
        }



    }
}