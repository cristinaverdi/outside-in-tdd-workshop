package ports.adapters.workshop.outsideintdd

import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext

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
            statusCode(HttpStatus.OK.value())
            val expectedBody = """
               id: "1239",
               startDate: "04-01-2019T09:00", 
               vehicleId: "123",
               userId: "9802"
               price: "30",
               currency: "EUR"
            """
            body(equalTo(expectedBody))
        }
    }
}
