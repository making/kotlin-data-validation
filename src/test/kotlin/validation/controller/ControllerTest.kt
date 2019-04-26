package validation.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import validation.model.JavaUser
import validation.model.KotlinUser

@ExtendWith(SpringExtension::class)
@WebFluxTest(Controller::class)
class ControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `java user validation`() {
        val javaUser = JavaUser()
        javaUser.name = "sadfjsjdfhsjdf"
        javaUser.phones = listOf("dfhgd")

        webTestClient.put().uri("/user/java")
            .body(BodyInserters.fromObject(javaUser))
            .exchange()
            .expectStatus().is4xxClientError
    }

    @Test
    fun `kotlin user validation`() {
        val kotlinUser = KotlinUser(name = "sadfjsjdfhsjdf", phones = listOf("dfhgd"))

        webTestClient.put().uri("/user/kotlin")
            .body(BodyInserters.fromObject(kotlinUser))
            .exchange()
            .expectStatus().is4xxClientError
    }
}
