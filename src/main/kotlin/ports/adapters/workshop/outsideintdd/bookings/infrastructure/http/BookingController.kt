package ports.adapters.workshop.outsideintdd.bookings.infrastructure.http

import com.google.gson.Gson
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetAllBookings
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById

@RestController
class BookingController(private val getBookingById: GetBookingById, private val getAllBookings: GetAllBookings) {

    @GetMapping("/api/v1/bookings", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBookingById(): List<Booking> = getAllBookings.execute()


    @GetMapping("/api/v1/bookings/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBookingById(@PathVariable id: String): String {
        val booking = getBookingById.execute(id)
        return Gson().toJson(booking)
    }
}