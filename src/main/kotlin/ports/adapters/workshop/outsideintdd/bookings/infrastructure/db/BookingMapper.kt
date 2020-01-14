package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.springframework.stereotype.Component
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking

@Component
class BookingMapper {
    fun toDomain(jpaBooking: JpaBooking): Booking {
        throw UnsupportedOperationException()
    }

}
