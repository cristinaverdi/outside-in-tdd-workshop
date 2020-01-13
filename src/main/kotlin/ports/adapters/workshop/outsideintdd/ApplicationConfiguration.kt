package ports.adapters.workshop.outsideintdd

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ports.adapters.workshop.outsideintdd.bookings.interaction.BookingsRepository
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById

@Configuration
class ApplicationConfiguration {

    @Bean
    fun getBookingById(bookingsRepository: BookingsRepository): GetBookingById {
        return GetBookingById(bookingsRepository)
    }
}