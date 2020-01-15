package ports.adapters.workshop.outsideintdd.bookings.infrastructure.http

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetAllBookings
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById
import java.time.Instant

internal class BookingControllerTest {
    @Test
    fun `delegate get a booking by Id to GetBookingById`() {
        val id = "1234"
        val getBookingById = mockk<GetBookingById>(relaxed = true)
        val getAllBookings = mockk<GetAllBookings>()
        val bookingsController = BookingController(getBookingById, getAllBookings)

        bookingsController.getBookingById(id)

        verify { getBookingById.execute(id) }
    }

    @Test
    fun `return the booking retrieved by GetBookingById`() {
        val getBookingById = mockk<GetBookingById>()
        val getAllBookings = mockk<GetAllBookings>()
        val bookingsController = BookingController(getBookingById, getAllBookings)
        val id = "1234"
        val expectedBooking = Booking(id, Instant.now(), "3345", "00002")

        every { getBookingById.execute(id) } returns expectedBooking

        assertThat(bookingsController.getBookingById(id)).isEqualTo(expectedBooking)
    }

}
