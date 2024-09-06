package com.abdulqohar.moniepointmovemate.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abdulqohar.moniepointmovemate.ui.animations.bounceClick
import com.abdulqohar.moniepointmovemate.navigation.BottomBarScreen

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Calculate,
        BottomBarScreen.Shipment,
        BottomBarScreen.Profile
    )
    NavigationBar(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(70.dp),
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.sortedBy { it.id }.forEach { item ->
            val selected = currentRoute == item.route
            val fontWeight =  if(selected) FontWeight.Bold else FontWeight.Normal
            Box(modifier = Modifier
                .weight(1f)
                .selectable(
                    selected = selected,
                    onClick = {
                        if (item.route != BottomBarScreen.Profile.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    enabled = true,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                )
                .bounceClick()
                .clickable {
                    if (item.route != BottomBarScreen.Profile.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }) {
                Column(verticalArrangement = Arrangement.Center) {
                    if (selected) {
                        Divider(color = MaterialTheme.colorScheme.primary, thickness = 4.dp)
                    } else {
                        Spacer(modifier = Modifier.size(4.dp))
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            tint = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color.Gray,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            item.title,
                            color = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color.Gray,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 14.sp,
                                color = Color.Gray,
                                fontWeight = fontWeight
                            )
                        )
                    }
                }
            }
        }
    }
}