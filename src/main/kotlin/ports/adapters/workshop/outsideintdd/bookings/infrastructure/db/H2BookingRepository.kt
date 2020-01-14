package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.springframework.stereotype.Component
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.interaction.BookingRepository

@Component
class H2BookingRepository(
        private val bookingsSpringDataRepository: BookingsSpringDataRepository,
        private val bookingMapper: BookingMapper
): BookingRepository {

    override fun findById(id: String): Booking {
        val jpaBooking = bookingsSpringDataRepository.findById(id).orElseThrow { RuntimeException() }
        return bookingMapper.toDomain(jpaBooking)
    }
}
