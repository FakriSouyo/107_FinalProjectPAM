package com.example.aplikasijogging.ui.nav

import androidx.navigation.NavController
import androidx.navigation.navDeepLink
import com.example.aplikasijogging.ui.nav.BottomNavDestination

sealed class Destination(val route: String) {

    object OnBoardingDestination : Destination("on_boarding") {
        fun navigateToHome(navController: NavController) {
            navController.navigate(BottomNavDestination.Home.route) {
                popUpTo(route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    object CurrentRun : Destination("current_run") {
        val currentRunUriPattern = "https://runtrack.sdevprem.com/$route"
        val deepLinks = listOf(
            navDeepLink {
                uriPattern = currentRunUriPattern
            }
        )
    }

    //global navigation
    companion object {
        fun navigateToCurrentRunScreen(navController: NavController) {
            navController.navigate(CurrentRun.route)
        }
    }

}
