package validation.model

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class KotlinUser(
    @field:NotEmpty
    @field:NotNull
    @field:Pattern(regexp = "[a-z]*", message = "Only lower case first name")
    val name: String,

    val phones: List<
        @NotNull
        @NotEmpty
        @Pattern(regexp = "\\d{10}", message = "Only 10 digits")
        String>
)
