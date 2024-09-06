package com.abdulqohar.moniepointmovemate.ui.components.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulqohar.moniepointmovemate.ui.animations.bounceClick
import com.abdulqohar.moniepointmovemate.ui.theme.tangerine
import com.abdulqohar.moniepointmovemate.util.noRippleClick

@Composable
fun ColumnScope.ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = tangerine,
        ),
        onClick = onClick,
        shape = RoundedCornerShape(36.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .align(Alignment.End)
            .padding(horizontal = 16.dp)
            .noRippleClick { onClick() }
            .bounceClick(),
    ) {
        Text(text = text, fontSize = 18.sp, style = MaterialTheme.typography.bodyLarge)
    }

}