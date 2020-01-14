package ports.adapters.workshop.outsideintdd.bookings.interaction

import ports.adapters.workshop.outsideintdd.bookings.domain.Booking

interface BookingRepository {
    fun findById(id: String): Booking

}
