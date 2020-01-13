package ports.adapters.workshop.outsideintdd.interaction

import ports.adapters.workshop.outsideintdd.domain.Booking

interface BookingsRepository {
    fun findById(id: String): Booking

}
