package com.abdulqohar.moniepointmovemate.util

import com.abdulqohar.moniepointmovemate.ui.model.Item
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatus
import com.abdulqohar.moniepointmovemate.ui.model.ShipmentStatusLabel
import kotlinx.coroutines.flow.flowOf

val itemList = flowOf(
    listOf(
        Item(
            "Macbook pro M2",
            "#NE43857340857904",
            "Paris",
            "Morocco"
        ),
        Item(
            "Summer linen jacket",
            "#NEJ20089934122231",
            "Barcelona",
            "Paris"
        ),
        Item(
            "Tapered-fit jeans AW",
            "#NEJ35870264978659",
            "Colombia",
            "Paris"
        ),
        Item(
            "Slim fit jeans AW",
            "#NEJ35870264978659",
            "Bogota",
            "Dhaka"
        ),
        Item(
            "Office setup desk",
            "#NEJ23481570754963",
            "France",
            "German"
        ),
    )
)

val listOfShipmentStatus = listOf(
    ShipmentStatus(
        status = ShipmentStatusLabel.IN_PROGRESS,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023",
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.PENDING_ORDER,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.IN_PROGRESS,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.PENDING_ORDER,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.COMPLETED,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.PENDING_ORDER,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.CANCELLED,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.LOADING,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.PENDING_ORDER,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
    ShipmentStatus(
        status = ShipmentStatusLabel.COMPLETED,
        message = "Arriving today!",
        details = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today",
        amount = "$1400 USD",
        date = "Sep 20, 2023"
    ),
)
