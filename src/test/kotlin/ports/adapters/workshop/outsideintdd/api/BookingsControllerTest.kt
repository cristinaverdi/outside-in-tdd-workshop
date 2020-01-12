package ports.adapters.workshop.outsideintdd.api

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import ports.adapters.workshop.outsideintdd.bookings.api.BookingsController
import ports.adapters.workshop.outsideintdd.interaction.GetBookingById

internal class BookingsControllerTest {
    @Test
    fun `delegate to GetBookingById`() {
        val id = "1234"
        val getBookingById = mockk<GetBookingById>(relaxed = true)
        val bookingsController = BookingsController(getBookingById)

        bookingsController.getBookingById(id)

        verify {
            getBookingById.execute(id)
        }
    }


}