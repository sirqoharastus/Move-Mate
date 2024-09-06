package com.abdulqohar.moniepointmovemate.ui.components.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abdulqohar.moniepointmovemate.ui.animations.bounceClick
import com.abdulqohar.moniepointmovemate.ui.theme.Snow
import com.abdulqohar.moniepointmovemate.ui.theme.indigo

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterChipGroup(
    items: List<String>,
    defaultSelectedItemIndex: Int = -1,
    selectedItemIcon: ImageVector = Icons.Filled.Done,
    onSelectedChanged: (Int) -> Unit = {}
) {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    FlowRow {
        items.forEachIndexed { index, item ->
            val isSelected = items[selectedItemIndex] == item
            FilterChip(
                modifier = Modifier
                    .padding(end = 6.dp)
                    .bounceClick()
                    .background(Snow)
                    .animateContentSize(),
                selected = if (defaultSelectedItemIndex == -1) false else isSelected,
                onClick = {
                    selectedItemIndex = index
                    onSelectedChanged(index)
                },
                label = {
                    Text(
                        item,
                        color = if (isSelected) Color.White else indigo,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                leadingIcon = if (isSelected) {
                    {
                        Icon(
                            imageVector = selectedItemIcon,
                            contentDescription = "Localized Description",
                            modifier = Modifier.size(FilterChipDefaults.IconSize),
                            tint = Color.White
                        )
                    }
                } else null,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (isSelected) indigo else Snow
                ),
                border = if (isSelected) null else FilterChipDefaults.filterChipBorder()
            )
        }
    }
}