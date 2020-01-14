package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.springframework.stereotype.Component
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import ports.adapters.workshop.outsideintdd.bookings.interaction.BookingRepository
import java.time.Instant

@Component
class H2BookingRepository(
        private val bookingsSpringDataRepository: BookingsSpringDataRepository,
        private val bookingMapper: BookingMapper
): BookingRepository {

    override fun findById(id: String): Booking {
        val jpaBooking = bookingsSpringDataRepository.findById(id).get()
        bookingMapper.toDomain(jpaBooking)

        return Booking("", Instant.now(), "", "", Price(2, ""))
    }
}
