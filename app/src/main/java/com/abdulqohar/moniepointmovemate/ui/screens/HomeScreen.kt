package com.abdulqohar.moniepointmovemate.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.abdulqohar.moniepointmovemate.navigation.BottomBarScreen
import com.abdulqohar.moniepointmovemate.ui.animations.AppBarAnimatedVisibility
import com.abdulqohar.moniepointmovemate.ui.animations.ContentAnimatedVisibility
import com.abdulqohar.moniepointmovemate.ui.components.home.AvailableVehiclesSection
import com.abdulqohar.moniepointmovemate.ui.components.home.TopSection
import com.abdulqohar.moniepointmovemate.ui.components.home.TrackingSection
import com.abdulqohar.moniepointmovemate.ui.components.home.vehiclesList
import com.abdulqohar.moniepointmovemate.ui.theme.Snow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier = modifier
            .background(color = Snow)
            .fillMaxSize()
    ) {
        var isContentVisible by remember { mutableStateOf(false) }
        var isAppBarVisible by remember { mutableStateOf(false) }
        var isListVisible by remember { mutableStateOf(false) }
        fun loadContent() {
            isContentVisible = !isContentVisible
        }
        fun loadAppBar() {
            isAppBarVisible = !isAppBarVisible
        }

        var containerState by remember { mutableStateOf(ContainerState.HOME) }
        AnimatedContent(
            modifier = Modifier,
            targetState = containerState,
            label = "container transform",
        ) { state ->
            when (state) {
                ContainerState.HOME -> AppBarAnimatedVisibility(visibility = isAppBarVisible) {
                    TopSection(
                        onSearchClick = {
                            containerState = ContainerState.HOME
                            navController.navigate(BottomBarScreen.Search.route)
                        }
                    )
                }

                ContainerState.SEARCH -> SearchScreen(
                    navController = navController,
                    onBack = {
                        containerState = ContainerState.SEARCH
                    }
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            ContentAnimatedVisibility(visibility = isContentVisible) {
                Column {
                    TrackingSection(modifier = Modifier.padding(horizontal = 20.dp))
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            AvailableVehiclesSection(
                vehicles = vehiclesList,
                isListVisible = isListVisible,
                isAvailableVehiclesVisible = isContentVisible
            )

            LaunchedEffect("") {
                loadAppBar()
                loadContent()
                isListVisible = true
            }
        }

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    Surface {
        HomeScreen( navController = NavHostController(LocalContext.current))
    }
}

enum class ContainerState {
    HOME, SEARCH
}
