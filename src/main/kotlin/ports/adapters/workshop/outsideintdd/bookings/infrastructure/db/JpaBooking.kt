package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import java.time.Instant

class JpaBooking(
        val id: String,
        val startDate: Instant,
        val vehicleId: String,
        val userId: String,
        val price: Price)