package ports.adapters.workshop.outsideintdd.interaction

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

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

}