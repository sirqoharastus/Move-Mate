package com.abdulqohar.moniepointmovemate.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abdulqohar.moniepointmovemate.ui.animations.ContentAnimatedVisibility
import com.abdulqohar.moniepointmovemate.ui.animations.ShipmentListAnimatedVisibility
import com.abdulqohar.moniepointmovemate.ui.components.calculate.TitledAppBar
import com.abdulqohar.moniepointmovemate.ui.components.shipments.CustomTabRow
import com.abdulqohar.moniepointmovemate.ui.components.shipments.ShipmentStatusItem
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatusLabel
import com.abdulqohar.moniepointmovemate.ui.theme.indigo
import com.abdulqohar.moniepointmovemate.ui.viewmodel.ShipmentViewModel
import kotlinx.coroutines.delay

@Composable
fun ShipmentScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ShipmentViewModel = viewModel()
) {
    var animateTopBar by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TitledAppBar(
                title = "Shipment history",
                onBackClick = { navController.popBackStack() },
                animateTopBar = animateTopBar
            )
        }
    ) { paddingValues ->
        ShipmentList(paddingValues, viewModel)
    }

    LaunchedEffect(key1 = "") {
        animateTopBar = true
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentList(
    paddingValues: PaddingValues,
    viewModel: ShipmentViewModel,
) {

    var isContentVisible by remember { mutableStateOf(false) }
    var isCustomRowVisible by remember { mutableStateOf(false) }
    var isWholeContentVisible by remember { mutableStateOf(false) }
    val tabBarYOffset: Dp by animateDpAsState(
        targetValue = if (isWholeContentVisible) 0.dp else (-30).dp,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing), label = "tabBarYOffset"
    )
    val topBarBgHeight: Dp by animateDpAsState(
        targetValue = if (isWholeContentVisible) 36.dp else 100.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "topBarBgHeight"
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { ShipmentStatusLabel.entries.size }
    )

    val selectedId = remember {
        mutableIntStateOf(0)
    }

    var isTransitioning by remember { mutableStateOf(true) }

    LaunchedEffect("") {
//        isContentVisible = true
        isCustomRowVisible = true
        isWholeContentVisible = true
    }

    LaunchedEffect(key1 = selectedId.intValue ) {
        isContentVisible = false
        delay(100)
        isContentVisible = true
    }

    Column(
        Modifier.padding(
            bottom = paddingValues.calculateBottomPadding(),
            top = paddingValues.calculateTopPadding()
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .height(topBarBgHeight)
        ) {
            Row() {
                AnimatedVisibility(
                    visible = isCustomRowVisible,
                    enter = slideInHorizontally(
                        initialOffsetX = { w -> w },
                        animationSpec = tween(durationMillis = 1000)
                    ) + fadeIn(
                        tween(1000),
                    ),
                    exit = slideOutHorizontally(tween(durationMillis = 1000)) + fadeOut(tween(1000))
                ) {
                    CustomTabRow(selectedId, modifier = Modifier
                        .offset(y = tabBarYOffset)
                    )
                }
            }
        }

        ContentAnimatedVisibility(visibility = isWholeContentVisible) {
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Start)
            ) {
                LazyColumn(modifier = Modifier.padding(top = 16.dp)) {


                    item {
                        Text(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            text = "Shipments",
                            fontSize = 24.sp,
                            color = indigo,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.size(5.dp))
                    }
                    val shipmentLists = viewModel.getUpdatedStatusLabelList(selectedId.intValue)
                    items(shipmentLists) { item ->
//                        val padding by animateDpAsState(
//                            targetValue = if (isTransitioning) 16.dp else 8.dp,
//                            animationSpec = tween(
//                                durationMillis = 300,
//                                delayMillis = shipmentLists.indexOf(item) * 100 // Delay each item to animate sequentially
//                            )
//                        )

                        ShipmentListAnimatedVisibility(visibility = isContentVisible) {
                            ShipmentStatusItem(item)
                        }
                    }
                }
            }
        }
    }
}