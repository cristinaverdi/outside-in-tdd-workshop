package ports.adapters.workshop.outsideintdd.bookings.infrastructure.http

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ports.adapters.workshop.outsideintdd.Booking2
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetAllBookings
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById
import java.time.Instant

@RestController
class BookingController(
        private val getBookingById: GetBookingById,
        private val getAllBookings: GetAllBookings
) {

    @GetMapping("/api/v1/bookings")
    fun getBookingById(): List<Booking> = getAllBookings.execute()


    @GetMapping("/api/v1/bookings/{id}")
    fun getBookingById(@PathVariable id: String): Booking = getBookingById.execute(id)

}