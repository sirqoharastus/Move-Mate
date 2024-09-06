package com.abdulqohar.moniepointmovemate.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdulqohar.moniepointmovemate.ui.screens.CalculateScreen
import com.abdulqohar.moniepointmovemate.ui.screens.CostEstimateScreen
import com.abdulqohar.moniepointmovemate.ui.screens.HomeScreen
import com.abdulqohar.moniepointmovemate.ui.screens.SearchScreen
import com.abdulqohar.moniepointmovemate.ui.screens.ShipmentScreen

@Composable
fun BottomNavGraph(navController: NavHostController, showBottomBar: (state: Boolean) -> Unit){
    NavHost(
        navController = navController,
        startDestination = NavDestinations.Home.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None }
    ) {
        composable(route = NavDestinations.Home.route) {
            HomeScreen(navController = navController)
            showBottomBar(true)
        }

        composable(route = NavDestinations.Search.route) {
            SearchScreen(navController = navController, onBack = { showBottomBar(true) })
            showBottomBar(false)
        }

        composable(route = NavDestinations.Calculate.route) {
            CalculateScreen(navController = navController, onBackClick = { showBottomBar(true) })
            showBottomBar(false)
        }

        composable(route = NavDestinations.Shipment.route) {
            ShipmentScreen(navController = navController)
            showBottomBar(false)
        }

        composable(route = NavDestinations.CostEstimate.route) {
            CostEstimateScreen(navController = navController)
            showBottomBar(false)
        }
    }
}