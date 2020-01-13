package ports.adapters.workshop.outsideintdd.bookings.interaction

import ports.adapters.workshop.outsideintdd.bookings.domain.Booking

class GetBookingById(private val bookingsRepository: BookingsRepository) {
    fun execute(id: String): Booking {
        return bookingsRepository.findById(id)
    }

}
