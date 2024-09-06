package com.abdulqohar.moniepointmovemate.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatus
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatusLabel
import com.abdulqohar.moniepointmovemate.util.listOfShipmentStatus

class ShipmentViewModel : ViewModel() {
    fun getUpdatedStatusLabelList(selectedId: Int): List<ShipmentStatus> {
        val selectedStatusLabel =
            ShipmentStatusLabel.entries.find { label -> label.id == selectedId }
                ?: ShipmentStatusLabel.ALL

        return if (selectedStatusLabel == ShipmentStatusLabel.ALL)
            listOfShipmentStatus
        else
            listOfShipmentStatus.filter { it.status == selectedStatusLabel }
    }
}