package ports.adapters.workshop.outsideintdd

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ports.adapters.workshop.outsideintdd.interaction.GetBookingById

@Configuration
class ApplicationConfiguration {

    @Bean
    fun getBookingById(): GetBookingById {
        return GetBookingById()
    }
}