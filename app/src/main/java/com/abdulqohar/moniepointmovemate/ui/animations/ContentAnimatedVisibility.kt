package com.abdulqohar.moniepointmovemate.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable

@Composable
fun ContentAnimatedVisibility(
    visibility: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight/3},
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) + fadeOut(
            targetAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
    ) {
        content()
    }
}


@Composable
fun ShipmentListAnimatedVisibility(
    visibility: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight/3 },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ),
        exit =
        slideOutVertically(
            targetOffsetY = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        ) +
                fadeOut(
                    targetAlpha = 0f,
                    animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                ),
    ) {
        content()
    }
}