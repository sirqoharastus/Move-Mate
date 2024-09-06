package com.abdulqohar.moniepointmovemate.ui.model

import androidx.compose.ui.graphics.Color
import com.abdulqohar.moniepointmovemate.R
import com.abdulqohar.moniepointmovemate.ui.theme.orange

data class ShipmentStatus(
    val status: ShipmentStatusLabel,
    val message: String,
    val details: String,
    val amount: String,
    val date: String,
)

enum class ShipmentStatusLabel(
    val id: Int,
    val title: String,
    val tag: String,
    val icon: Int,
    val color: Color,
) {
    ALL(0, "All", "all", R.drawable.ic_add, Color.Magenta),
    COMPLETED(1, "Completed", "completed", R.drawable.ic_check, Color.Green),
    PENDING_ORDER(2, "Pending order", "pending", R.drawable.ic_pending, orange),
    IN_PROGRESS(3, "In-progress", "in-progress", R.drawable.ic_inprogress, Color.Green),
    LOADING(4, "Loading", "loading", R.drawable.ic_loading, Color.Blue),
    CANCELLED(5, "Cancelled", "cancelled", R.drawable.ic_cancel, Color.Red),
}