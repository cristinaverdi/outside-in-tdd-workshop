package ports.adapters.workshop.outsideintdd.bookings.infrastructure.http

import com.google.gson.Gson
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById
import java.time.Instant

internal class BookingControllerTest {
    @Test
    fun `delegate get a booking by Id to GetBookingById`() {
        val id = "1234"
        val getBookingById = mockk<GetBookingById>(relaxed = true)
        val bookingsController = BookingController(getBookingById)

        bookingsController.getBookingById(id)

        verify { getBookingById.execute(id) }
    }

    @Test
    fun `should respond with a booking in json format when requested`() {
        val getBookingById = mockk<GetBookingById>()
        val bookingsController = BookingController(getBookingById)
        val id = "1234"
        val booking = Booking(id, Instant.now(), "3345", "00002")

        every { getBookingById.execute(id) } returns booking

        val expectedBooking = Gson().toJson(booking)

        assertThat(bookingsController.getBookingById(id)).isEqualTo(expectedBooking)
    }

}
