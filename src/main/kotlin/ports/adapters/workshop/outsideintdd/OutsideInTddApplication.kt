package ports.adapters.workshop.outsideintdd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ports.adapters.workshop.outsideintdd.bookings.domain.Price
import java.time.Instant

@SpringBootApplication
class OutsideInTddApplication

fun main(args: Array<String>) {
	runApplication<OutsideInTddApplication>(*args)
}

data class Booking2(
		val id: String,
		val vehicleId: String,
		val startDate: Instant,
		val userId: String) {
}
