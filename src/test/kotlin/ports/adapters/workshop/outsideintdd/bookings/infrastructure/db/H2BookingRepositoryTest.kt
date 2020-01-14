package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
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
        val jpaBooking = mockk<JpaBooking>()

        every { bookingsSpringDataRepository.findById(id) } returns Optional.of(jpaBooking)

        h2bookingRepository.findById(id)

        verify { bookingsSpringDataRepository.findById(id) }
    }

    @Test
    fun `delegate mapping from jpa to domain booking to BookingMapper`() {
        val bookingMapper = mockk<BookingMapper>(relaxed = true)
        val userId = "234"
        val id = "456"
        val startDate = Instant.now()
        val vehicleId = "567"
        val jpaBooking = JpaBooking(id, startDate, vehicleId, userId)

        val bookingSpringDataRepository = mockk<BookingsSpringDataRepository>()
        val h2bookingRepository = H2BookingRepository(bookingSpringDataRepository, bookingMapper)

        every { bookingSpringDataRepository.findById(id) } returns Optional.of(jpaBooking)

        h2bookingRepository.findById(id)

        verify { bookingMapper.toDomain(jpaBooking) }
    }

    @Test
    fun `keeps domain booking unmodified`() {
        val id = "789"
        val now = Instant.now()
        val expectedBooking = Booking(id, now, "12", "13", Price(30, "EUR"))
        val jpaBooking = JpaBooking(id, now, "12", "13")

        val bookingsSpringDataRepository = mockk<BookingsSpringDataRepository>(relaxed = true)
        val bookingMapper = mockk<BookingMapper>()

        every { bookingsSpringDataRepository.findById(id) } returns Optional.of(jpaBooking)

        every { bookingMapper.toDomain(jpaBooking) } returns expectedBooking

        val h2BookingRepository = H2BookingRepository(bookingsSpringDataRepository, bookingMapper)
        val booking = h2BookingRepository.findById(id)

        assertThat(booking).isEqualTo(expectedBooking)
    }

    @Test
    fun `fail when booking not found`() {
        val bookingMapper = mockk<BookingMapper>(relaxed = true)
        val bookingsSpringDataRepository = mockk<BookingsSpringDataRepository>(relaxed = true)

        val h2bookingRepository = H2BookingRepository(bookingsSpringDataRepository, bookingMapper)
        val id = ""

        every { bookingsSpringDataRepository.findById(id) } returns Optional.empty()

        val exception = catchThrowable {
            h2bookingRepository.findById(id)
        }

        assertThat(exception).isExactlyInstanceOf(RuntimeException::class.java)
    }
}