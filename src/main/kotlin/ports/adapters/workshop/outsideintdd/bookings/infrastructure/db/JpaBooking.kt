package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "BOOKINGS")
class JpaBooking(
        @Id val id: String,
        val startDate: Instant,
        val vehicleId: String,
        val userId: String
) {
    operator fun component1(): String = id
    operator fun component2(): Instant = startDate
    operator fun component3(): String = vehicleId
    operator fun component4(): String = userId
}