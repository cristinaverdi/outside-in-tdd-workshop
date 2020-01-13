package ports.adapters.workshop.outsideintdd.bookings.api

import com.google.gson.Gson
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById

internal class BookingsControllerTest {
    @Test
    fun `delegate get a booking by Id to GetBookingById`() {
        val id = "1234"
        val getBookingById = mockk<GetBookingById>(relaxed = true)
        val bookingsController = BookingsController(getBookingById)

        bookingsController.getBookingById(id)

        verify {
            getBookingById.execute(id)
        }
    }

    @Test
    fun `should respond with a booking in json format when requested`() {
        val getBookingById = mockk<GetBookingById>()
        val bookingsController = BookingsController(getBookingById)
        val id = "1234"
        val booking = Booking(id, "04-04-20T09:00", "3345", "00002", Price(30, "EUR"))

        every {
            getBookingById.execute(id)
        } returns booking

        val expectedBooking = Gson().toJson(booking)

        assertThat(bookingsController.getBookingById(id)).isEqualTo(expectedBooking)
    }


}
