package ports.adapters.workshop.outsideintdd.bookings.domain

data class Booking(
        val id: String,
        val startDate: String,
        val vehicleId: String,
        val userId: String,
        val price: Price
)
