package com.abdulqohar.moniepointmovemate.navigation

import com.abdulqohar.moniepointmovemate.R

sealed class NavDestinations(
    val id: Int,
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home : NavDestinations(
        id = 0,
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    data object Calculate : NavDestinations(
        id = 1,
        route = "calculate",
        title = "Calculate",
        icon = R.drawable.ic_calculate
    )

    data object Shipment : NavDestinations(
        id = 2,
        route = "shipment",
        title = "Shipment",
        icon = R.drawable.ic_shipment
    )

    data object CostEstimate : NavDestinations(
        id = 3,
        route = "costEstimate",
        title = "Cost Estimate",
        icon = R.drawable.ic_calculate
    )

    data object Search : NavDestinations(
        id = 4,
        route = "search",
        title = "Search",
        icon = R.drawable.ic_home
    )
    data object Profile: BottomBarScreen(
        id = 5,
        route = "profile",
        title = "profile",
        icon = R.drawable.person_icon
    )
}