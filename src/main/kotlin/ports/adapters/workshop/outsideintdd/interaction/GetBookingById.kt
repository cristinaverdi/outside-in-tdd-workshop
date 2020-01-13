package ports.adapters.workshop.outsideintdd.interaction

import ports.adapters.workshop.outsideintdd.domain.Booking
import java.lang.UnsupportedOperationException

class GetBookingById {
    fun execute(id: String): Booking {
        throw UnsupportedOperationException() as Throwable
    }

}
