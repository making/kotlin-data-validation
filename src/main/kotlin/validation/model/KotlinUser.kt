package validation.model

import am.ik.yavi.builder.ValidatorBuilder
import am.ik.yavi.builder.forEach
import am.ik.yavi.builder.konstraint

data class KotlinUser(val name: String,
                      val phones: List<String>) {
    companion object {
        val validator = ValidatorBuilder.of<KotlinUser>()
                .konstraint(KotlinUser::name) {
                    notEmpty()
                            .notNull()
                            .pattern("[a-z]*").message("Only lower case first name")
                }
                .forEach(KotlinUser::phones, {
                    constraint(String::toString, "value") {
                        it.notNull().notEmpty().pattern("\\d{10}").message("Only 10 digits")
                    }
                })
                .build()
    }

    fun validate() = validator.validateToEither(this)
}
