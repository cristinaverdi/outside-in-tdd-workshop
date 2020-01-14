package ports.adapters.workshop.outsideintdd.bookings.infrastructure.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingsSpringDataRepository: JpaRepository<JpaBooking, String>