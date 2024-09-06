package com.abdulqohar.moniepointmovemate.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdulqohar.moniepointmovemate.navigation.BottomNavGraph
import com.abdulqohar.moniepointmovemate.ui.animations.BottomBarAnimatedVisibility
import com.abdulqohar.moniepointmovemate.ui.components.BottomNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppContainerScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute= navBackStackEntry?.destination?.route
    var showBottomBar by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomBarAnimatedVisibility(visibility = showBottomBar) {
                BottomNav(navController = navController)
            }
        }
    ) {
        BottomNavGraph(navController = navController) {
            showBottomBar = it
        }
    }
}