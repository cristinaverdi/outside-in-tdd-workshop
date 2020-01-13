package ports.adapters.workshop.outsideintdd

import com.google.gson.Gson
import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import ports.adapters.workshop.outsideintdd.bookings.domain.Booking
import ports.adapters.workshop.outsideintdd.bookings.domain.Price

@SpringBootTest(
        classes = [OutsideInTddApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BookingsContainerTest {
    @LocalServerPort
    private val port: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    fun `get booking by Id`() {
        Given {
            pathParam("id", "1239")
        } When {
            get("/api/v1/bookings/{id}")
        } Then {
            val id = "1234"
            val startDate = "04-01-2019T09:00"
            val vehicleId = "123"
            val userId = "9802"
            val value = 30
            val currency = "EUR"
            val price = Price(value, currency)
            val booking = Booking(id, startDate, vehicleId, userId, price)

            body(equalTo(Gson().toJson(booking)))
            statusCode(HttpStatus.OK.value())
        }
    }
}
