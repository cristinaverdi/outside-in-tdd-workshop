package ports.adapters.workshop.outsideintdd.bookings.domain

import java.time.Instant

data class Booking(
        val id: String,
        val startDate: Instant,
        val vehicleId: String,
        val userId: String,
        val price: Price = Price()
)