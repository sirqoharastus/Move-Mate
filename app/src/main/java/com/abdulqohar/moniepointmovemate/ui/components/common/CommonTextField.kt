package com.abdulqohar.moniepointmovemate.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abdulqohar.moniepointmovemate.ui.theme.darkBlue

@Composable
fun CustomTextField(
    textValue: String,
    onValChange: (String) -> Unit,
    placeHolder: String,
    icon: @Composable () -> Unit?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    trailingIcon: @Composable () -> Unit = {},
    backgroundColor: Color = Color(0xFFf8f8f8),
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 12.dp)
                .width(1.dp)
        )
        OutlinedTextField(
            value = textValue,
            onValueChange = onValChange,
            enabled = enabled,
            colors = OutlinedTextFieldDefaults.colors(
                disabledBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
                unfocusedContainerColor = backgroundColor,
                focusedContainerColor = backgroundColor,
                errorContainerColor = backgroundColor,
                focusedTextColor = Color.Black,
                unfocusedTextColor = darkBlue,
                errorTextColor = darkBlue,
                unfocusedPlaceholderColor = Color.Gray.copy(0.8f),
                focusedPlaceholderColor = Color.Gray.copy(0.8f),
            ),
            placeholder = { Text(placeHolder, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = trailingIcon,
            textStyle = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
        )
    }
}