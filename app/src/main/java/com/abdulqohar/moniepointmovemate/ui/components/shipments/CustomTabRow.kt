package com.abdulqohar.moniepointmovemate.ui.components.shipments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulqohar.moniepointmovemate.ui.animations.bounceClick
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatusLabel
import com.abdulqohar.moniepointmovemate.ui.theme.orange
import com.abdulqohar.moniepointmovemate.ui.theme.poppins
import com.abdulqohar.moniepointmovemate.ui.theme.tangerine
import com.abdulqohar.moniepointmovemate.util.listOfShipmentStatus

@Composable
fun CustomTabRow(selectedId: MutableIntState, modifier: Modifier = Modifier) {
    ScrollableTabRow(
        modifier = modifier,
        selectedTabIndex = selectedId.intValue,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        edgePadding = 12.dp,
        divider = {},
        indicator = { tabPositions ->
            if (selectedId.intValue < tabPositions.size) {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedId.intValue]),
                    color = orange.copy(alpha = 0.6f)
                )
            }
        }
    ) {
        ShipmentStatusLabel.entries.forEach { status ->
            val isSelected = selectedId.intValue == status.id
            val count =
                if (status == ShipmentStatusLabel.ALL) listOfShipmentStatus.size else listOfShipmentStatus.count { it.status == status }
            Tab(
                selected = isSelected,
                onClick = { selectedId.intValue = status.id },
                modifier = Modifier.bounceClick()
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = status.title,
                        color = if (isSelected) Color.White else Color.White.copy(0.6f),
                        modifier = Modifier.padding(end = 8.dp),
                        fontFamily = poppins,
                        fontSize = 18.sp
                    )
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = if (isSelected) tangerine else Color.White.copy(
                                    0.3f
                                )
                            )
                    ) {
                        Text(
                            text = "$count",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = if (isSelected) Color.White else Color.White.copy(
                                0.4f
                            )
                        )
                    }

                }
            }
        }
    }
}