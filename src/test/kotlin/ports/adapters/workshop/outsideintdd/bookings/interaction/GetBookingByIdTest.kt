package ports.adapters.workshop.outsideintdd.bookings.interaction

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.domain.Price

internal class GetBookingByIdTest {
    @Test
    fun `delegate to retrieve a booking by id  to bookings repository`() {
        val bookingsRepository = mockk<BookingsRepository>(relaxed = true)
        val getBookingById = GetBookingById(bookingsRepository)
        val id = "1234"

        getBookingById.execute(id)

        verify {
            bookingsRepository.findById(id)
        }
    }

    @Test
    fun `return the booking retrieved by bookingsRepository`() {
        val bookingsRepository = mockk<BookingsRepository>()

        val getBookingById = GetBookingById(bookingsRepository)
        val id = "1234"
        val expectedBooking = Booking(id, "", "", "", Price(30, ""))

        every {
            bookingsRepository.findById(id)
        } returns expectedBooking

        assertThat(getBookingById.execute(id)).isEqualTo(expectedBooking)
    }

}
