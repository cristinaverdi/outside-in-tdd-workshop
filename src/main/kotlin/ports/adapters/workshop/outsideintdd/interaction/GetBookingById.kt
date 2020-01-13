package ports.adapters.workshop.outsideintdd.interaction

import ports.adapters.workshop.outsideintdd.domain.Booking

class GetBookingById(private val bookingsRepository: BookingsRepository) {
    fun execute(id: String): Booking {
        return bookingsRepository.findById(id)
    }

}
