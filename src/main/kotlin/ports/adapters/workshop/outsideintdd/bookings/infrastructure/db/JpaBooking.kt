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
)