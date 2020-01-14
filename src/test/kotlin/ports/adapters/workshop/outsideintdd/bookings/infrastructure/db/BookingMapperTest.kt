package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import java.time.Instant

class BookingMapperTest {
    @Test
    fun `maps JpaBooking to Booking`() {
        val id = "1234"
        val startDate = Instant.now()
        val vehicleId = "23"
        val userId = "userId"
        val jpaBooking = JpaBooking(id, startDate, vehicleId, userId)
        val expectedBooking = Booking(id, startDate, vehicleId, userId)

        val bookingMapper = BookingMapper()

        val booking = bookingMapper.toDomain(jpaBooking)

        assertThat(booking).usingRecursiveComparison().isEqualTo(expectedBooking)
    }

}