package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.springframework.stereotype.Component

@Component
class BookingMapper {
    fun toDomain(jpaBooking: JpaBooking) {
        throw UnsupportedOperationException()
    }

}
