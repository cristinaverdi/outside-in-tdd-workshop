package ports.adapters.workshop.outsideintdd

import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.infrastructure.db.BookingSpringDataRepository
import ports.adapters.workshop.outsideintdd.bookings.infrastructure.db.JpaBooking
import java.time.Instant


@ActiveProfiles("containerTest")
@SpringBootTest(
        classes = [OutsideInTddApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BookingContainerTest {
    @Autowired
    lateinit var bookingSpringDataRepository: BookingSpringDataRepository

    @LocalServerPort
    private val port: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    fun `get booking by Id`() {
        val id = "abcd"
        val startDate = Instant.parse("2020-01-15T02:31:12.821Z")
        val vehicleId = "123"
        val userId = "9802"
        val booking = Booking(id, startDate, vehicleId, userId)
        val jpaBooking = JpaBooking(id, startDate, vehicleId, userId)

        bookingSpringDataRepository.save(jpaBooking)

        Given {
            pathParam("id", id)
        } When {
            get("/api/v1/bookings/{id}")
        } Then {
            statusCode(HttpStatus.OK.value())
            contentType(MediaType.APPLICATION_JSON_VALUE)
            body(equalTo(Gson.gson.toJson(booking)))
        }
    }

}


