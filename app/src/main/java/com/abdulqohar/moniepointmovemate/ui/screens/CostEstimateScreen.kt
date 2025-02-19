package com.abdulqohar.moniepointmovemate.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abdulqohar.moniepointmovemate.R
import com.abdulqohar.moniepointmovemate.ui.components.common.ActionButton
import com.abdulqohar.moniepointmovemate.ui.theme.poppins
import com.abdulqohar.moniepointmovemate.ui.theme.tangerine
import kotlinx.coroutines.delay

@Composable
fun CostEstimateScreen(navController: NavHostController) {
    var cost by remember { mutableIntStateOf(0) }
    var isContentVisible by remember { mutableStateOf(false) }
    var scaleBox by remember { mutableStateOf(false) }
    val animatedCost by animateIntAsState(
        targetValue = cost,
        label = "cost",
        animationSpec = tween(durationMillis = 2500)
    )
    val boxScale by animateFloatAsState(
        targetValue = if(scaleBox) 1.7f else 0f,
        label = "boxScale",
        animationSpec = tween(200, easing = LinearOutSlowInEasing)
    )
    LaunchedEffect("cost") {
        isContentVisible = true
        cost = 1423
        delay(300)
        scaleBox = true
    }


    AnimatedVisibility(
        visible = isContentVisible, enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 200, easing = LinearOutSlowInEasing)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 200, easing = LinearOutSlowInEasing)
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "MoveMate",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = poppins
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.fastcar),
                    modifier = Modifier.size(36.dp),
                    tint = tangerine,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.size(40.dp))
            Image(
                painter = painterResource(id = R.drawable.box),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .width(100.dp)
                    .scale(boxScale)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Total Estimated Amount",
                fontWeight = FontWeight.W400,
                fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 20.dp),
            )

            Spacer(modifier = Modifier.size(12.dp))
            Text(text = "$$animatedCost USD", fontSize = 30.sp, color = Color.Green)
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "This amount is estimated this will vary if you change your location or weight",
                fontSize = 14.sp, color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 50.dp),
                fontFamily = poppins,

                )
            Spacer(modifier = Modifier.size(24.dp))
            ActionButton("Back to home") {
                navController.navigate(com.abdulqohar.moniepointmovemate.navigation.BottomBarScreen.Home.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
    }
}