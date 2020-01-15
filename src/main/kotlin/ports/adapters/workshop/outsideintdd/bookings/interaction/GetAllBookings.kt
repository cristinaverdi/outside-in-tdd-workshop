package ports.adapters.workshop.outsideintdd.bookings.interaction

import org.springframework.stereotype.Component
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking

@Component
class GetAllBookings(private val bookingRepository: BookingRepository) {
    fun execute(): List<Booking> = bookingRepository.findAll()

}
