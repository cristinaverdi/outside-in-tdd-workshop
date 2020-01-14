package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import java.time.Instant
import java.util.*

internal class H2BookingRepositoryTest {
    @Test
    fun `delegate to find a user by id to spring data repository`() {
        val bookingsSpringDataRepository = mockk<BookingsSpringDataRepository>(relaxed = true)
        val id = "q12"
        val bookingMapper = mockk<BookingMapper>(relaxed = true)
        val h2bookingRepository = H2BookingRepository(bookingsSpringDataRepository, bookingMapper)

        h2bookingRepository.findById(id)

        verify {
            bookingsSpringDataRepository.findById(id)
        }
    }

    @Test
    fun `delegate mapping from jpa to domain booking to BookingMapper`() {
        val bookingMapper = mockk<BookingMapper>(relaxed = true)
        val userId = "234"
        val id = "456"
        val startDate = Instant.now()
        val vehicleId = "567"

        val jpaBooking = JpaBooking(id, startDate, vehicleId, userId, Price(2, "EUR"))
        val bookingSpringDataRepository = mockk<BookingsSpringDataRepository>()
        val h2bookingRepository = H2BookingRepository(bookingSpringDataRepository, bookingMapper)

        every {
            bookingSpringDataRepository.findById(id)
        } returns Optional.of(jpaBooking)

        h2bookingRepository.findById(id)

        verify {
            bookingMapper.toDomain(jpaBooking)
        }
    }

}