package ports.adapters.workshop.outsideintdd.bookings.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ports.adapters.workshop.outsideintdd.interaction.GetBookingById
import java.lang.UnsupportedOperationException

@RestController
class BookingsController(private val getBookingById: GetBookingById) {
    @GetMapping("/api/v1/bookings/{id}")
    fun getBookingById(@PathVariable id: String) {
        getBookingById.execute(id)
    }

}