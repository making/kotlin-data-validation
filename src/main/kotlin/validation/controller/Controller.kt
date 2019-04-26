package validation.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import validation.model.JavaUser
import validation.model.KotlinUser
import javax.validation.Valid

@RestController
class Controller {
    @PutMapping("/user/java")
    fun putUser(@RequestBody @Valid javaUser: JavaUser): Mono<ResponseEntity<String>> =
        Mono.just(ResponseEntity("shouldn't get this", HttpStatus.OK))

    @PutMapping("/user/kotlin")
    fun putUser(@RequestBody @Valid kotlinUser: KotlinUser): Mono<ResponseEntity<String>> =
        Mono.just(ResponseEntity("shouldn't get this", HttpStatus.OK))
}
