package com.abdulqohar.moniepointmovemate.ui.components.calculate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitledAppBar(
    title: String,
    animateTopBar: Boolean,
    onBackClick: ()-> Unit
) {

    CenterAlignedTopAppBar(
        title = {
            AnimatedVisibility(
                visible = animateTopBar,
                enter = slideInVertically(
                    initialOffsetY = { h -> h },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeIn(
                    tween(1000),
                ),
                exit = slideOutVertically(tween(durationMillis = 1000)) + fadeOut(tween(1000))
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }, navigationIcon = {
            AnimatedVisibility(
                visible = animateTopBar,
                enter = slideInHorizontally(
                    initialOffsetX = { w -> -w },
                    animationSpec = tween(durationMillis = 1000)
                ) + fadeIn(
                    tween(1000),
                ),
                exit = slideOutHorizontally(tween(durationMillis = 1000)) + fadeOut(tween(1000))
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        Icons.Rounded.KeyboardArrowLeft,
                        contentDescription = "Go home"
                    )
                }
            }

        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        )
    )
}

@Composable
@Preview
fun TitledAppBarPreview() {
    TitledAppBar(title = "HomeScreen", animateTopBar = true, ) {

    }
}