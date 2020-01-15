package ports.adapters.workshop.outsideintdd

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import ports.adapters.workshop.outsideintdd.bookings.interaction.BookingRepository
import ports.adapters.workshop.outsideintdd.bookings.interaction.GetBookingById


@Configuration
class ApplicationConfiguration {

    @Bean
    fun getBookingById(bookingRepository: BookingRepository): GetBookingById {
        return GetBookingById(bookingRepository)
    }

    @Bean("dataSource")
    fun dataSourceProduction(): EmbeddedDatabase {
        return EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("DB1")
                .addScript("production-schema.sql")
                .addScript("production-data.sql")
                .build()
    }

    @Profile("containerTest")
    @Bean("dataSource")
    fun dataSourceContainerTest(): EmbeddedDatabase {
        return EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("DB2")
                .build()
    }

}