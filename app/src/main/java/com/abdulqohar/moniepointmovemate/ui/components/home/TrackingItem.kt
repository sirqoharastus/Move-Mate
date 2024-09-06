package com.abdulqohar.moniepointmovemate.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulqohar.moniepointmovemate.R
import com.abdulqohar.moniepointmovemate.ui.theme.orange

@Composable
fun TrackingItem(
    modifier: Modifier = Modifier,
    trackingType: TrackingType,
    address: String,
    duration: String
) {
    val color = if(trackingType == TrackingType.SENDER) orange.copy(alpha = 0.4f) else Color.Green.copy(alpha = 0.4f)
    val type = if(trackingType == TrackingType.SENDER) "Sender" else "Receiver"
    val detail = if(trackingType == TrackingType.SENDER) "Time" else "Status"
    val box = if(trackingType == TrackingType.SENDER) R.drawable.sender_box else R.drawable.download_package

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .background(color, shape = CircleShape)
            .size(40.dp)
            .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = box), contentDescription = "flip icon", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Fit)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(35.dp)
                .weight(1f)
        ) {
            Text(text = type, style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black.copy(alpha = 0.6f)))
            Text(text = address, style = MaterialTheme.typography.titleMedium.copy(color = Color.Black))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .height(35.dp)
            .weight(1f)) {
            Text(text = detail, style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black.copy(alpha = 0.6f)))
            Row(verticalAlignment = Alignment.CenterVertically) {
                if(trackingType == TrackingType.SENDER) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFF4aca2d)),
                    )
                }
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = duration, style = MaterialTheme.typography.titleMedium.copy(color = Color.Black))
            }
        }
    }
}

@Composable
@Preview
fun TrackingItemPreview() {
    TrackingItem(
        trackingType = TrackingType.RECEIVER,
        address = "Atlanta, 2434",
        duration = "2 days -3 days"
    )
}

enum class TrackingType {
    SENDER, RECEIVER
}