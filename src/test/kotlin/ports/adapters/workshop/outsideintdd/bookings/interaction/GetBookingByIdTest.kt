package ports.adapters.workshop.outsideintdd.bookings.interaction

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import java.time.Instant

internal class GetBookingByIdTest {
    @Test
    fun `delegate to retrieve a booking by id  to bookings repository`() {
        val bookingsRepository = mockk<BookingRepository>(relaxed = true)
        val getBookingById = GetBookingById(bookingsRepository)
        val id = "1234"

        getBookingById.execute(id)

        verify { bookingsRepository.findById(id) }
    }

    @Test
    fun `return the booking retrieved by bookingsRepository`() {
        val bookingsRepository = mockk<BookingRepository>()

        val getBookingById = GetBookingById(bookingsRepository)
        val id = "1234"
        val expectedBooking = Booking(id, Instant.now(), "", "", Price(30, ""))

        every { bookingsRepository.findById(id) } returns expectedBooking

        assertThat(getBookingById.execute(id)).isEqualTo(expectedBooking)
    }

}
