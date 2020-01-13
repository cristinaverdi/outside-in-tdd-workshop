package ports.adapters.workshop.outsideintdd.bookings.api

import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById

@RestController
class BookingsController(private val getBookingById: GetBookingById) {

    @GetMapping("/api/v1/bookings/{id}")
    fun getBookingById(@PathVariable id: String): String {
        val booking = getBookingById.execute(id)
        return Gson().toJson(booking)
    }
}