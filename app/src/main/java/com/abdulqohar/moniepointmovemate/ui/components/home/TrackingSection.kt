package com.abdulqohar.moniepointmovemate.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulqohar.moniepointmovemate.R
import com.abdulqohar.moniepointmovemate.ui.theme.grey
import com.abdulqohar.moniepointmovemate.ui.theme.orange

@Composable
fun TrackingSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Tracking", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Surface (
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 5.dp
        ) {
            Column(
                Modifier
                    .clipToBounds()
                    .background(Color.White)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Shipment Number", style = MaterialTheme.typography.bodyLarge.copy(color = grey))
                        Text(text = "NEJ20089934122231", style = MaterialTheme.typography.displayLarge, modifier = Modifier.padding(top = 5.dp))
                    }
                    Image(painter = painterResource(id = R.drawable.fork_lift), contentDescription = "fork lift icon", modifier = Modifier.size(40.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    Modifier
                        .padding(horizontal = 10.dp)
                        .height(1.dp)
                        .background(grey)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TrackingItem(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    trackingType = TrackingType.SENDER,
                    address = "Atlanta, 5243",
                    duration = "2 day -3 days"
                )
                Spacer(modifier = Modifier.height(30.dp))
                TrackingItem(modifier = Modifier
                    .padding(horizontal = 10.dp),
                    trackingType = TrackingType.RECEIVER,
                    address = "Chicago, 6342",
                    duration = "Waiting to collect"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    Modifier
                        .height(1.dp)
                        .background(grey)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "add",
                        tint = orange,
                        modifier = Modifier.size(20.dp),
                    )
                    Text(text = "Add Stop",
                        style = MaterialTheme.typography.titleMedium.copy(color = orange, fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

    }
}

@Composable
@Preview
fun TrackingSectionPreview() {
    TrackingSection()
}