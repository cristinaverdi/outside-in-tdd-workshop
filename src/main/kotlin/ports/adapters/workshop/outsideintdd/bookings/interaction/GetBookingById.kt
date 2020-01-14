package ports.adapters.workshop.outsideintdd.bookings.interaction

import ports.adapters.workshop.outsideintdd.bookings.domain.Booking

class GetBookingById(private val bookingRepository: BookingRepository) {
    fun execute(id: String): Booking {
        return bookingRepository.findById(id)
    }

}
